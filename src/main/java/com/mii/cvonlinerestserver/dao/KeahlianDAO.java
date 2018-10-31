/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.cvonlinerestserver.dao;

import com.mii.cvonlinerestserver.models.Keahlian;
import com.mii.cvonlinerestserver.repository.KeahlianRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeahlianDAO {
    
    @Autowired
    KeahlianRepository keahlianRepository;

    public Keahlian save(Keahlian keahlian) {
        return keahlianRepository.save(keahlian);
    }

    public List<Keahlian> findAll() {
        return keahlianRepository.findAll();
    }

    public Keahlian findOne(Integer id) {
        return keahlianRepository.findOne(id);
    }

    public void delete(Keahlian keahlian) {
        keahlianRepository.delete(keahlian);
    }
    
}
