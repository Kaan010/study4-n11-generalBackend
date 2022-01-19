package com.example.fourthstudy.dao;

import com.example.fourthstudy.model.Debt;
import com.example.fourthstudy.model.Receive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiveDao extends JpaRepository<Receive,Long> {

    List<Receive> findAllByUserId(Long userId);

}
