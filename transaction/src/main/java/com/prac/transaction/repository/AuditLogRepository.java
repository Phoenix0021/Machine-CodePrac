package com.prac.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.transaction.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

}
