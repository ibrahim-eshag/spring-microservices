package com.ibrahimeshag.service;

import com.ibrahimeshag.dto.NotificationRequest;
import com.ibrahimeshag.model.SMSMessage;
import com.ibrahimeshag.respository.SMSRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class SMSService {

    private final SMSRepository smsRepository;

    public String sendSMS(NotificationRequest notificationRequest) {
        log.info("Sending SMS of content {}", notificationRequest);

        SMSMessage message = new SMSMessage();
        message.setCustomerId(notificationRequest.getCustomerId());
        message.setMessage(notificationRequest.getMessage());
        message.setEmail(notificationRequest.getEmail());
        message.setType(notificationRequest.getType());

        smsRepository.save(message);
        return "SMS sent successfully";
    }
}
