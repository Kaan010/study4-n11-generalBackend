package com.example.fourthstudy.dao;

import com.example.fourthstudy.model.Debt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebtDao extends JpaRepository<Debt,Long> {
}
