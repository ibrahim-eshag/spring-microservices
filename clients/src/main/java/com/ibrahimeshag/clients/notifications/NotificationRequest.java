package com.ibrahimeshag.clients.notifications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {
    public String email;
    public String message;
    public String customerId;
    public NOTIFICATION_TYPE type;
}
