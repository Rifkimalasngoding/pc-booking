package com.booking.flightbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.booking.flightbooking.service.PCService;

@Controller
public class PcController {

    private final PCService pcService;

    public PcController(PCService pcService) {
        this.pcService = pcService;
    }

    @GetMapping("/pc")
    public String daftarPc(Model model) {

        model.addAttribute("daftarPc", pcService.getAll());

        return "pc-list";

    }

}