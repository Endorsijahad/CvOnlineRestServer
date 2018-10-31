package com.mii.cvonlinerestserver.controller;

import com.mii.cvonlinerestserver.dao.BahasaDAO;
import com.mii.cvonlinerestserver.models.Bahasa;
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
@RequestMapping("/CvOnline")
public class KandidatController {

    @Autowired
    BahasaDAO bahasaDAO;

    @PostMapping("/kandidats")
    public Bahasa createBahasa(@Valid @RequestBody Bahasa bahasa) {
        return bahasaDAO.save(bahasa);
    }

    @GetMapping("/kandidats")
    public List<Bahasa> getAll() {
        return bahasaDAO.findAll();
    }

    @GetMapping("/kandidats/{id}")
    public ResponseEntity<Bahasa> getBahasaById(@PathVariable(value = "id") Long id) {
        Bahasa bahasa = bahasaDAO.findOne(id);

        if (bahasa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(bahasa);
    }

    @PutMapping("/kandidats/{id}")
    public ResponseEntity<Bahasa> updateBahasa(@PathVariable(value = "id") Long id,
             @Valid @RequestBody Bahasa bahasaDetails) {
        Bahasa bahasa = bahasaDAO.findOne(id);
        if (bahasa == null) {
            return ResponseEntity.notFound().build();
        }

        bahasa.setNamaBahasa(bahasaDetails.getNamaBahasa());
        bahasa.setSpeaking(bahasaDetails.getSpeaking());
        bahasa.setReading(bahasaDetails.getReading());
        bahasa.setWriting(bahasaDetails.getWriting());

        Bahasa bahasaUpdate = bahasaDAO.save(bahasa);
        return ResponseEntity.ok().body(bahasaUpdate);
    }

    @DeleteMapping("/kandidats/{id}")
    public ResponseEntity<Bahasa> deleteBahasa(@PathVariable(value = "id") Long id) {
        Bahasa bahasa = bahasaDAO.findOne(id);
        if (bahasa == null) {
            return ResponseEntity.notFound().build();
        }
        bahasaDAO.delete(bahasa);
        return ResponseEntity.ok().build();
    }

}
