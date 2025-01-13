package com.ibrahimeshag.respository;

import com.ibrahimeshag.model.SMSMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SMSRepository extends JpaRepository<SMSMessage, Integer> {
}
