package com.example.fourthstudy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="debt")//schema="..."
public class Debt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
