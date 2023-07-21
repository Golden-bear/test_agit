/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.test.recruitment.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author user
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestPeminjamDTO {
    private String bukuID;
    private String peminjam;
    private Date tanggalPinjam;
    private Date tanggalKembali;
}
