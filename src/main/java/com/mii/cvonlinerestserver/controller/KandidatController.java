package com.mii.cvonlinerestserver.controller;

import com.mii.cvonlinerestserver.dao.KandidatDAO;
import com.mii.cvonlinerestserver.models.Kandidat;
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
public class KandidatController {
	
	@Autowired
	KandidatDAO kandidatDAO;
	
	@PostMapping("/kandidat")
	  public Kandidat createKandidat(@Valid @RequestBody Kandidat kandidat) {
	    return kandidatDAO.save(kandidat);
	  }
	  
	  @GetMapping("/kandidat")
	  public List<Kandidat> getAll(){
	    return kandidatDAO.findAll();
	  }
	  
	  @GetMapping("/kandidat/{id}")
	  public ResponseEntity<Kandidat> getKandidatById(@PathVariable(value="id") Long id){
	    Kandidat kandidat = kandidatDAO.findOne(id);
	    
	    if(kandidat==null) {
	      return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(kandidat);
	  }
	
	@PutMapping("/kandidat/{id}")
	  public ResponseEntity<Kandidat> updateKandidat(@PathVariable(value="id") Long id
	      , @Valid @RequestBody Kandidat kandidatDetails){
	    Kandidat kandidat = kandidatDAO.findOne(id);
	    if(kandidat==null) {
	      return ResponseEntity.notFound().build();
	    }
	    
	    kandidat.setNamaKandidat(kandidatDetails.getNamaKandidat());
	    kandidat.setEmail(kandidatDetails.getEmail());
	    kandidat.setNoHp(kandidatDetails.getNoHp());
	    kandidat.setNoTelp(kandidatDetails.getNoTelp());
	    kandidat.setNoTelpkerabat(kandidatDetails.getNoTelpkerabat());
	    kandidat.setNamaKerabat(kandidatDetails.getNamaKerabat());
	    kandidat.setTempatLahir(kandidatDetails.getTempatLahir());
	    kandidat.setTglLahir(kandidatDetails.getTglLahir());
	    kandidat.setNik(kandidatDetails.getNik());
	    kandidat.setAlamatKtp(kandidatDetails.getAlamatKtp());
	    kandidat.setAlamatSekarang(kandidatDetails.getAlamatSekarang());
	    kandidat.setNpwp(kandidatDetails.getNpwp());
	    kandidat.setAgama(kandidatDetails.getAgama());
	    kandidat.setJenisKelamin(kandidatDetails.getJenisKelamin());
	    kandidat.setStatusNikah(kandidatDetails.getStatusNikah());
	    kandidat.setUsername(kandidatDetails.getUsername());
	    kandidat.setPassword(kandidatDetails.getPassword());
	    kandidat.setFoto(kandidatDetails.getFoto());
	    kandidat.setStatusKandidat(kandidatDetails.getStatusKandidat());
	    kandidat.setStatusLamaran(kandidatDetails.getStatusLamaran());
	    kandidat.setUploadCv(kandidatDetails.getUploadCv());

	    Kandidat kandidatUpdate =  kandidatDAO.save(kandidat);
	    return ResponseEntity.ok().body(kandidatUpdate);
	  }
	  
	  @DeleteMapping("/kandidat/{id}")
	  public ResponseEntity<Kandidat> deleteKandidat(@PathVariable(value="id") Long id){
		Kandidat kandidat = kandidatDAO.findOne(id);
		if(kandidat==null) {
			return ResponseEntity.notFound().build();
		}
		kandidatDAO.delete(kandidat);
		return ResponseEntity.ok().build();
	  }
	
}
