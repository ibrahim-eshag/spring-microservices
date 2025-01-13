package com.ibrahimeshag.customer.service;

import com.ibrahimeshag.clients.fraud.FraudClient;
import com.ibrahimeshag.clients.notifications.NOTIFICATION_TYPE;
import com.ibrahimeshag.clients.notifications.NotificationRequest;
import com.ibrahimeshag.clients.notifications.SMSClient;
import com.ibrahimeshag.customer.dto.CustomerRegistrationRequest;
import com.ibrahimeshag.customer.dto.CustomerRegistrationResponse;
import com.ibrahimeshag.customer.model.Customer;
import com.ibrahimeshag.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;
    private final SMSClient smsClient;

    public CustomerRegistrationResponse registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);
        // todo: check if  email is valid
        // todo: check if  email is not taken
        log.info("customer id {}", customer.getId().toString());
        // 1- With restTemplate
        // Boolean isFraudResponse = restTemplate.getForObject(
        //  "http://fraud/api/v1/frauds/{customerId}/isFraudster",
        //  Boolean.class, customer.getId()
        // );

        NotificationRequest notificationRequestBody = new NotificationRequest();
        notificationRequestBody.setEmail(request.email());
        notificationRequestBody.setMessage(customer.getFirstName() + " " + customer.getLastName() + " Welcome to our platform.");
        notificationRequestBody.setCustomerId(customer.getId().toString());
        notificationRequestBody.setType(NOTIFICATION_TYPE.EMAIL);

        Boolean isFraudResponse = fraudClient.isFraudster(customer.getId().toString());

        CustomerRegistrationResponse response = new CustomerRegistrationResponse(isFraudResponse);
        response.setId(customer.getId());
        response.setFirstName(customer.getFirstName());
        response.setLastName(customer.getLastName());
        response.setEmail(customer.getEmail());


        log.info("isFraudster response {} :::", response.toString());

        log.info("created customer {}", customer);

        // todo: add the notification to queue (MAKE it ASYNC).
        if (!isFraudResponse) smsClient.sendSMS(notificationRequestBody);

        return response;
    }
}
