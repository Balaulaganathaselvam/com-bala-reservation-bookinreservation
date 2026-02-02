package com.bala.reservation.controller;

import com.bala.reservation.dto.ReservationRequest;
import com.bala.reservation.dto.UpdateReservationRequest;
import com.bala.reservation.model.BusEntity;
import com.bala.reservation.model.BusReservation;
import com.bala.reservation.model.Passenger;
import com.bala.reservation.repository.BusRepository;
import com.bala.reservation.repository.BusReservationRepo;
import com.bala.reservation.repository.PassengerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
public class ReservationController {

    private final BusRepository busRepository;

    private final PassengerRepository passengerRepository;

    private final BusReservationRepo busReservationRepo;

    @Autowired
    public ReservationController(BusRepository busRepository,
                                 PassengerRepository passengerRepository,
                                 BusReservationRepo busReservationRepo) {
        this.busRepository = busRepository;
        this.passengerRepository = passengerRepository;
        this.busReservationRepo = busReservationRepo;
    }

    @GetMapping("/findBus")
    public List<BusEntity> getBuses(@RequestParam("from")  String from, @RequestParam("to") String to,
                                    @RequestParam("departureDate")
                                    @DateTimeFormat(pattern ="yyyy-MM-dd") LocalDate departureDate) {

        return busRepository.findBus(from,to, Date.valueOf(departureDate));
    }

    @PostMapping("/createReservation")
    @Transactional
    public BusReservation saveReservation(@RequestBody ReservationRequest reservationRequest) {
        BusEntity busEntity = busRepository.findById(reservationRequest.getBusId())
                .orElseThrow(() -> new IllegalArgumentException("Bus not found with id: " + reservationRequest.getBusId()));
        Passenger passenger = new Passenger();
        passenger.setFirstName(reservationRequest.getFirstName());
        passenger.setLastName(reservationRequest.getLastName());
        passenger.setEmail(reservationRequest.getEmail());
        passenger.setMiddleName(reservationRequest.getMiddleName());
        passenger.setPhoneNumber(reservationRequest.getPhoneNumber());
        Passenger passengerRepo =passengerRepository.save(passenger);
        BusReservation  busReservation = new BusReservation();
        busReservation.setPassenger(passengerRepo);
        busReservation.setBusEntity(busEntity);
        busReservation.setCheckIn(false);
        return busReservationRepo.save(busReservation);
    }

    @GetMapping("/findReservation/{id}")
    public BusReservation findReservation(@PathVariable int id) {
        return busReservationRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found with id: " + id));
    }

    @PutMapping("/updateReservation")
    public BusReservation updateReservation(@RequestBody UpdateReservationRequest reservationRequest) {
        BusReservation busReservation = busReservationRepo.findById(reservationRequest.getId())
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found with id: " + reservationRequest.getId()));
        busReservation.setNumberOfBags(reservationRequest.getNumberOfBags());
        busReservation.setCheckIn(reservationRequest.isCheckIn());
        return busReservationRepo.save(busReservation);
    }
}
