/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.cvonlinerestserver.dao;

import com.mii.cvonlinerestserver.models.Lain;
import com.mii.cvonlinerestserver.repository.LainRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nande
 */
@Service
public class LainDAO {
    
    @Autowired
    LainRepository lainRepository;
    
    public Lain save(Lain lain){
        return lainRepository.save(lain);
    }
    
    public List<Lain> findAll(){
        return lainRepository.findAll();
    }
    
    public Lain findOne(Long id){
        return lainRepository.findOne(id);
    }
    
    public void delete(Lain lain){
        lainRepository.delete(lain);
    }
}
