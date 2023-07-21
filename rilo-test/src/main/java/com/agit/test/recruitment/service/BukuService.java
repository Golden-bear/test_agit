/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.test.recruitment.service;

import com.agit.test.recruitment.domain.Buku;
import com.agit.test.recruitment.dto.BukuAssembler;
import com.agit.test.recruitment.dto.RequestBukuDTO;
import com.agit.test.recruitment.dto.ResponseBukuGetDTO;
import com.agit.test.recruitment.dto.ResponseDTO;
import com.agit.test.recruitment.repository.BukuRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */

@Service
public class BukuService {
   
    @Autowired
    BukuRepository bukuRepository;
    
    public ResponseEntity<ResponseDTO> postBuku(RequestBukuDTO dto){
        try {
            Buku data = bukuRepository.findOneByBukuID(dto.getBukuID().toUpperCase());
            
            if(data != null){
               return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDTO().failedRespose(String.valueOf(HttpStatus.OK.value()), "ID Buku Sudah Terdaftar"));
            }
            
            dto.setStatus(0);
            bukuRepository.save(new BukuAssembler().toDomain(dto));
            
            return ResponseEntity.status(HttpStatus.FOUND).body(
                        new ResponseDTO().defaultResponse());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDTO().failedRespose(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), e.getMessage()));
        }
    }
    
    public ResponseEntity<ResponseDTO> updateBuku(RequestBukuDTO dto){
        try {
            Buku data = bukuRepository.findOneByBukuID(dto.getBukuID().toUpperCase());
            
            if(data == null){
                return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDTO().noDataFoundResponse());
            }
            
            data.setHalaman(dto.getHalaman());
            data.setJudul(dto.getJudul());
            data.setPenertbit(dto.getPenertbit());
            data.setPengarang(dto.getPengarang());
            bukuRepository.save(data);
            
            return ResponseEntity.status(HttpStatus.FOUND).body(
                        new ResponseDTO().defaultResponse());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDTO().failedRespose(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), e.getMessage()));
        }
    }
    
    public ResponseEntity<ResponseBukuGetDTO> findAllBuku(){
        try {
            List<Buku> datas;
        
            datas = bukuRepository.findAll();
            if(datas.isEmpty()){
                return ResponseEntity.status(HttpStatus.FOUND).body(new ResponseBukuGetDTO(new ResponseDTO().noDataFoundResponse(), new BukuAssembler().toDTOs(new ArrayList<>())));
            }

            return ResponseEntity.status(HttpStatus.FOUND).body(new ResponseBukuGetDTO(new ResponseDTO().defaultResponse(), new BukuAssembler().toDTOs(datas)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FOUND).body(new ResponseBukuGetDTO(new ResponseDTO().failedRespose(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getMessage()), new BukuAssembler().toDTOs(new ArrayList<>())));
        }
    }
    
    
     public ResponseEntity<ResponseBukuGetDTO> findAllBukuByStatus(Integer status){
        try {
            List<Buku> datas;
        
            datas = bukuRepository.findAllByStatus(status);
            if(datas.isEmpty()){
                return ResponseEntity.status(HttpStatus.FOUND).body(new ResponseBukuGetDTO(new ResponseDTO().noDataFoundResponse(), new BukuAssembler().toDTOs(new ArrayList<>())));
            }

            return ResponseEntity.status(HttpStatus.FOUND).body(new ResponseBukuGetDTO(new ResponseDTO().defaultResponse(), new BukuAssembler().toDTOs(datas)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FOUND).body(new ResponseBukuGetDTO(new ResponseDTO().failedRespose(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getMessage()), new BukuAssembler().toDTOs(new ArrayList<>())));
        }
    }
     
    
    
    public ResponseEntity<ResponseDTO> deleteBuku(String bukuID){
        try {
            Buku data = bukuRepository.findOneByBukuID(bukuID.toUpperCase());
            
            if(data == null){
                return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDTO().noDataFoundResponse());
            }

            bukuRepository.delete(data);
            
            return ResponseEntity.status(HttpStatus.FOUND).body(
                        new ResponseDTO().defaultResponse());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDTO().failedRespose(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), e.getMessage()));
        }
    }
}
