package com.booking.flightbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.booking.flightbooking.model.StatusPc;
import com.booking.flightbooking.service.PCService;
import com.booking.flightbooking.service.TransaksiPeminjamanService;

@Controller
public class DashboardController {

    private final PCService pcService;
    private final TransaksiPeminjamanService transaksiService;

    public DashboardController(PCService pcService,
                               TransaksiPeminjamanService transaksiService) {

        this.pcService = pcService;
        this.transaksiService = transaksiService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("totalPc", pcService.getAll().size());
        model.addAttribute("pcDipinjam", pcService.getByStatus(StatusPc.DIPINJAM).size());
        model.addAttribute("pcTersedia", pcService.getByStatus(StatusPc.TERSEDIA).size());
        model.addAttribute("pcMaintenance", pcService.getByStatus(StatusPc.MAINTENANCE).size());

        model.addAttribute("totalTransaksi",
                transaksiService.getAll().size());

        return "dashboard";
    }

}