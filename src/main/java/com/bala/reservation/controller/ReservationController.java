package com.bala.reservation.controller;

import com.bala.reservation.model.BusEntity;
import com.bala.reservation.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private BusRepository busRepository;
    @GetMapping("/bus")
    public List<BusEntity> getBuses() {
        return busRepository.findAll();
    }
}
