/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.test.recruitment.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author user
 */

@Entity
@Table(name = "TRX_PEMINJAMAN")
public class Peminjaman {
    @Id
    @GeneratedValue(generator = "trx_peminjaman_gen")
    @SequenceGenerator(name = "trx_peminjaman_gen", sequenceName = "trx_peminjaman_seq")
    private Long id;
    
    private String bukuID;
    
    private String peminjam;
    
    private Date tanggalPinjam;
    
    private Date tanggalKembali;

    public Peminjaman() {
    }

    public Peminjaman(Long id, String bukuID, String peminjam, Date tanggalPinjam, Date tanggalKembali) {
        this.id = id;
        this.bukuID = bukuID;
        this.peminjam = peminjam;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBukuID() {
        return bukuID;
    }

    public void setBukuID(String bukuID) {
        this.bukuID = bukuID;
    }

    public String getPeminjam() {
        return peminjam;
    }

    public void setPeminjam(String peminjam) {
        this.peminjam = peminjam;
    }

    public Date getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(Date tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public Date getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(Date tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }
    
    
    
}
