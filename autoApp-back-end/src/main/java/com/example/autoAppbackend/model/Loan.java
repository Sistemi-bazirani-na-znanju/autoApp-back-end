package com.example.autoAppbackend.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Loan  extends GenericEntity{
    @OneToOne(fetch = FetchType.EAGER)
    @NotNull
    private User user;

    @Column
    private int numberOfInstallments;

    @Column
    private boolean approved;
    
    @Column
    private LocalDateTime startDate;

    @Column
    private LocalDateTime endDate;

    @Column
    private double amount;

    @Column
    private UserEmploymentStatus status;

    @Column
    private LocalDateTime employmentStartDate;

    @Column
    private LocalDateTime employmentEndDate;

}
