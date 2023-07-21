/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.test.recruitment.dto;

import com.agit.test.recruitment.common.IObjectAssembler;
import com.agit.test.recruitment.domain.Buku;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author user
 */
public class BukuAssembler implements IObjectAssembler<Buku,RequestBukuDTO>{

    @Override
    public RequestBukuDTO toDTO(Buku domainObject) {
        RequestBukuDTO dto = new RequestBukuDTO();
        dto.setBukuID(domainObject.getBukuID());
        dto.setHalaman(domainObject.getHalaman());
        dto.setJudul(domainObject.getJudul());
        dto.setPenertbit(domainObject.getPenertbit());
        dto.setPengarang(domainObject.getPengarang());
        dto.setStatus(domainObject.getStatus());
        dto.setTanggalTerbit(domainObject.getTanggalTerbit());
        return dto;
    }
    
    @Override
    public Buku toDomain(RequestBukuDTO dtoObject) {
        Buku data = new Buku();
        data.setBukuID(dtoObject.getBukuID());
        data.setHalaman(dtoObject.getHalaman());
        data.setJudul(dtoObject.getJudul());
        data.setPenertbit(dtoObject.getPenertbit());
        data.setPengarang(dtoObject.getPengarang());
        data.setStatus(dtoObject.getStatus());
        data.setTanggalTerbit(dtoObject.getTanggalTerbit());
        return data;
    }
    
     public List<RequestBukuDTO> toDTOs (Set<Buku>arg0){
        List<RequestBukuDTO> res = new ArrayList<>();
        arg0.stream().forEach((o)->{
            res.add(toDTO(o));
        });
        return res;
    }
    
    public List<RequestBukuDTO> toDTOs (List<Buku> arg0){
        List<RequestBukuDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) ->{
            res.add(toDTO(o));
        });
        return res;
    }
    
    public Set<Buku> toDomains (List<RequestBukuDTO> arg0){
        Set<Buku> res = new HashSet<>();
        arg0.stream().forEach((o) -> {
            res.add(toDomain(o));         
        });
        return res;
    }
    
    
}
