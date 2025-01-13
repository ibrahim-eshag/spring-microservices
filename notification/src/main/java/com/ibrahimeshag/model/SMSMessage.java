package com.ibrahimeshag.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SMSMessage {
    @Id
    @SequenceGenerator(name = "sms_id_sequence", sequenceName = "sms_id_sequence")
    @GeneratedValue(generator = "sms_id_sequence", strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String message;
    private String email;
    public String customerId;
    @Enumerated(EnumType.STRING)
    public NOTIFICATION_TYPE type;
}
