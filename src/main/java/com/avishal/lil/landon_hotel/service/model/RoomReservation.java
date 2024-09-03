package com.avishal.lil.landon_hotel.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoomReservation {
    private long roomId;
    private String roomNumber;
    private String roomName;
    private long guestId;
    private String firstName;
    private String lastName;
    private long reservationId;
    private String reservationDate;
}
