package com.mii.cvonlinerestserver.controller;

import com.mii.cvonlinerestserver.dao.ReferensiDAO;
import com.mii.cvonlinerestserver.models.Referensi;
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
public class ReferensiController {
	
	@Autowired
	ReferensiDAO referensiDAO;
	
	@PostMapping("/referensi")
	  public Referensi createReferensi(@Valid @RequestBody Referensi referensi) {
	    return referensiDAO.save(referensi);
	  }
	  
	  @GetMapping("/referensi")
	  public List<Referensi> getAll(){
	    return referensiDAO.findAll();
	  }
	  
	  @GetMapping("/referensi/{id}")
	  public ResponseEntity<Referensi> getReferensiById(@PathVariable(value="id") Long id){
	    Referensi referensi = referensiDAO.findOne(id);
	    
	    if(referensi==null) {
	      return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(referensi);
	  }
	
	@PutMapping("/referensi/{id}")
	  public ResponseEntity<Referensi> updateReferensi(@PathVariable(value="id") Long id
	      , @Valid @RequestBody Referensi referensiDetails){
	    Referensi referensi = referensiDAO.findOne(id);
	    if(referensi==null) {
	      return ResponseEntity.notFound().build();
	    }
	    
	    referensi.setNama(referensiDetails.getNama());
	    referensi.setNoHp(referensiDetails.getNoHp());
	    referensi.setEmail(referensiDetails.getEmail());
	    referensi.setLamaKenal(referensiDetails.getLamaKenal());
	    referensi.setKonfirmasi(referensiDetails.getKonfirmasi());
	    referensi.setAlamat(referensiDetails.getAlamat());

	    Referensi referensiUpdate =  referensiDAO.save(referensi);
	    return ResponseEntity.ok().body(referensiUpdate);
	  }
	  
	  @DeleteMapping("/referensi/{id}")
	  public ResponseEntity<Referensi> deleteReferensi(@PathVariable(value="id") Long id){
		Referensi referensi = referensiDAO.findOne(id);
		if(referensi==null) {
			return ResponseEntity.notFound().build();
		}
		referensiDAO.delete(referensi);
		return ResponseEntity.ok().build();
	  }
	
}
