package com.ibrahimeshag.dto;

import com.ibrahimeshag.model.NOTIFICATION_TYPE;
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
