/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.cvonlinerestserver.repository;

import com.mii.cvonlinerestserver.models.Pengalamankerja;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author 680183
 */
public interface PengalamanRepository extends JpaRepository<Pengalamankerja, Long>{
    
}
