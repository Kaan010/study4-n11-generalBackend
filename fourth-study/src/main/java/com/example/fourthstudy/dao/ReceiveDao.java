package com.example.fourthstudy.dao;

import com.example.fourthstudy.model.Receive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiveDao extends JpaRepository<Receive,Long> {
}
