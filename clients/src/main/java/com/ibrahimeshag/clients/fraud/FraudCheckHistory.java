package com.ibrahimeshag.clients.fraud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@SuppressWarnings("unused")
@AllArgsConstructor
@NoArgsConstructor
public class FraudCheckHistory {
    private String id;
    private String customerId;
    private String bookId;
    private Boolean isFraudster;
}

