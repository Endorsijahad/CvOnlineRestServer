/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.cvonlinerestserver.controller;

import com.mii.cvonlinerestserver.dao.LainDAO;
import com.mii.cvonlinerestserver.models.Lain;
import com.mii.cvonlinerestserver.models.Pertanyaan;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nande
 */
@RestController
@RequestMapping("/CvOnline")
public class LainController {
    
    @Autowired
    LainDAO lainDAO;
    
    @PostMapping("/lains")
	public Lain createLain(@Valid @RequestBody Lain lain) {
		return lainDAO.save(lain);
	}
	
	@GetMapping("/lains")
	public List<Lain> getAll(){
		return lainDAO.findAll();
	}
	
	@GetMapping("/lains/{id}")
	public ResponseEntity<Lain> getLainById(@PathVariable(value="id") Long id){
		Lain lain = lainDAO.findOne(id);
		
		if(lain==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(lain);
	}
	
	@PutMapping("/lains/{id}")
	public ResponseEntity<Lain> updateLain(@PathVariable(value="id") Long id
			, @Valid @RequestBody Lain lainDetails){
		Lain lain = lainDAO.findOne(id);
		if(lain==null) {
			return ResponseEntity.notFound().build();
		}
		
		lain.setPertanyaan(lainDetails.getPertanyaan());
                lain.setKandidat(lainDetails.getKandidat());
		lain.setJawaban(lainDetails.getJawaban());
                
		Lain lainUpdate = lainDAO.save(lain);
		return ResponseEntity.ok().body(lainUpdate);
	}
}
