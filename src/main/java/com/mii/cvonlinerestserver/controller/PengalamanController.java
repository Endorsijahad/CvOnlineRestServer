package com.mii.cvonlinerestserver.controller;

import com.mii.cvonlinerestserver.dao.PengalamanDAO;
import com.mii.cvonlinerestserver.models.Pengalamankerja;
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
public class PengalamanController {
	
	@Autowired
	PengalamanDAO pengalamanDAO;
	
	@PostMapping("/pengalaman")
	  public Pengalamankerja createPengalaman(@Valid @RequestBody Pengalamankerja pengalaman) {
	    return pengalamanDAO.save(pengalaman);
	  }
	  
	  @GetMapping("/pengalaman")
	  public List<Pengalamankerja> getAll(){
	    return pengalamanDAO.findAll();
	  }
	  
	  @GetMapping("/pengalaman/{id}")
	  public ResponseEntity<Pengalamankerja> getPengalamanById(@PathVariable(value="id") Long id){
	    Pengalamankerja pengalaman = pengalamanDAO.findOne(id);
	    
	    if(pengalaman==null) {
	      return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(pengalaman);
	  }
	
	@PutMapping("/pengalaman/{id}")
	  public ResponseEntity<Pengalamankerja> updatePengalaman(@PathVariable(value="id") Long id
	      , @Valid @RequestBody Pengalamankerja pengalamanDetails){
	    Pengalamankerja pengalaman = pengalamanDAO.findOne(id);
	    if(pengalaman==null) {
	      return ResponseEntity.notFound().build();
	    }
	    
	    pengalaman.setNamaPt(pengalamanDetails.getNamaPt());
	    pengalaman.setBidang(pengalamanDetails.getBidang());
	    pengalaman.setAlamat(pengalamanDetails.getAlamat());
	    pengalaman.setTelepon(pengalamanDetails.getTelepon());
	    pengalaman.setTglAwal(pengalamanDetails.getTglAwal());
	    pengalaman.setTglAkhir(pengalamanDetails.getTglAkhir());
	    pengalaman.setTglAkhir(pengalamanDetails.getTglAkhir());
	    pengalaman.setPosisi(pengalamanDetails.getPosisi());
	    pengalaman.setGaji(pengalamanDetails.getGaji());
	    pengalaman.setJenisGaji(pengalamanDetails.getJenisGaji());
	    pengalaman.setProyek(pengalamanDetails.getProyek());
	    pengalaman.setNamaAtasan(pengalamanDetails.getNamaAtasan());
	    pengalaman.setAlasan(pengalamanDetails.getAlasan());
	    pengalaman.setUraianJabatan(pengalamanDetails.getUraianJabatan());

	    Pengalamankerja pengalamanUpdate =  pengalamanDAO.save(pengalaman);
	    return ResponseEntity.ok().body(pengalamanUpdate);
	  }
	  
	  @DeleteMapping("/pengalaman/{id}")
	  public ResponseEntity<Pengalamankerja> deletePengalaman(@PathVariable(value="id") Long id){
		Pengalamankerja pengalaman = pengalamanDAO.findOne(id);
		if(pengalaman==null) {
			return ResponseEntity.notFound().build();
		}
		pengalamanDAO.delete(pengalaman);
		return ResponseEntity.ok().build();
	  }
	
}
