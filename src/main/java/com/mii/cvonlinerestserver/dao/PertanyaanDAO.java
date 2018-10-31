/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.cvonlinerestserver.dao;

import com.mii.cvonlinerestserver.models.Pertanyaan;
import com.mii.cvonlinerestserver.repository.PertanyaanRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nande
 */
@Service
public class PertanyaanDAO {

    @Autowired
    PertanyaanRepository pertanyaanRepository;

    public Pertanyaan save(Pertanyaan pertanyaan) {
        return pertanyaanRepository.save(pertanyaan);
    }

    public List<Pertanyaan> findAll() {
        return pertanyaanRepository.findAll();
    }

    public Pertanyaan findOne(Long id) {
        return pertanyaanRepository.findOne(id);
    }

    public void delete(Pertanyaan pertanyaan) {
        pertanyaanRepository.delete(pertanyaan);
    }
}
