/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.cvonlinerestserver.dao;

import com.mii.cvonlinerestserver.models.Penghargaan;
import com.mii.cvonlinerestserver.repository.PenghargaanRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PenghargaanDAO {
    
    @Autowired
    PenghargaanRepository penghargaanRepository;

    public Penghargaan save(Penghargaan penghargaan) {
        return penghargaanRepository.save(penghargaan);
    }

    public List<Penghargaan> findAll() {
        return penghargaanRepository.findAll();
    }

    public Penghargaan findOne(Long id) {
        return penghargaanRepository.findOne(id);
    }

    public void delete(Penghargaan penghargaan) {
        penghargaanRepository.delete(penghargaan);
    }
}
