package com.example.fourthstudy.controller;


import com.example.fourthstudy.service.ReceiveService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/receive")
public class ReceiveController {

    private final ReceiveService receiveService;
    public ReceiveController(ReceiveService receiveService) {
        this.receiveService = receiveService;
    }
}
