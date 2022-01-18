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

    private DebtType debtType;

    private Long mainDebt;

    private Long remainingDebt;

    @Column(name="due_date",nullable = false)
    private LocalDateTime dueDate;



}
