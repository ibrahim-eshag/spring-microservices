package com.ibrahimeshag.controller;

import com.ibrahimeshag.dto.NotificationRequest;
import com.ibrahimeshag.service.SMSService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/sms")
public class SMSController {
    private final SMSService smsService;

    @PostMapping("/send")
    public String sendSMS(@RequestBody NotificationRequest notificationRequest) {
        return smsService.sendSMS(notificationRequest);
    }
}
