/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.cvonlinerestserver.dao;

import com.mii.cvonlinerestserver.models.Karyawan;
import com.mii.cvonlinerestserver.repository.KaryawanRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KaryawanDAO {

        @Autowired
        KaryawanRepository karyawanRepository;

        public Karyawan save(Karyawan karyawan) {
            return karyawanRepository.save(karyawan);
        }

        public List<Karyawan> findAll() {
            return karyawanRepository.findAll();
        }

        public Karyawan findOne(Long id) {
            return karyawanRepository.findOne(id);
        }

        public void delete(Karyawan karyawan) {
            karyawanRepository.delete(karyawan);
        }

}
