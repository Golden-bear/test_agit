/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.test.recruitment.service;

import com.agit.test.recruitment.domain.Buku;
import com.agit.test.recruitment.domain.Peminjaman;
import com.agit.test.recruitment.dto.PeminjamAssembler;
import com.agit.test.recruitment.dto.RequestPeminjamDTO;
import com.agit.test.recruitment.dto.ResponseDTO;
import com.agit.test.recruitment.repository.BukuRepository;
import com.agit.test.recruitment.repository.PeminjamanRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */

@Service
public class PeminjamanService {
    @Autowired
    BukuRepository bukuRepository;
    
    @Autowired
    PeminjamanRepository peminjamanRepository;
    
    
    @Transactional
    public ResponseEntity<ResponseDTO> pinjamBuku(RequestPeminjamDTO dto){
        try {
            Buku data = bukuRepository.findOneByBukuID(dto.getBukuID().toUpperCase());

            if(data == null){
                return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDTO().noDataFoundResponse());
            }

            if(data.getStatus() == 1){
                return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDTO().failedRespose(String.valueOf(HttpStatus.OK.value()), "Buku Belum Dikembalikan"));
            }

            if(dto.getPeminjam().isEmpty() || dto.getTanggalPinjam() == null){
                return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDTO().failedRespose(String.valueOf(HttpStatus.OK.value()), "Data Tidak Lengkap"));
            }


            data.setStatus(1);
            bukuRepository.save(data);
            
            dto.setTanggalKembali(null);
            peminjamanRepository.save(new PeminjamAssembler().toDomain(dto));
            
            return ResponseEntity.status(HttpStatus.FOUND).body(
                        new ResponseDTO().defaultResponse());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDTO().failedRespose(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), e.getMessage()));
        }
    }


    
    @Transactional
    public ResponseEntity<ResponseDTO> pengembalianBuku(RequestPeminjamDTO dto){
        try {
            Buku data = bukuRepository.findOneByBukuID(dto.getBukuID().toUpperCase());

            if(data == null){
                return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDTO().noDataFoundResponse());
            }

            if(data.getStatus() == 0){
                return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDTO().failedRespose(String.valueOf(HttpStatus.OK.value()), "Buku Tidak Sedang Dipinjam"));
            }

            if(dto.getTanggalKembali() == null){
                return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDTO().failedRespose(String.valueOf(HttpStatus.OK.value()), "Data Tidak Lengkap"));
            }


            data.setStatus(0);
            bukuRepository.save(data);

            Peminjaman dataPeminjan = peminjamanRepository.findOneByBukuIDAndTanggalKembali(dto.getBukuID().toUpperCase());
            dataPeminjan.setTanggalKembali(dto.getTanggalKembali());
            peminjamanRepository.save(dataPeminjan);
            
            return ResponseEntity.status(HttpStatus.FOUND).body(
                        new ResponseDTO().defaultResponse());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDTO().failedRespose(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), e.getMessage()));
        }
    }
}
