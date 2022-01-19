package com.example.fourthstudy.dao;

import com.example.fourthstudy.model.Debt;
import com.example.fourthstudy.model.Receive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReceiveDao extends JpaRepository<Receive,Long> {

    List<Receive> findAllByUserId(Long userId);

    @Query(nativeQuery = true, value = "select * from Receive r where r.operation_time between :startDate and :endDate")
    List<Debt> getReceives_between(LocalDateTime fromDate, LocalDateTime toDate);
}
