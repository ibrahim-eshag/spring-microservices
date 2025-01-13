package com.ibrahimeshag.customer.controller;

import com.ibrahimeshag.customer.dto.CustomerRegistrationRequest;
import com.ibrahimeshag.customer.dto.CustomerRegistrationResponse;
import com.ibrahimeshag.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@Slf4j
@RequestMapping("/api/v1/customers")
public record CustomerController(CustomerService customerService) {

    @PostMapping
    public ResponseEntity registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        try {
            log.info("Registering customer {}", customerRegistrationRequest.toString());
            CustomerRegistrationResponse customerResponse = customerService.registerCustomer(customerRegistrationRequest);
            log.info("Registered customer {}", customerResponse.toString());
            return ResponseEntity.ok().body(customerResponse);
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping
    public String getCustomers() {
        log.info("Get customers");
        return "Get customers";
    }

}
