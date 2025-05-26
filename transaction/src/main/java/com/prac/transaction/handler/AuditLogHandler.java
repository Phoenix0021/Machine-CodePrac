package com.prac.transaction.handler;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.prac.transaction.entity.AuditLog;
import com.prac.transaction.entity.Order;
import com.prac.transaction.repository.AuditLogRepository;

@Component
public class AuditLogHandler {
        private AuditLogRepository auditLogRepository;

        public AuditLogHandler(AuditLogRepository auditLogRepository){
            this.auditLogRepository = auditLogRepository;
        }
        @Transactional(propagation = Propagation.REQUIRES_NEW)
        public void logAuditDetails(Order order, String action){
            AuditLog auditLog = new AuditLog();
            auditLog.setOrderId(Long.valueOf(order.getId()));
            auditLog.setAction(action);
            auditLog.setTimestamp(LocalDateTime.now());
            auditLogRepository.save(auditLog);
        }
}
