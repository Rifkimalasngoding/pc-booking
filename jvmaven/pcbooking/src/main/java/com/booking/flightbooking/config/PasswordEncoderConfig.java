package com.booking.flightbooking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Bean untuk hashing password memakai BCrypt.
 *
 * Catatan: ini HANYA memakai modul spring-security-crypto (utility hashing),
 * BUKAN spring-boot-starter-security. Jadi tidak ada filter/proteksi endpoint
 * otomatis dari Spring Security di sini — login tetap ditangani manual lewat
 * HttpSession seperti sebelumnya, cuma password-nya sekarang di-hash.
 */
@Configuration
public class PasswordEncoderConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
