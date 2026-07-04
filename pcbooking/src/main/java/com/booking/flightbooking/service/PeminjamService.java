package com.booking.flightbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.booking.flightbooking.model.Peminjam;
import com.booking.flightbooking.repository.PeminjamRepository;

@Service
public class PeminjamService {

    private final PeminjamRepository peminjamRepository;

    public PeminjamService(PeminjamRepository peminjamRepository) {
        this.peminjamRepository = peminjamRepository;
    }

    public List<Peminjam> getAll() {
        return peminjamRepository.findAll();
    }

    public Optional<Peminjam> getByNim(String nim) {
        return peminjamRepository.findByNim(nim);
    }

    public Peminjam save(Peminjam peminjam) {
        return peminjamRepository.save(peminjam);
    }

    public void delete(Integer id){
    peminjamRepository.deleteById(id);
}

    public Optional<Peminjam> login(String nim, String password) {
        return peminjamRepository.findByNimAndPassword(nim, password);
    }
}