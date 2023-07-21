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
@Table(name = "TBL_BUKU")
public class Buku {
    @Id
    @GeneratedValue(generator = "tbl_buku_gen")
    @SequenceGenerator(name = "tbl_buku_gen", sequenceName = "tbl_buku_seq")
    private Long id;
    
    private String bukuID;
    
    private String judul;
    
    private String pengarang;
    
    private String penertbit;
    
    private Date tanggalTerbit;
    
    private String halaman;
    
    private Integer status;
    


    public Buku() {
    }

    public Buku(Long id, String bukuID, String judul, String pengarang, String penertbit, Date tanggalTerbit, String halaman, Integer status) {
        this.id = id;
        this.bukuID = bukuID;
        this.judul = judul;
        this.pengarang = pengarang;
        this.penertbit = penertbit;
        this.tanggalTerbit = tanggalTerbit;
        this.halaman = halaman;
        this.status = status;
    }

    
    

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getPenertbit() {
        return penertbit;
    }

    public void setPenertbit(String penertbit) {
        this.penertbit = penertbit;
    }

    public Date getTanggalTerbit() {
        return tanggalTerbit;
    }

    public void setTanggalTerbit(Date tanggalTerbit) {
        this.tanggalTerbit = tanggalTerbit;
    }

    public String getHalaman() {
        return halaman;
    }

    public void setHalaman(String halaman) {
        this.halaman = halaman;
    }
    
    
}
