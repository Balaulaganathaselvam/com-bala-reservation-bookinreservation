package com.bala.reservation.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Passenger extends AbstractIdentity{


    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phoneNumber;
}
