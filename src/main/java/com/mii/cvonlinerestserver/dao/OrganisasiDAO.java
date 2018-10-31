/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.cvonlinerestserver.dao;

import com.mii.cvonlinerestserver.models.Organisasi;
import com.mii.cvonlinerestserver.repository.OrganisasiRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganisasiDAO {

    @Autowired
    OrganisasiRepository organisasiRepository;

    public Organisasi save(Organisasi organisasi) {
        return organisasiRepository.save(organisasi);
    }

    public List<Organisasi> findAll() {
        return organisasiRepository.findAll();
    }

    public Organisasi findOne(Integer id) {
        return organisasiRepository.findOne(id);
    }

    public void delete(Organisasi organisasi) {
        organisasiRepository.delete(organisasi);
    }
}
