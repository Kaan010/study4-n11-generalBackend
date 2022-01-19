package com.example.fourthstudy.controller;


import com.example.fourthstudy.model.Debt;
import com.example.fourthstudy.service.ReceiveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/v1/receive")
public class ReceiveController {

    private final ReceiveService receiveService;
    private String user;

    public ReceiveController(ReceiveService receiveService) {
        this.receiveService = receiveService;
    }
    
    @GetMapping(value=  "user/{id}")
    public ResponseEntity<?> getAllLateFeeOfUser(@PathVariable Long id) { //TODO: Add Valid annotation
        return new ResponseEntity<>(
                receiveService.getTotalLateFeeUser(id),
                HttpStatus.CREATED);
    }


    @PostMapping()
    public ResponseEntity<?> payDebt(@RequestBody Debt debt) { //TODO: Add Valid annotation
        return new ResponseEntity<>(
                receiveService.createReceipt(debt),
                HttpStatus.CREATED);
    }

}
