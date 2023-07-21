/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.test.recruitment.rest;

import com.agit.test.recruitment.dto.RequestBukuDTO;
import com.agit.test.recruitment.dto.ResponseBukuGetDTO;
import com.agit.test.recruitment.dto.ResponseDTO;
import com.agit.test.recruitment.service.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */

@RestController
public class BukuRestController {
    
    @Autowired
    BukuService bukuService;
    
    @RequestMapping(value = "/api/post.buku",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> postBuku(@RequestBody RequestBukuDTO buku) {
        return bukuService.postBuku(buku);
    }
    
    @RequestMapping(value = "/api/update.buku",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> updateBuku(@RequestBody RequestBukuDTO buku) {
        return bukuService.updateBuku(buku);
    }
    
    @RequestMapping(value = "/api/get.all.buku",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBukuGetDTO> getAll() {
        return bukuService.findAllBuku();
    }
    
    @RequestMapping(value = "/api/get.all.buku.by.status/{status}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBukuGetDTO> getAllByStatus(@PathVariable("status") Integer status) {
        return bukuService.findAllBukuByStatus(status);
    }
    
    
    @RequestMapping(value = "/api/delete.buku.by.bukuid/{bukuID}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> pengembalianBuku(@PathVariable("bukuID") String bukuID) {
        return bukuService.deleteBuku(bukuID);
    }
}
