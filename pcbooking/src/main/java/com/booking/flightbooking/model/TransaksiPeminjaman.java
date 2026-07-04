package com.booking.flightbooking.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaksi_peminjaman")
public class TransaksiPeminjaman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaksi")
    private Integer idTransaksi;

@ManyToOne
@JoinColumn(name = "id_peminjam")
private Peminjam peminjam;

@ManyToOne
@JoinColumn(name = "id_pc")
private PC pc;

    @Column(name = "waktu_mulai", nullable = false)
    private LocalDateTime waktuMulai;

    @Column(name = "durasi_jam", nullable = false)
    private Integer durasiJam;

    @Column(name = "waktu_selesai")
    private LocalDateTime waktuSelesai;

    @Column(nullable = false)
    private String keperluan;

  @Enumerated(EnumType.STRING)
@Column(nullable = false)
private StatusTransaksi status;

    public TransaksiPeminjaman() {
    }

    public Integer getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(Integer idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Peminjam getPeminjam() {
        return peminjam;
    }

    public void setPeminjam(Peminjam peminjam) {
        this.peminjam = peminjam;
    }

    public PC getPc() {
        return pc;
    }

    public void setPc(PC pc) {
        this.pc = pc;
    }

    public LocalDateTime getWaktuMulai() {
        return waktuMulai;
    }

    public void setWaktuMulai(LocalDateTime waktuMulai) {
        this.waktuMulai = waktuMulai;
    }

    public Integer getDurasiJam() {
        return durasiJam;
    }

    public void setDurasiJam(Integer durasiJam) {
        this.durasiJam = durasiJam;
    }

    public LocalDateTime getWaktuSelesai() {
        return waktuSelesai;
    }

    public void setWaktuSelesai(LocalDateTime waktuSelesai) {
        this.waktuSelesai = waktuSelesai;
    }

    public String getKeperluan() {
        return keperluan;
    }

    public void setKeperluan(String keperluan) {
        this.keperluan = keperluan;
    }

  public StatusTransaksi getStatus() {
    return status;
}

public void setStatus(StatusTransaksi status) {
    this.status = status;
}
}