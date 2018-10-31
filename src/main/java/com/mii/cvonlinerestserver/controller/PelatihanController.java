package com.mii.cvonlinerestserver.controller;

import com.mii.cvonlinerestserver.dao.PelatihanDAO;
import com.mii.cvonlinerestserver.models.Pelatihan;
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
@RequestMapping("/CvOnline")
public class PelatihanController {
	
	@Autowired
	PelatihanDAO pelatihanDAO;
	
	@PostMapping("/pelatihan")
	  public Pelatihan createPelatihan(@Valid @RequestBody Pelatihan pelatihan) {
	    return pelatihanDAO.save(pelatihan);
	  }
	  
	  @GetMapping("/pelatihan")
	  public List<Pelatihan> getAll(){
	    return pelatihanDAO.findAll();
	  }
	  
	  @GetMapping("/pelatihan/{id}")
	  public ResponseEntity<Pelatihan> getPelatihanById(@PathVariable(value="id") Long id){
	    Pelatihan pelatihan = pelatihanDAO.findOne(id);
	    
	    if(pelatihan==null) {
	      return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(pelatihan);
	  }
	
	@PutMapping("/pelatihan/{id}")
	  public ResponseEntity<Pelatihan> updatePelatihan(@PathVariable(value="id") Long id
	      , @Valid @RequestBody Pelatihan pelatihanDetails){
	    Pelatihan pelatihan = pelatihanDAO.findOne(id);
	    if(pelatihan==null) {
	      return ResponseEntity.notFound().build();
	    }
	    
	    pelatihan.setNamaPelatihan(pelatihanDetails.getNamaPelatihan());
	    pelatihan.setLembaga(pelatihanDetails.getLembaga());
	    pelatihan.setSertifikat(pelatihanDetails.getSertifikat());
	    pelatihan.setTglPelatihan(pelatihanDetails.getTglPelatihan());

	    Pelatihan pelatihanUpdate =  pelatihanDAO.save(pelatihan);
	    return ResponseEntity.ok().body(pelatihanUpdate);
	  }
	  
	  @DeleteMapping("/pelatihan/{id}")
	  public ResponseEntity<Pelatihan> deletePelatihan(@PathVariable(value="id") Long id){
		Pelatihan pelatihan = pelatihanDAO.findOne(id);
		if(pelatihan==null) {
			return ResponseEntity.notFound().build();
		}
		pelatihanDAO.delete(pelatihan);
		return ResponseEntity.ok().build();
	  }
	
}
