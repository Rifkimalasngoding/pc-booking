package com.booking.flightbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.booking.flightbooking.model.Peminjam;
import com.booking.flightbooking.service.PeminjamService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final PeminjamService peminjamService;

    public LoginController(PeminjamService peminjamService) {
        this.peminjamService = peminjamService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }
    @PostMapping("/register")
    public String register(@RequestParam String nama,
                       @RequestParam String nim,
                       @RequestParam String password) {

    Peminjam peminjam = new Peminjam();

    peminjam.setNama(nama);
    peminjam.setNim(nim);
    peminjam.setPassword(password);

    peminjamService.save(peminjam);

    return "redirect:/login";

}
@PostMapping("/login")
public String login(@RequestParam String nim,
                    @RequestParam String password,
                    HttpSession session) {

    if (peminjamService.login(nim, password).isPresent()) {
        session.setAttribute("nim", nim);
        return "redirect:/dashboard";
    }

    return "redirect:/";

}

@GetMapping("/logout")
public String logout(HttpSession session) {

    session.invalidate();

    return "redirect:/login";

}


}