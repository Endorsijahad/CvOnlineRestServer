package com.mii.cvonlinerestserver.dao;

import com.mii.cvonlinerestserver.models.Kandidat;
import com.mii.cvonlinerestserver.models.Pendidikan;
import com.mii.cvonlinerestserver.repository.KandidatRepository;
import com.mii.cvonlinerestserver.repository.PendidikanRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class KandidatDAO {
	 
	@Autowired
	KandidatRepository kandidatRepository;
	
	public Kandidat save(Kandidat kandidat) {
		return kandidatRepository.save(kandidat);
	}
	
	public List<Kandidat> findAll(){
		return kandidatRepository.findAll();
	}
	
	public Kandidat findOne(Integer id) {
		return kandidatRepository.findOne(id);
	}
	
	public void delete(Kandidat kandidat) {
		kandidatRepository.delete(kandidat);
	}
	
}
