package com.avishal.lil.landon_hotel.web.api;

import com.avishal.lil.landon_hotel.data.entity.Guest;
import com.avishal.lil.landon_hotel.data.repository.GuestRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guest")
public class GuestApiController {
    private final GuestRepository guestRepository;

    public GuestApiController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Guest> getAllGuest() {
        return this.guestRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Guest getGuestById(@PathVariable("id") long id) {
        return this.guestRepository.findById(id).get();
    }
}
