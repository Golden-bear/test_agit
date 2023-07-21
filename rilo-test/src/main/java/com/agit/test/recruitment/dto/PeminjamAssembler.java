/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.test.recruitment.dto;

import com.agit.test.recruitment.common.IObjectAssembler;
import com.agit.test.recruitment.domain.Peminjaman;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author user
 */
public class PeminjamAssembler implements IObjectAssembler<Peminjaman,RequestPeminjamDTO>{
    
    @Override
    public RequestPeminjamDTO toDTO(Peminjaman domainObject) {
        RequestPeminjamDTO dto = new RequestPeminjamDTO();
        dto.setBukuID(domainObject.getBukuID());
        dto.setPeminjam(domainObject.getPeminjam());
        dto.setTanggalPinjam(domainObject.getTanggalPinjam());
        dto.setTanggalKembali(domainObject.getTanggalKembali());
        return dto;
    }
    
    @Override
    public Peminjaman toDomain(RequestPeminjamDTO dtoObject) {
        Peminjaman data = new Peminjaman();
        data.setBukuID(dtoObject.getBukuID());
        data.setPeminjam(dtoObject.getPeminjam());
        data.setTanggalPinjam(dtoObject.getTanggalPinjam());
        data.setTanggalKembali(dtoObject.getTanggalKembali());
        return data;
    }
    
     public List<RequestPeminjamDTO> toDTOs (Set<Peminjaman>arg0){
        List<RequestPeminjamDTO> res = new ArrayList<>();
        arg0.stream().forEach((o)->{
            res.add(toDTO(o));
        });
        return res;
    }
    
    public List<RequestPeminjamDTO> toDTOs (List<Peminjaman> arg0){
        List<RequestPeminjamDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) ->{
            res.add(toDTO(o));
        });
        return res;
    }
    
    public Set<Peminjaman> toDomains (List<RequestPeminjamDTO> arg0){
        Set<Peminjaman> res = new HashSet<>();
        arg0.stream().forEach((o) -> {
            res.add(toDomain(o));         
        });
        return res;
    }
    
}
