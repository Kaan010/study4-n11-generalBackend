package com.example.fourthstudy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="user")//schema="..."
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",length = 100,nullable = false)
    private String name;
}
