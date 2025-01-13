package com.ibrahimeshag.customer.dto;

import com.ibrahimeshag.customer.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerRegistrationResponse extends Customer {
    Boolean isFraudster;
}
