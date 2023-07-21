/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.test.recruitment.rest;

import com.agit.test.recruitment.dto.RequestPeminjamDTO;
import com.agit.test.recruitment.dto.ResponseDTO;
import com.agit.test.recruitment.service.PeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */

@RestController
public class PeminjamanRestController {
    @Autowired
    PeminjamanService peminjamanService;
    
    @RequestMapping(value = "/api/pinjam.buku",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> peminjamanBuku(@RequestBody RequestPeminjamDTO dto) {
        return peminjamanService.pinjamBuku(dto);
    }
    
    @RequestMapping(value = "/api/pengembalian.buku",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> pengembalianBuku(@RequestBody RequestPeminjamDTO dto) {
        return peminjamanService.pengembalianBuku(dto);
    }
}
