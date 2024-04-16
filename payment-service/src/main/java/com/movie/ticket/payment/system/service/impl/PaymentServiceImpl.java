package com.movie.ticket.payment.system.service.impl;

import com.movie.ticket.booking.system.commons.constants.LoggerConstants;
import com.movie.ticket.booking.system.commons.dto.BookingDto;
import com.movie.ticket.booking.system.commons.dto.BookingStatus;
import com.movie.ticket.payment.system.service.PaymentService;
import com.movie.ticket.payment.system.service.dto.PaymentDto;
import com.movie.ticket.payment.system.service.entity.PaymentEntity;
import com.movie.ticket.payment.system.service.entity.PaymentStatus;
import com.movie.ticket.payment.system.service.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private StripePaymentGateway stripePaymentGateway;

    @Override
    public BookingDto makePayment(BookingDto bookingDto) {

        log.info(LoggerConstants.ENTERED_SERVICE_MESSAGE.getValue(), "create payment", this.getClass());

        PaymentEntity paymentEntity = PaymentEntity.builder()
                .paymentAmount(bookingDto.getBookingAmount())
                .paymentStatus(PaymentStatus.PENDING)
                .bookingId(bookingDto.getBookingId())
                .build();
//        PaymentDto.builder().
//                bookingId(bookingDto.getBookingId())
//                .paymentAmount(bookingDto.getBookingAmount())
//                .paymentStatus(PaymentStatus.PENDING).build();

        this.paymentRepository.save(paymentEntity);

        PaymentStatus paymentStatus = this.stripePaymentGateway.makePayment(paymentEntity.getPaymentAmount());
        paymentEntity.setPaymentTimestamp(LocalDateTime.now());

        if(paymentStatus.equals(PaymentStatus.APPROVED)){
            paymentEntity.setPaymentStatus(paymentStatus);
            bookingDto.setBookingStatus(BookingStatus.CONFIRMED);
        }else{
            paymentEntity.setPaymentStatus(PaymentStatus.FAILED);
            bookingDto.setBookingStatus(BookingStatus.CANCELLED);
        }
        return bookingDto;
    }
}
