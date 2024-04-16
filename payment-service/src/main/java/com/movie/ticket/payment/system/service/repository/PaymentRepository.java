package com.movie.ticket.payment.system.service.repository;

import com.movie.ticket.payment.system.service.entity.PaymentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PaymentRepository extends CrudRepository<PaymentEntity, UUID> {
}
