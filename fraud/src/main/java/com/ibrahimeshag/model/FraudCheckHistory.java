package com.ibrahimeshag.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@SuppressWarnings("unused")
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "frauds")
public class FraudCheckHistory {
    @Id
    private String id;
    private String customerId;
    private String bookId;
    private Boolean isFraudster;
}
