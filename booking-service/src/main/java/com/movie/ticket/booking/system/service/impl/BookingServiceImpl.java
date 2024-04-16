package com.movie.ticket.booking.system.service.impl;

import com.movie.ticket.booking.system.commons.dto.BookingDto;
import com.movie.ticket.booking.system.commons.dto.BookingStatus;
import com.movie.ticket.booking.system.service.BookingService;
import com.movie.ticket.booking.system.service.broker.PaymentServiceBroker;
import com.movie.ticket.booking.system.service.entity.BookingEntity;
import com.movie.ticket.booking.system.service.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private PaymentServiceBroker paymentServiceBroker;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public BookingDto createBooking(BookingDto bookingDto) {
        BookingEntity bookingEntity = BookingEntity.builder()
                .bookingAmount(bookingDto.getBookingAmount())
                .seatsBooked(bookingDto.getSeatsBooked())
                .bookingStatus(BookingStatus.PENDING)
                .movieID(bookingDto.getMovieID())
                .userId(bookingDto.getUserId())
                .showDate(bookingDto.getShowDate())
                .showTime(bookingDto.getShowTime())
                .build();

        this.bookingRepository.save(bookingEntity);

        bookingDto.setBookingId(bookingEntity.getBookingId());

        return BookingDto.builder()
                .bookingId(bookingEntity.getBookingId())
                .bookingAmount(bookingEntity.getBookingAmount())
                .seatsBooked(bookingEntity.getSeatsBooked())
                .bookingStatus(BookingStatus.CONFIRMED)
                .movieID(bookingEntity.getMovieID())
                .userId(bookingEntity.getUserId())
                .showDate(bookingEntity.getShowDate())
                .showTime(bookingEntity.getShowTime())
                .build();
    }
}
