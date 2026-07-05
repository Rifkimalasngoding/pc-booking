package com.booking.flightbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.flightbooking.model.TransaksiPeminjaman;

// @Repository
public interface TransaksiPeminjamanRepository extends JpaRepository<TransaksiPeminjaman, Integer> {

    List<TransaksiPeminjaman> findByPeminjamNim(String nim);

    List<TransaksiPeminjaman> findByStatus(String status);

}