package com.bala.reservation.repository;

import com.bala.reservation.model.BusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<BusEntity, Integer> {
}
