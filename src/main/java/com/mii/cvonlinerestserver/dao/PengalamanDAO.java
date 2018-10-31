package com.mii.cvonlinerestserver.dao;

import com.mii.cvonlinerestserver.models.Pendidikan;
import com.mii.cvonlinerestserver.models.Pengalamankerja;
import com.mii.cvonlinerestserver.repository.PendidikanRepository;
import com.mii.cvonlinerestserver.repository.PengalamanRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class PengalamanDAO {
	 
	@Autowired
	PengalamanRepository pengalamanRepository;
	
	public Pengalamankerja save(Pengalamankerja pengalaman) {
		return pengalamanRepository.save(pengalaman);
	}
	
	public List<Pengalamankerja> findAll(){
		return pengalamanRepository.findAll();
	}
	
	public Pengalamankerja findOne(Integer id) {
		return pengalamanRepository.findOne(id);
	}
	
	public void delete(Pengalamankerja pengalaman) {
		pengalamanRepository.delete(pengalaman);
	}
	
}
