package com.ibrahimeshag.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("fraud")
public interface FraudClient {
    @GetMapping
    List<FraudCheckHistory> getAllFrauds();

    @GetMapping("api/v1/frauds//{id}/isFraudster")
    public boolean isFraudster(@PathVariable("id") String id);
}
