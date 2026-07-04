package com.booking.flightbooking.service;

import com.booking.flightbooking.model.PC;
import com.booking.flightbooking.model.StatusPc;
import com.booking.flightbooking.repository.PcRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PCService {

    private final PcRepository pcRepository;

    public PCService(PcRepository pcRepository) {
        this.pcRepository = pcRepository;
    }

    public List<PC> getAll() {
        return pcRepository.findAll();
    }

    public Optional<PC> getById(Integer id) {
        return pcRepository.findById(id);
    }

    public PC save(PC pc) {
        return pcRepository.save(pc);
    }

    public void delete(Integer id) {
        pcRepository.deleteById(id);
    }

    public List<PC> getByStatus(StatusPc status) {
        return pcRepository.findByStatus(status);
    }
    
}