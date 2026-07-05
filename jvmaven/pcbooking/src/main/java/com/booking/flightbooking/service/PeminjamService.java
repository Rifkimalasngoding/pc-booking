package com.booking.flightbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.booking.flightbooking.model.Peminjam;
import com.booking.flightbooking.repository.PeminjamRepository;

@Service
public class PeminjamService {

    private final PeminjamRepository peminjamRepository;
    private final PasswordEncoder passwordEncoder;

    public PeminjamService(PeminjamRepository peminjamRepository, PasswordEncoder passwordEncoder) {
        this.peminjamRepository = peminjamRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Peminjam> getAll() {
        return peminjamRepository.findAll();
    }

    public Optional<Peminjam> getByNim(String nim) {
        return peminjamRepository.findByNim(nim);
    }

    // Password di-hash (BCrypt) sebelum disimpan, dipakai saat registrasi.
    public Peminjam save(Peminjam peminjam) {
        peminjam.setPassword(passwordEncoder.encode(peminjam.getPassword()));
        return peminjamRepository.save(peminjam);
    }

    public void delete(Integer id){
    peminjamRepository.deleteById(id);
}

    // Ambil peminjam berdasarkan NIM, lalu cocokkan password mentah dengan hash di database.
    public Optional<Peminjam> login(String nim, String password) {
        return peminjamRepository.findByNim(nim)
                .filter(peminjam -> passwordEncoder.matches(password, peminjam.getPassword()));
    }
}