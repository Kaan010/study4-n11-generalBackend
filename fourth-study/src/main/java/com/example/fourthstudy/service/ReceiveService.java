package com.example.fourthstudy.service;

import com.example.fourthstudy.dao.ReceiveDao;
import com.example.fourthstudy.model.Debt;
import com.example.fourthstudy.model.Receive;
import com.example.fourthstudy.model.helperModels.DebtType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)

public class ReceiveService {
    public final ReceiveDao receiveDao;
    public final DebtService debtService;

    public Receive createReceipt(Debt deb) {
        Receive receive = new Receive();
        receive.setDebtId(deb.getId());
        receive.setMainDebt(deb.getMainDebt());
        receive.setRemainingDebt(0L);
        receive.setDebtType(DebtType.NORMAL);
        receive.setOperationTime(LocalDateTime.now());
        receive.setUserId(deb.getUserId());

        if(deb.getDueDate().isBefore(LocalDateTime.now()))
            createLateFeeOfDebt(deb);

        return receiveDao.saveAndFlush(receive);

    }
    public static LocalDateTime localDateTime= LocalDateTime.of(2018,1,1,0,0);


    private Receive createLateFeeOfDebt(Debt deb){
        Receive receive = new Receive();

        receive.setDebtId(deb.getId());
        receive.setRemainingDebt(0L);
        receive.setDebtType(DebtType.GECIKME_ZAMMI);
        receive.setOperationTime(LocalDateTime.now());
        receive.setUserId(deb.getUserId());

        receive.setMainDebt(calculateLateFee(deb, receive));

        return receiveDao.saveAndFlush(receive);

    }

    private Long calculateLateFee(Debt deb) {
        if(deb.getDueDate().isBefore(localDateTime))
            return (long) (Duration.between(deb.getDueDate(),LocalDateTime.now()).toDays()*1.5);
         else
           return (long) (Duration.between(deb.getDueDate(),LocalDateTime.now()).toDays()*2.0);
    }

    public Long getTotalLateFeeUser(Long id) {
        return debtService.getNonPaidDebtsofAUser(id).stream()
                .map(this::calculateLateFee)
                .reduce(Long::sum)
                .orElseThrow();
    }

    public List<Receive> getAllReceivesOfUser(Long id){
        return receiveDao.findAllByUserId(id);
    }
}
