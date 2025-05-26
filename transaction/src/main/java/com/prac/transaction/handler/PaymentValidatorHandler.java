package com.prac.transaction.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.prac.transaction.entity.AuditLog;
import com.prac.transaction.entity.Order;
import com.prac.transaction.repository.AuditLogRepository;

import java.time.LocalDateTime;

@Service
public class PaymentValidatorHandler {

    @Autowired
    private AuditLogRepository auditLogRepository;

  @Transactional(propagation = Propagation.NESTED)
    public void validatePayment(Order order) {
         boolean paymentSuccessful = false;

         if (!paymentSuccessful) {
            AuditLog paymentFailureLog = new AuditLog();
            paymentFailureLog.setOrderId(Long.valueOf(order.getId()));
            paymentFailureLog.setAction("Payment Failed for Order");
            paymentFailureLog.setTimestamp(LocalDateTime.now());

            if(order.getTotalPrice()>1000){
                throw new RuntimeException("Error in payment validator");
            }
             auditLogRepository.save(paymentFailureLog);
        }
        
    }

}
