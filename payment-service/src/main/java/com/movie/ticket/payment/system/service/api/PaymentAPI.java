package com.movie.ticket.payment.system.service.api;

import com.movie.ticket.booking.system.commons.constants.LoggerConstants;
import com.movie.ticket.booking.system.commons.dto.BookingDto;
import com.movie.ticket.payment.system.service.PaymentService;
import com.movie.ticket.payment.system.service.dto.PaymentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@Slf4j
public class PaymentAPI {

	@Autowired
	private PaymentService paymentService;

	@GetMapping
	public String test() {
		return "Payment Successful";
	}

	@PostMapping
	public BookingDto createPayment(@RequestBody BookingDto bookingDto){
		log.info(LoggerConstants.ENTERED_CONTROLLER_MESSAGE.getValue(), "createBooking",
				this.getClass(),bookingDto.toString());

		return this.paymentService.makePayment(bookingDto);
	}
}
