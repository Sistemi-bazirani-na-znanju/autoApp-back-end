package com.example.autoAppbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.autoAppbackend.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer> {}