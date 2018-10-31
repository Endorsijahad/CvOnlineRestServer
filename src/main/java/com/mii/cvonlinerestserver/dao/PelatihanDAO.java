package com.mii.cvonlinerestserver.dao;

import com.mii.cvonlinerestserver.models.Pelatihan;
import com.mii.cvonlinerestserver.models.Pendidikan;
import com.mii.cvonlinerestserver.repository.PelatihanRepository;
import com.mii.cvonlinerestserver.repository.PendidikanRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class PelatihanDAO {
	 
	@Autowired
	PelatihanRepository pelatihanRepository;
	
	public Pelatihan save(Pelatihan pelatihan) {
		return pelatihanRepository.save(pelatihan);
	}
	
	public List<Pelatihan> findAll(){
		return pelatihanRepository.findAll();
	}
	
	public Pelatihan findOne(Long id) {
		return pelatihanRepository.findOne(id);
	}
	
	public void delete(Pelatihan pelatihan) {
		pelatihanRepository.delete(pelatihan);
	}
	
}
