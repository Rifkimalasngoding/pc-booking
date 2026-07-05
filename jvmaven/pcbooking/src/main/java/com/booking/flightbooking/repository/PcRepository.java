package com.booking.flightbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.flightbooking.model.PC;
import com.booking.flightbooking.model.StatusPc;

// @Repository
public interface PcRepository extends JpaRepository<PC, Integer> {

    List<PC> findByStatus(StatusPc status);

}