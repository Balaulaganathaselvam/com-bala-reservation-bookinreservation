package com.bala.reservation.dto;

import lombok.Data;

@Data
public class ReservationRequest {

    private int busId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phoneNumber;
    private boolean  checkIn;
    private int numberOfBags;

}
