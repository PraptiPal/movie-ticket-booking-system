package com.movie.ticket.booking.system.service.entity;

import com.movie.ticket.booking.system.commons.dto.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID bookingId;

    @Column(name = "user_id")
    public String userId;

    @Column(name = "movie_id")
    public Integer movieID;

    @ElementCollection
    public List<String> seatsBooked;

    @Column(name = "show_date")
    public LocalDate showDate;

    @Column(name = "show_time")
    public LocalTime showTime;

    @Enumerated(EnumType.STRING)
    public BookingStatus bookingStatus;

    @Column(name = "booking_amount")
    public Double bookingAmount;

}
