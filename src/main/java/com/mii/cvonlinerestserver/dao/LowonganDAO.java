package com.mii.cvonlinerestserver.dao;

import com.mii.cvonlinerestserver.models.Lowongan;
import com.mii.cvonlinerestserver.repository.LowonganRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class LowonganDAO {
	 
	@Autowired
	LowonganRepository lowonganRepository;
	
	public Lowongan save(Lowongan lowongan) {
		return lowonganRepository.save(lowongan);
	}
	
	public List<Lowongan> findAll(){
		return lowonganRepository.findAll();
	}
	
	public Lowongan findOne(Integer id) {
		return lowonganRepository.findOne(id);
	}
	
	public void delete(Lowongan lowongan) {
		lowonganRepository.delete(lowongan);
	}
	
}
