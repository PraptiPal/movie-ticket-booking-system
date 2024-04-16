package com.movie.ticket.payment.system.service;

import com.movie.ticket.booking.system.commons.dto.BookingDto;

public interface PaymentService {

    BookingDto makePayment(BookingDto bookingDto);
}
