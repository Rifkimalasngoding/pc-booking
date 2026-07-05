package com.booking.flightbooking.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.booking.flightbooking.model.PC;
import com.booking.flightbooking.model.Peminjam;
import com.booking.flightbooking.model.StatusPc;
import com.booking.flightbooking.model.StatusTransaksi;
import com.booking.flightbooking.model.TransaksiPeminjaman;
import com.booking.flightbooking.service.PCService;
import com.booking.flightbooking.service.PeminjamService;
import com.booking.flightbooking.service.TransaksiPeminjamanService;

@Controller
public class BookingController {

    private final PCService pcService;
    private final PeminjamService peminjamService;
    private final TransaksiPeminjamanService transaksiService;

    public BookingController(
            PCService pcService,
            PeminjamService peminjamService,
            TransaksiPeminjamanService transaksiService) {

        this.pcService = pcService;
        this.peminjamService = peminjamService;
        this.transaksiService = transaksiService;
    }

    @GetMapping("/booking")
    public String bookingPage( Model model) {

        model.addAttribute("daftarPc", pcService.getByStatus(StatusPc.TERSEDIA)
        );
        return "booking";
    }

    @PostMapping("/booking")
    public String booking(

            @RequestParam String nim,
            @RequestParam Integer idPc,
            @RequestParam Integer durasiJam,
            @RequestParam String keperluan

    ) {

        Peminjam peminjam = peminjamService.getByNim(nim).orElse(null);

        if (peminjam == null) {
            return "redirect:/booking";
        }

        PC pc = pcService.getById(idPc).orElse(null);

        if (pc == null) {
            return "redirect:/booking";
        }

        if (pc.getStatus() == StatusPc.DIPINJAM) {
            return "redirect:/booking?error=pcdipinjam";
        }

        TransaksiPeminjaman transaksi = new TransaksiPeminjaman();

        transaksi.setPeminjam(peminjam);
        transaksi.setPc(pc);
        transaksi.setDurasiJam(durasiJam);
        transaksi.setKeperluan(keperluan);
        transaksi.setWaktuMulai(LocalDateTime.now());
        transaksi.setStatus(StatusTransaksi.AKTIF);

        transaksiService.save(transaksi);

        pc.setStatus(StatusPc.DIPINJAM);
        pcService.save(pc);

        return "redirect:/history";
    }

}