/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.cvonlinerestserver.controller;

import com.mii.cvonlinerestserver.dao.KaryawanDAO;
import com.mii.cvonlinerestserver.models.Karyawan;
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


@RestController
@RequestMapping("/home")
public class KaryawanController {
    
    
    @Autowired
	   KaryawanDAO karyawanDAO;
	
	@PostMapping("/karyawan")
	  public Karyawan createKaryawan(@Valid @RequestBody Karyawan karyawan) {
	    return karyawanDAO.save(karyawan);
	  }
	  
	  @GetMapping("/karyawan")
	  public List<Karyawan> getAll(){
	    return karyawanDAO.findAll();
	  }
	  
	  @GetMapping("/karyawan/{id}")
	  public ResponseEntity<Karyawan> getKaryawanById(@PathVariable(value="id") Long id){
	    Karyawan karyawan = karyawanDAO.findOne(id);
	    
	    if(karyawan==null) {
	      return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(karyawan);
	  }
	
	@PutMapping("/karyawan/{id}")
	  public ResponseEntity<Karyawan> updateKaryawan(@PathVariable(value="id") Long id
	      , @Valid @RequestBody Karyawan karyawanDetails){
	    Karyawan karyawan = karyawanDAO.findOne(id);
	    if(karyawan==null) {
	      return ResponseEntity.notFound().build();
	    }
	    
	    karyawan.setNamaKaryawan(karyawanDetails.getNamaKaryawan());
	    karyawan.setNoHp(karyawanDetails.getNoHp());
	    karyawan.setPassword(karyawanDetails.getPassword());
	    karyawan.setRole(karyawanDetails.getRole());

	    Karyawan karyawanUpdate =  karyawanDAO.save(karyawan);
	    return ResponseEntity.ok().body(karyawanUpdate);
	  }
	  
	  @DeleteMapping("/karyawan/{id}")
	  public ResponseEntity<Karyawan> deleteKaryawan(@PathVariable(value="id") Long id){
		Karyawan karyawan = karyawanDAO.findOne(id);
		if(karyawan==null) {
			return ResponseEntity.notFound().build();
		}
		karyawanDAO.delete(karyawan);
		return ResponseEntity.ok().build();
	  }
    
}
