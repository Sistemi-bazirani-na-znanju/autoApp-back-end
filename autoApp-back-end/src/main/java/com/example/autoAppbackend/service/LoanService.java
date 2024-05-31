package com.example.autoAppbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.autoAppbackend.model.Loan;
import com.example.autoAppbackend.repository.LoanRepository;

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
        return loanRepository.save(loan);
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
