/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.cvonlinerestserver.controller;

import com.mii.cvonlinerestserver.dao.KeahlianDAO;
import com.mii.cvonlinerestserver.models.Keahlian;
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
public class KeahlianController {
    
     @Autowired
	   KeahlianDAO keahlianDAO;
	
	@PostMapping("/keahlian")
	  public Keahlian createKeahlian(@Valid @RequestBody Keahlian keahlian) {
	    return keahlianDAO.save(keahlian);
	  }
	  
	  @GetMapping("/keahlian")
	  public List<Keahlian> getAll(){
	    return keahlianDAO.findAll();
	  }
	  
	  @GetMapping("/keahlian/{id}")
	  public ResponseEntity<Keahlian> getKeahlianById(@PathVariable(value="id") Long id){
	    Keahlian keahlian = keahlianDAO.findOne(id);
	    
	    if(keahlian==null) {
	      return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(keahlian);
	  }
	
	@PutMapping("/keahlian/{id}")
	  public ResponseEntity<Keahlian> updateKeahlian(@PathVariable(value="id") Long id
	      , @Valid @RequestBody Keahlian keahlianDetails){
	    Keahlian keahlian = keahlianDAO.findOne(id);
	    if(keahlian==null) {
	      return ResponseEntity.notFound().build();
	    }
	    
	    keahlian.setSertifikat(keahlianDetails.getSertifikat());
	    keahlian.setTglSertifikat(keahlianDetails.getTglSertifikat());
	    keahlian.setKandidat(keahlianDetails.getKandidat());
	    keahlian.setDeskripsi(keahlianDetails.getDeskripsi());

	    Keahlian keahlianUpdate =  keahlianDAO.save(keahlian);
	    return ResponseEntity.ok().body(keahlianUpdate);
	  }
	  
	  @DeleteMapping("/keahlian/{id}")
	  public ResponseEntity<Keahlian> deleteKeahlain(@PathVariable(value="id") Long id){
		Keahlian keahlian = keahlianDAO.findOne(id);
		if(keahlian==null) {
			return ResponseEntity.notFound().build();
		}
		keahlianDAO.delete(keahlian);
		return ResponseEntity.ok().build();
	  }
}
