package com.bala.reservation.repository;

import com.bala.reservation.model.BusReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusReservationRepo extends JpaRepository<BusReservation, Integer> {
}
