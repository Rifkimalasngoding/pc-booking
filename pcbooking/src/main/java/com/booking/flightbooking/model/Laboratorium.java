package com.booking.flightbooking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "laboratorium")
public class Laboratorium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lab")
    private Integer idLab;

    @Column(name = "nama_lab", nullable = false, unique = true)
    private String namaLab;

    public Laboratorium() {
    }

    public Laboratorium(Integer idLab, String namaLab) {
        this.idLab = idLab;
        this.namaLab = namaLab;
    }

    public Integer getIdLab() {
        return idLab;
    }

    public void setIdLab(Integer idLab) {
        this.idLab = idLab;
    }

    public String getNamaLab() {
        return namaLab;
    }

    public void setNamaLab(String namaLab) {
        this.namaLab = namaLab;
    }
}
