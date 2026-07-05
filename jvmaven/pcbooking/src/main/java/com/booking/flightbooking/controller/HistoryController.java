package com.booking.flightbooking.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.booking.flightbooking.model.PC;
import com.booking.flightbooking.model.StatusPc;
import com.booking.flightbooking.model.StatusTransaksi;
import com.booking.flightbooking.model.TransaksiPeminjaman;
import com.booking.flightbooking.service.PCService;
import com.booking.flightbooking.service.TransaksiPeminjamanService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HistoryController {

    private final TransaksiPeminjamanService transaksiService;
    private final PCService pcService;

    public HistoryController(TransaksiPeminjamanService transaksiService,
                             PCService pcService) {
        this.transaksiService = transaksiService;
        this.pcService = pcService;
    }

   @GetMapping("/history")
    public String history(Model model, HttpSession session) {

        String nim = (String) session.getAttribute("nim");

        if (nim == null) {
            return "redirect:/login";
        }

        model.addAttribute(
                "historyList",
                transaksiService.getByNim(nim));

        return "history";
    }

    @PostMapping("/history/selesai/{id}")
    public String finishHistory(@PathVariable("id") Integer id) {
        TransaksiPeminjaman transaksi = transaksiService.getById(id).orElse(null);
        if (transaksi == null) {
            return "redirect:/history";
        }

        transaksi.setStatus(StatusTransaksi.SELESAI);
        transaksi.setWaktuSelesai(LocalDateTime.now());
        transaksiService.save(transaksi);

        PC pc = transaksi.getPc();
        if (pc != null) {
            pc.setStatus(StatusPc.TERSEDIA);
            pcService.save(pc);
        }

        return "redirect:/history";
    }
}