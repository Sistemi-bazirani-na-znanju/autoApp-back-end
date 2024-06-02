package com.example.autoAppbackend.service;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.autoAppbackend.model.Loan;
import com.example.autoAppbackend.repository.LoanRepository;
import com.example.autoAppbackend.util.Doubble;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public Loan getById(int id) {
        return loanRepository.getById(id);
    }

    public Loan create(Loan loan) {
        Loan loan2 = loanRepository.save(loan);
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        KieSession ksession = kc.newKieSession("loanRulesSession");

        long userIdLong = loan.getUser().getId();
        int userIdInt = (int) userIdLong;

        List<Loan> loansAlready = getAllUserLoans(userIdInt);
        double monthlyExpenses = 0.0;

        if (!loansAlready.isEmpty()) {
            for (Loan userLoan : loansAlready) {
                if (userLoan.getEndDate().isAfter(LocalDateTime.now())) {
                    monthlyExpenses += userLoan.getAmount() / userLoan.getNumberOfInstallments();
                }
            }
        }

        System.out.println("Ukupna potrosnje userova mjesecno je: " +  monthlyExpenses);

        ksession.setGlobal("costAlready", new Doubble(monthlyExpenses));
        ksession.insert(loan2);
        ksession.fireAllRules();
        QueryResults results = ksession.getQueryResults("decideIfCapable");

        for (QueryResultsRow row : results) {
            loan2.setApproved(true);

        }
        return loanRepository.save(loan2);
    }

    public void delete(int id) {
        loanRepository.deleteById(id);
    }

    public List<Loan> getAll() {
        return loanRepository.findAll();
    }

    public List<Loan> getAllUserLoans(int userId) {
        List<Loan> loans = loanRepository.findAll();
        return loans.stream().filter(loan -> loan.getUser().getId() == userId).collect(Collectors.toList());
    }
}
