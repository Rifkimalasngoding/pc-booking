package com.booking.flightbooking.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "pc")
public class PC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pc")
    private Integer idPc;

    @Column(name = "kode_pc", nullable = false, unique = true, length = 10)
    private String kodePc;

    @Column(name = "nama_pc", nullable = false, length = 50)
    private String namaPc;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusPc status;

    @ManyToOne
    @JoinColumn(name = "id_lab", nullable = false)
    private Laboratorium laboratorium;

    @OneToMany(mappedBy = "pc")
    private List<TransaksiPeminjaman> transaksi;

    public PC() {
    }

    public Integer getIdPc() {
        return idPc;
    }

    public void setIdPc(Integer idPc) {
        this.idPc = idPc;
    }

    public String getKodePc() {
        return kodePc;
    }

    public void setKodePc(String kodePc) {
        this.kodePc = kodePc;
    }

    public String getNamaPc() {
        return namaPc;
    }

    public void setNamaPc(String namaPc) {
        this.namaPc = namaPc;
    }

    public StatusPc getStatus() {
        return status;
    }

    public void setStatus(StatusPc status) {
        this.status = status;
    }

    public Laboratorium getLaboratorium() {
        return laboratorium;
    }

    public void setLaboratorium(Laboratorium laboratorium) {
        this.laboratorium = laboratorium;
    }

    public List<TransaksiPeminjaman> getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(List<TransaksiPeminjaman> transaksi) {
        this.transaksi = transaksi;
    }
}