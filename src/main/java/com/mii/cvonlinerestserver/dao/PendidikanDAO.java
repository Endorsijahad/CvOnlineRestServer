package com.mii.cvonlinerestserver.dao;

import com.mii.cvonlinerestserver.models.Pendidikan;
import com.mii.cvonlinerestserver.repository.PendidikanRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class PendidikanDAO {
	 
	@Autowired
	PendidikanRepository pendidikanRepository;
	
	public Pendidikan save(Pendidikan pendidikan) {
		return pendidikanRepository.save(pendidikan);
	}
	
	public List<Pendidikan> findAll(){
		return pendidikanRepository.findAll();
	}
	
	public Pendidikan findOne(Long id) {
		return pendidikanRepository.findOne(id);
	}
	
	public void delete(Pendidikan pendidikan) {
		pendidikanRepository.delete(pendidikan);
	}
	
}
