/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.cvonlinerestserver.controller;

import com.mii.cvonlinerestserver.dao.PertanyaanDAO;
import com.mii.cvonlinerestserver.models.Pertanyaan;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class PertanyaanController {
    @Autowired
	PertanyaanDAO pertanyaanDAO;
	
	@PostMapping("/pertanyaans")
	public Pertanyaan createPertanyaan(@Valid @RequestBody Pertanyaan pertanyaan) {
		return pertanyaanDAO.save(pertanyaan);
	}
	
	@GetMapping("/pertanyaans")
	public List<Pertanyaan> getAll(){
		return pertanyaanDAO.findAll();
	}
	
	@GetMapping("/pertanyaans/{id}")
	public ResponseEntity<Pertanyaan> getkandidatById(@PathVariable(value="id") Long id){
		Pertanyaan pertanyaan = pertanyaanDAO.findOne(id);
		
		if(pertanyaan==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(pertanyaan);
	}
	
	@PutMapping("/pertanyaans/{id}")
	public ResponseEntity<Pertanyaan> updateKandidat(@PathVariable(value="id") Long id
			, @Valid @RequestBody Pertanyaan pertanyaanDetails){
		Pertanyaan pertanyaan = pertanyaanDAO.findOne(id);
		if(pertanyaan==null) {
			return ResponseEntity.notFound().build();
		}
		
		pertanyaan.setPertanyaan(pertanyaanDetails.getPertanyaan());
		
		Pertanyaan pertanyaanUpdate = pertanyaanDAO.save(pertanyaan);
		return ResponseEntity.ok().body(pertanyaanUpdate);
	}
	
	@DeleteMapping("/pertanyaans/{id}")
	public ResponseEntity<Pertanyaan> deleteKandidat(@PathVariable(value="id") Long id){
		Pertanyaan pertanyaan = pertanyaanDAO.findOne(id);
		if(pertanyaan==null) {
			return ResponseEntity.notFound().build();
		}
		
		pertanyaanDAO.delete(pertanyaan);
		return ResponseEntity.ok().build();
	}
}
