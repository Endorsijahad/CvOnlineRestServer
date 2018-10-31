package com.mii.cvonlinerestserver.dao;

import com.mii.cvonlinerestserver.models.Bahasa;
import com.mii.cvonlinerestserver.repository.BahasaRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class BahasaDAO {
	 
	@Autowired
	BahasaRepository bahasaRepository;
	
	public Bahasa save(Bahasa bahasa) {
		return bahasaRepository.save(bahasa);
	}
	
	public List<Bahasa> findAll(){
		return bahasaRepository.findAll();
	}
	
	public Bahasa findOne(Integer id) {
		return bahasaRepository.findOne(id);
	}
	
	public void delete(Bahasa bahasa) {
		bahasaRepository.delete(bahasa);
	}
	
}
