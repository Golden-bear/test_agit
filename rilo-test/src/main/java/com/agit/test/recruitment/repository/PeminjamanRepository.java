/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.test.recruitment.repository;

import com.agit.test.recruitment.domain.Peminjaman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author user
 */
public interface PeminjamanRepository extends JpaRepository<Peminjaman, String>{
    
    @Query(value = "select * from trx_peminjaman tp where upper(tp.bukuid) =:bukuID and tp.tanggalkembali isnull", nativeQuery = true)
    Peminjaman findOneByBukuIDAndTanggalKembali(@Param("bukuID") String bukuID);
}
