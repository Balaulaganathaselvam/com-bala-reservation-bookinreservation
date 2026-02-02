package com.bala.reservation.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class BusReservation extends AbstractIdentity {
   @Column(name ="CHECKED_IN")
    private boolean  checkIn;
    private int numberOfBags;
    @OneToOne
    private BusEntity busEntity;
    @OneToOne
    private Passenger passenger;
}
