package com.ibrahimeshag.controller;

import com.ibrahimeshag.model.FraudCheckHistory;
import com.ibrahimeshag.service.FraudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/frauds")
public class FraudHistoryController {
    @Autowired
    FraudService fraudService;

    @GetMapping
    List<FraudCheckHistory> getAllFrauds() {
        return fraudService.getAllFrauds();
    }

    @GetMapping("/{id}/isFraudster")
    public boolean isFraudster(@PathVariable("id") String id) {
        try {
            log.info("fraud check request for customer id: {}", id);
            return fraudService.isFraudster(id);
        } catch (Exception e) {
            ResponseEntity.status(500).body(null);
            return false;
        }
    }
}
