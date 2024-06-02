package com.example.autoAppbackend.dto;

import java.time.LocalDateTime;

import com.example.autoAppbackend.model.Loan;
import com.example.autoAppbackend.model.UserEmploymentStatus;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanDTO {
    private Integer id;
    private UserDTO user;
    private int numberOfInstallments;
    private boolean approved;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double amount;
    private UserEmploymentStatus status;
    private LocalDateTime employmentStartDate;
    private LocalDateTime employmentEndDate;
    private double salary;
    private int age;

    public LoanDTO(Loan loan){
        this.id = loan.getId();
        this.user = new UserDTO(loan.getUser());
        this.numberOfInstallments = loan.getNumberOfInstallments();
        this.approved = loan.isApproved();
        this.startDate = loan.getStartDate();
        this.endDate = loan.getEndDate();
        this.amount = loan.getAmount();
        this.employmentStartDate = loan.getEmploymentStartDate();
        this.employmentEndDate = loan.getEmploymentEndDate();
        this.status = loan.getStatus();
        this.salary = loan.getSalary();
        this.age = loan.getAge();
        
    }
}
