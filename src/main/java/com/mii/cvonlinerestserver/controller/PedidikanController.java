package com.mii.cvonlinerestserver.controller;

import com.mii.cvonlinerestserver.dao.PendidikanDAO;
import com.mii.cvonlinerestserver.models.Pendidikan;
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
public class PedidikanController {
	
	@Autowired
	PendidikanDAO pendidikanDAO;
	
	@PostMapping("/pendidikan")
	  public Pendidikan createPendidikan(@Valid @RequestBody Pendidikan pendidikan) {
	    return pendidikanDAO.save(pendidikan);
	  }
	  
	  @GetMapping("/pendidikan")
	  public List<Pendidikan> getAll(){
	    return pendidikanDAO.findAll();
	  }
	  
	  @GetMapping("/pendidikan/{id}")
	  public ResponseEntity<Pendidikan> getPendidikanById(@PathVariable(value="id") Long id){
	    Pendidikan pendidikan = pendidikanDAO.findOne(id);
	    
	    if(pendidikan==null) {
	      return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(pendidikan);
	  }
	
	@PutMapping("/pendidikan/{id}")
	  public ResponseEntity<Pendidikan> updatePendidikan(@PathVariable(value="id") Long id
	      , @Valid @RequestBody Pendidikan pendidikanDetails){
	    Pendidikan pendidikan = pendidikanDAO.findOne(id);
	    if(pendidikan==null) {
	      return ResponseEntity.notFound().build();
	    }
	    
	    pendidikan.setJenjangPendidikan(pendidikanDetails.getJenjangPendidikan());
            pendidikan.setNamaSekolah(pendidikanDetails.getNamaSekolah());
            pendidikan.setNilaiAkhir(pendidikanDetails.getNilaiAkhir());
            pendidikan.setTahunMasuk(pendidikanDetails.getTahunMasuk());
            pendidikan.setTahunSelesai(pendidikanDetails.getTahunSelesai());
            pendidikan.setIdKandidat(pendidikanDetails.getIdKandidat());
	    Pendidikan pendidikanUpdate =  pendidikanDAO.save(pendidikan);
	    return ResponseEntity.ok().body(pendidikanUpdate);
	  }
	  
	  @DeleteMapping("/pendidikan/{id}")
	  public ResponseEntity<Pendidikan> deletePendidikan(@PathVariable(value="id") Long id){
		Pendidikan pendidikan = pendidikanDAO.findOne(id);
		if(pendidikan==null) {
			return ResponseEntity.notFound().build();
		}
		pendidikanDAO.delete(pendidikan);
		return ResponseEntity.ok().build();
	  }
	
}
