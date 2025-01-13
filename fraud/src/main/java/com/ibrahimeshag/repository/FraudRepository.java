package com.ibrahimeshag.repository;

import com.ibrahimeshag.model.FraudCheckHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FraudRepository extends MongoRepository<FraudCheckHistory, String> {
    List<FraudCheckHistory> findByIsFraudster(boolean b);
}
