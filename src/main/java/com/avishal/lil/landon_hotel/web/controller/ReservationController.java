package com.avishal.lil.landon_hotel.web.controller;

import com.avishal.lil.landon_hotel.data.entity.Reservation;
import com.avishal.lil.landon_hotel.data.repository.ReservationRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.DateUtils;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
    public final ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String getReservation(@RequestParam(value = "date", required = false) String date) {
        final Date resDate;
        if(StringUtils.isNotBlank(date)) {
             resDate = Date.valueOf(date);
        } else {
            return "error";
        }
        List<Reservation> reservationList = this.reservationRepository.findAllByReservationDate(resDate);
        String text = "";
        for (Reservation reservation : reservationList) {
            text = text + "<h1>" + reservation.toString() + "</h1>";
        }
        return text;
    }
}
