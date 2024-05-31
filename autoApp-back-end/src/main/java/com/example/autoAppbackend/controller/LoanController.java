package com.example.autoAppbackend.controller;

import com.example.autoAppbackend.dto.LoanDTO;
import com.example.autoAppbackend.model.Loan;
import com.example.autoAppbackend.model.User;
import com.example.autoAppbackend.service.LoanService;
import com.example.autoAppbackend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/loans")
public class LoanController {

    @Autowired
    LoanService loanService;

    @Autowired
    UserService userService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoanDTO> getById(@PathVariable int id) {
        Loan loan = loanService.getById(id);
        if (loan!= null) {
            return new ResponseEntity<>(new LoanDTO(loan), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LoanDTO>> getAll() {
        List<Loan> Loans = loanService.getAll();
      
        List<LoanDTO> LoanDto = new ArrayList<>();
        for(Loan r : Loans){
            LoanDto.add(new LoanDTO(r));
        }

        return new ResponseEntity<>(LoanDto, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoanDTO> create(@RequestBody LoanDTO loanCreationDTO) {
        System.out.println("Create method hit!" + loanCreationDTO);
        Loan loan = new Loan();
        User user = userService.getById(loanCreationDTO.getUser().getId());
        if(user != null){
            loan.setUser(user);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }   
        loan.setAmount(loanCreationDTO.getAmount());
        loan.setApproved(false);
        loan.setEmploymentEndDate(loanCreationDTO.getEmploymentEndDate());
        loan.setEmploymentStartDate(loanCreationDTO.getEmploymentStartDate());
        loan.setEndDate(loanCreationDTO.getEndDate());
        loan.setStartDate(loanCreationDTO.getStartDate());
        loan.setNumberOfInstallments(loanCreationDTO.getNumberOfInstallments());
        loan.setStatus(loanCreationDTO.getStatus());

        LoanDTO createdLoan = new LoanDTO(loanService.create(loan));
        return new ResponseEntity<>(createdLoan, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        loanService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LoanDTO>> getAllUserLoans(@PathVariable int userId) {
        List<Loan> Loans = loanService.getAllUserLoans(userId);
      
        List<LoanDTO> LoanDto = new ArrayList<>();
        for(Loan r : Loans){
            LoanDto.add(new LoanDTO(r));
        }

        return new ResponseEntity<>(LoanDto, HttpStatus.OK);
    }
}
