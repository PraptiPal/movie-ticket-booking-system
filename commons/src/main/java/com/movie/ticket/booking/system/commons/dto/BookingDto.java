package com.movie.ticket.booking.system.commons.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingDto {

    private UUID bookingId;

    @NotNull(message = "User Id is mandatory")
    public String userId;

    @NotNull(message = "Movie Id is mandatory")
    public Integer movieID;

    @NotNull(message = "User must have booked seats")
    public List<String> seatsBooked;

    @NotNull(message = "Show date is mandatory")
    public LocalDate showDate;

    @NotNull(message = "Show time is mandatory")
    public LocalTime showTime;

    private BookingStatus bookingStatus;

    @NotNull(message = "Booking amount is mandatory")
    @Positive(message = "Amount must be greater than 0")
    public Double bookingAmount;
}
