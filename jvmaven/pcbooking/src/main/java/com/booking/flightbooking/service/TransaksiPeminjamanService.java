package com.booking.flightbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.booking.flightbooking.model.TransaksiPeminjaman;
import com.booking.flightbooking.repository.TransaksiPeminjamanRepository;

@Service
public class TransaksiPeminjamanService {

    private final TransaksiPeminjamanRepository transaksiRepository;

    public TransaksiPeminjamanService(TransaksiPeminjamanRepository transaksiRepository) {
        this.transaksiRepository = transaksiRepository;
    }

    public List<TransaksiPeminjaman> getAll() {
        return transaksiRepository.findAll();
    }

    public Optional<TransaksiPeminjaman> getById(Integer id) {
        return transaksiRepository.findById(id);
    }

    public TransaksiPeminjaman save(TransaksiPeminjaman transaksi) {
        return transaksiRepository.save(transaksi);
    }

    public void delete(Integer id) {
        transaksiRepository.deleteById(id);
    }

    public List<TransaksiPeminjaman> getByNim(String nim) {
        return transaksiRepository.findByPeminjamNim(nim);
    }

    // Menampilkan transaksi berdasarkan status
    public List<TransaksiPeminjaman> getByStatus(String status) {
        return transaksiRepository.findByStatus(status);
    }

}