package com.example.autoAppbackend.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.kie.api.definition.type.Position;

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

     @Position(0)
    @OneToOne(fetch = FetchType.EAGER)
    @NotNull
    private User user;

    @Position(1)
    @Column
    private int numberOfInstallments;

    @Position(2)
    @Column
    private boolean approved;
    
    @Position(3)
    @Column
    private LocalDateTime startDate;

    @Position(4)
    @Column
    private LocalDateTime endDate;

    @Position(5)
    @Column
    private double amount;

    @Position(6)
    @Column
    private UserEmploymentStatus status;

    @Position(7)
    @Column
    private LocalDateTime employmentStartDate;

    @Position(8)
    @Column
    private LocalDateTime employmentEndDate;

    @Position(9)
    @Column
    private double salary;

    @Position(10)
    @Column
    private Integer age;

}
