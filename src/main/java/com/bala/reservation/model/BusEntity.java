package com.bala.reservation.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;
import java.sql.Timestamp;
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class BusEntity extends AbstractIdentity{

    private String busNumber;
    @Column(name="OPERATING_BUS_STAND")
    private String operationBusStand;
    private String departureCity;
    private String arrivalCity;
    private Date dateOfDeparture;

    @Column(name = "ESTIMATED_DEPARTURE_TIME")

    private Timestamp estimateDepartureTime;
}
