package com.booking.flightbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.booking.flightbooking.model.Laboratorium;
import com.booking.flightbooking.repository.LaboratoriumRepository;

@Service
public class LaboratoriumService {

    private final LaboratoriumRepository laboratoriumRepository;

    public LaboratoriumService(LaboratoriumRepository laboratoriumRepository) {
        this.laboratoriumRepository = laboratoriumRepository;
    }

    public List<Laboratorium> getAll() {
        return laboratoriumRepository.findAll();
    }

    public Optional<Laboratorium> getById(Integer id) {
        return laboratoriumRepository.findById(id);
    }

    public Laboratorium save(Laboratorium lab) {
        return laboratoriumRepository.save(lab);
    }

    public void delete(Integer id) {
        laboratoriumRepository.deleteById(id);
    }
}