package com.booking.flightbooking.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "peminjam")
public class Peminjam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_peminjam")
    private Integer idPeminjam;

    @Column(name = "nim", nullable = false, unique = true, length = 15)
    private String nim;

    @Column(name = "nama", nullable = false, length = 100)
    private String nama;

    @Column(name = "password", nullable = false, length = 200)
    private String password;

    @OneToMany(mappedBy = "peminjam")
    private List<TransaksiPeminjaman> transaksi;

    public Peminjam() {
    }

    public Integer getIdPeminjam() {
        return idPeminjam;
    }

    public void setIdPeminjam(Integer idPeminjam) {
        this.idPeminjam = idPeminjam;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TransaksiPeminjaman> getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(List<TransaksiPeminjaman> transaksi) {
        this.transaksi = transaksi;
    }

}