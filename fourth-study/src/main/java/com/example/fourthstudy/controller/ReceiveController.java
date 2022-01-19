package com.example.fourthstudy.controller;


import com.example.fourthstudy.model.Debt;
import com.example.fourthstudy.service.ReceiveService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/v1/receive")
public class ReceiveController {

    private final ReceiveService receiveService;
    private String user;

    public ReceiveController(ReceiveService receiveService) {
        this.receiveService = receiveService;
    }

    //4.d. Kullanıcının ödediği toplam gecikme zammı listelenebilmelidir
    @GetMapping(value=  "user/{id}")
    public ResponseEntity<?> getAllLateFeeOfUser(@PathVariable Long id) {
        return new ResponseEntity<>(
                receiveService.getTotalLateFeeUser(id),
                HttpStatus.CREATED);
    }

    //4.c. Kullanıcının tüm tahsilatları listelenebilmelidir.
    @GetMapping(value=  "user/all/{id}")
    public ResponseEntity<?> getAllReceivesOfUser(@PathVariable Long id) {
        return new ResponseEntity<>(
                receiveService.getAllReceivesOfUser(id),
                HttpStatus.CREATED);
    }

    //4.b. Belirtilen tarihler arasında yapılan tahsilatlar listelenebilmelidir
    @GetMapping(value = "fetch/{first_date}/{last_date}")
    public ResponseEntity<?> getDebtsBetweenDates(@PathVariable(value = "first_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime fromDate,
                                                  @PathVariable(value = "last_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime toDate) {
        return new ResponseEntity<>(
                receiveService.findReceivesBetweenDates(fromDate,toDate),
                HttpStatus.OK);
    }

    //verilen borcu ödeme yap
    @PostMapping()
    public ResponseEntity<?> payDebt(@RequestBody Debt debt) { //TODO: Add Valid annotation
        return new ResponseEntity<>(
                receiveService.createReceipt(debt),
                HttpStatus.CREATED);
    }

}
