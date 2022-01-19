package com.example.fourthstudy.model;

import com.example.fourthstudy.model.helperModels.DebtType;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="debt",schema = "fifthhw")//schema="..."
public class Debt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="main_debt",nullable = false)
    private Long mainDebt;

    @Column(name="remaining_debt",nullable = false)
    private Long remainingDebt;

    @Column(name="creation_date",nullable = false)
    private LocalDateTime creationDate;

    @Column(name="due_date",nullable = false)
    private LocalDateTime dueDate;

    @Column(name="user_id",nullable = false)
    private Long userId;

    @Transient
    private Long lateFee;



}
