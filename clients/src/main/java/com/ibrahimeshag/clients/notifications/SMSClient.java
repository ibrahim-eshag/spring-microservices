package com.ibrahimeshag.clients.notifications;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("NOTIFICATION")
public interface SMSClient {
    @PostMapping("api/v1/sms/send")
    public String sendSMS(NotificationRequest notificationRequest);
}
