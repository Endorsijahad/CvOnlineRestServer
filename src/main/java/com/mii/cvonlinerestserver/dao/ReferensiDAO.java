package com.mii.cvonlinerestserver.dao;

import com.mii.cvonlinerestserver.models.Pendidikan;
import com.mii.cvonlinerestserver.models.Referensi;
import com.mii.cvonlinerestserver.repository.PendidikanRepository;
import com.mii.cvonlinerestserver.repository.ReferensiRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class ReferensiDAO {
	 
	@Autowired
	ReferensiRepository referensiRepository;
	
	public Referensi save(Referensi referensi) {
		return referensiRepository.save(referensi);
	}
	
	public List<Referensi> findAll(){
		return referensiRepository.findAll();
	}
	
	public Referensi findOne(Integer id) {
		return referensiRepository.findOne(id);
	}
	
	public void delete(Referensi referensi) {
		referensiRepository.delete(referensi);
	}
	
}
