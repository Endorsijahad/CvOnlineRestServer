package com.mii.cvonlinerestserver.controller;

import com.mii.cvonlinerestserver.dao.LowonganDAO;
import com.mii.cvonlinerestserver.models.Lowongan;
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
public class LowonganController {

    @Autowired
    LowonganDAO lowonganDAO;

    @PostMapping("/lowongan")
    public Lowongan createLowongan(@Valid @RequestBody Lowongan lowongan) {
        return lowonganDAO.save(lowongan);
    }

    @GetMapping("/lowongan")
    public List<Lowongan> getAll() {
        return lowonganDAO.findAll();
    }

    @GetMapping("/lowongan/{id}")
    public ResponseEntity<Lowongan> getLowonganById(@PathVariable(value = "id") Long id) {
        Lowongan lowongan = lowonganDAO.findOne(id);

        if (lowongan == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(lowongan);
    }

    @PutMapping("/lowongan/{id}")
    public ResponseEntity<Lowongan> updateLowongan(@PathVariable(value = "id") Long id,
             @Valid @RequestBody Lowongan lowonganDetails) {
        Lowongan lowongan = lowonganDAO.findOne(id);
        if (lowongan == null) {
            return ResponseEntity.notFound().build();
        }

        lowongan.setNamaPosisi(lowonganDetails.getNamaPosisi());
        lowongan.setSyarat(lowonganDetails.getSyarat());
        lowongan.setBatasAkhir(lowonganDetails.getBatasAkhir());
        

        Lowongan lowonganUpdate = lowonganDAO.save(lowongan);
        return ResponseEntity.ok().body(lowonganUpdate);
    }

    @DeleteMapping("/lowongan/{id}")
    public ResponseEntity<Lowongan> deleteLowongan(@PathVariable(value = "id") Long id) {
        Lowongan lowongan = lowonganDAO.findOne(id);
        if (lowongan == null) {
            return ResponseEntity.notFound().build();
        }
        lowonganDAO.delete(lowongan);
        return ResponseEntity.ok().build();
    }

}
