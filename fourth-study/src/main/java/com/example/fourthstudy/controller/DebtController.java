package com.example.fourthstudy.controller;

import com.example.fourthstudy.service.DebtService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/debt")
public class DebtController {

    private final DebtService debtService;
    public DebtController(DebtService debtService) {
        this.debtService = debtService;
    }
}
