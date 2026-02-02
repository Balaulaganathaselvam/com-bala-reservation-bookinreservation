package com.bala.reservation.repository;

import com.bala.reservation.model.BusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.sql.Date;
import java.util.List;

public interface BusRepository extends JpaRepository<BusEntity, Integer> {
    @Query("from BusEntity where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
    List<BusEntity> findBus(@Param("departureCity") String from , @Param("arrivalCity") String to,
                            @Param("dateOfDeparture") Date departureDate);
}
