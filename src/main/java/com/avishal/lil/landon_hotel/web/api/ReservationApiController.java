package com.avishal.lil.landon_hotel.web.api;

import com.avishal.lil.landon_hotel.data.entity.Reservation;
import com.avishal.lil.landon_hotel.data.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationApiController {

    private final ReservationRepository reservationRepository;

    public ReservationApiController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Reservation> getAllReservation() {
        return this.reservationRepository.findAll();
    }
}
