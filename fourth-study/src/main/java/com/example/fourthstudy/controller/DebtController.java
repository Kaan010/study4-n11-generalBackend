package com.example.fourthstudy.controller;

import com.example.fourthstudy.model.Debt;
import com.example.fourthstudy.service.DebtService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1/debt")
public class DebtController {

    private final DebtService debtService;
    public DebtController(DebtService debtService, UserController userController) {
        this.debtService = debtService;
    }

    @GetMapping
    public ResponseEntity<?> getAllDebts() {
        return new ResponseEntity<>(
                debtService.findAllDebts(),
                HttpStatus.OK
        );
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getDebtById(@PathVariable Long id) {
        return new ResponseEntity<>(
                debtService.findDebtById(id),
                HttpStatus.OK);
    }

    @GetMapping(value = "fetch/{first_date}/{last_date}")
    public ResponseEntity<?> getDebtsBetweenDates(@PathVariable(value = "first_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate,
                                                 @PathVariable(value = "last_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toDate) {
        return new ResponseEntity<>(
                debtService.findDebtsBetweenDates(fromDate,toDate),
                HttpStatus.OK);
    }

    @GetMapping(value = "user/{id}}")
    public ResponseEntity<?> getDebtsOfAUser(@PathVariable Long id) {
        return new ResponseEntity<>(
                debtService.getDebtsOfAUser(id),
                HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<?> createDebt( @RequestBody Debt debt) { //TODO: Add Valid annotation
        return new ResponseEntity<>(
                debtService.createDebt(debt),
                HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateDebt(@PathVariable Long id, @RequestBody Debt debt) {
        return new ResponseEntity<>(
                debtService.updateDebt(id,debt),
                HttpStatus.OK
        );
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteFolksdev(@PathVariable Long id) {
        debtService.deleteDebt(id);
        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }


}
