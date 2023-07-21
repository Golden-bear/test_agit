/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.test.recruitment.repository;


import com.agit.test.recruitment.domain.Buku;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author user
 */
public interface BukuRepository extends JpaRepository<Buku, String> {
    List<Buku> findAllByStatus(Integer status);
    
    @Query(value = "select * from tbl_buku tb where upper(tb.bukuid) =:bukuID", nativeQuery = true)
    Buku findOneByBukuID(@Param("bukuID")String bukuID);
}
