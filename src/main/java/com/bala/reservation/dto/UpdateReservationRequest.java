package com.bala.reservation.dto;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class UpdateReservationRequest {
    private int id;
    private boolean  checkIn;
    private int numberOfBags;
}
