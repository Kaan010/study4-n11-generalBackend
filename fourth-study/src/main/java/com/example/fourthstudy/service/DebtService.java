package com.example.fourthstudy.service;

import com.example.fourthstudy.dao.DebtDao;
import com.example.fourthstudy.model.Debt;
import com.example.fourthstudy.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)

public class DebtService {
    public final DebtDao debtDao;

    public List<Debt> findAllDebts() {
        return debtDao.findAll();
    }


    public Debt findDebtById(Long id) {
        return debtDao.findById(id).orElseGet(null);
    }

    public Debt updateDebt(Long id, Debt debt) {
        Optional<Debt> debtOptional = debtDao.findById(id);
        debtOptional.ifPresent(
                updatedDebt->{
                    updatedDebt.setRemainingDebt(debt.getRemainingDebt());
                    updatedDebt.setDueDate(debt.getDueDate());
                    updatedDebt.setCreationDate(debt.getCreationDate());
                    updatedDebt.setLateFee(debt.getLateFee());
                }
        );
        return debtOptional.orElse(new Debt());
    }

    public Debt createDebt(Debt debt) {
        return debtDao.saveAndFlush(debt);
    }

    public void deleteDebt(Long id) {
        debtDao.deleteById(id);
    }

    public List<Debt> findDebtsBetweenDates(LocalDate fromDate,LocalDate toDate){
        return debtDao.getDebts_between(fromDate,toDate);
    }

    public List<Debt> getDebtsOfAUser(Long id){
        return debtDao.findAllByUserId(id);
    }

}
