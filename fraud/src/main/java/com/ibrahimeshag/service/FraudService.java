package com.ibrahimeshag.service;

import com.ibrahimeshag.model.FraudCheckHistory;
import com.ibrahimeshag.repository.FraudRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class FraudService {
    @Autowired
    FraudRepository fraudRepository;

    public List<FraudCheckHistory> getAllFrauds() {
        return fraudRepository.findByIsFraudster(true);
    }

    public boolean isFraudster(String customerId) {
        // 1- random
        // return Arrays.asList(true, false).get(new java.util.Random().nextInt(2));

        // 2-From the db
        Optional<FraudCheckHistory> optionalFraud = fraudRepository.findById(customerId);
        if (optionalFraud.isPresent()) {
            FraudCheckHistory fraud = optionalFraud.get();
            log.info("isFraud :::", fraud.getIsFraudster());
            return fraud.getIsFraudster();
        } else {
            return false;
        }
    }
}
