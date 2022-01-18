package com.example.fourthstudy.model;

import com.example.fourthstudy.model.helperModels.DebtType;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="receive",schema = "fifthhw")//schema="..."
public class Receive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="main_debt",nullable = false)
    private Long mainDebt;

    @Column(name="remaining_debt",nullable = false)
    private Long remainingDebt;

    @Column(name="debt_type",nullable = false)
    private DebtType debtType;

    @Column(name="debt_id",nullable = false)
    private Long debtId;

    @Column(name="user_id",nullable = false)
    private Long userId;

    @Column(name="operation_time",nullable = false)
    private LocalDateTime operationTime;



}
