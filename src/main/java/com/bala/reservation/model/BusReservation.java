package com.bala.reservation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class BusReservation extends AbstractIdentity {

    private boolean  checkIn;
    private int numberOfBags;
    @OneToOne
    private BusEntity busEntity;
    @OneToOne
    private Passenger passenger;
}
