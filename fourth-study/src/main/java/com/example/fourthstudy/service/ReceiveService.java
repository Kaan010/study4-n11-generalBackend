package com.example.fourthstudy.service;

import com.example.fourthstudy.dao.ReceiveDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)

public class ReceiveService {
    public final ReceiveDao receiveDao;

}
