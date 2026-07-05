package com.booking.flightbooking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.flightbooking.model.Peminjam;

public interface PeminjamRepository extends JpaRepository<Peminjam, Integer> {

    Optional<Peminjam> findByNim(String nim);

}
