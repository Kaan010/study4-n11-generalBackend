package com.example.fourthstudy.dao;

import com.example.fourthstudy.model.Debt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DebtDao extends JpaRepository<Debt, Long> {

    @Query(nativeQuery = true, value = "select * from Debt d where d.creation_date between :startDate and :endDate")
    List<Debt> getDebts_between(@Param("startDate") LocalDateTime date, @Param("endDate") LocalDateTime date2);

    List<Debt> findAllByUserId(Long userId);

    List<Debt> findAllByUserIdAndDueDateAfterAndRemainingDebtGreaterThan(Long userId, LocalDateTime dueDate,Long remainingDebt);

    List<Debt> findAllByUserIdAndRemainingDebtGreaterThan(Long userId, Long remainingDebt);


}
