/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.cvonlinerestserver.controller;

import com.mii.cvonlinerestserver.dao.PenghargaanDAO;
import com.mii.cvonlinerestserver.models.Penghargaan;
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
public class PenghargaanController {

    @Autowired
    PenghargaanDAO penghargaanDAO;

    @PostMapping("/penghargaan")
    public Penghargaan createPenghargaan(@Valid @RequestBody Penghargaan penghargaan) {
        return penghargaanDAO.save(penghargaan);
    }

    @GetMapping("/penghargaan")
    public List<Penghargaan> getAll() {
        return penghargaanDAO.findAll();
    }

    @GetMapping("/penghargaan/{id}")
    public ResponseEntity<Penghargaan> getPenghargaanById(@PathVariable(value = "id") Long id) {
        Penghargaan penghargaan = penghargaanDAO.findOne(id);

        if (penghargaan == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(penghargaan);
    }

    @PutMapping("/penghargaan/{id}")
    public ResponseEntity<Penghargaan> updatePenghargaan(@PathVariable(value = "id") Long id,
             @Valid @RequestBody Penghargaan penghargaanDetails) {
        Penghargaan penghargaan = penghargaanDAO.findOne(id);
        if (penghargaan == null) {
            return ResponseEntity.notFound().build();
        }

        penghargaan.setNamaPenghargaan(penghargaanDetails.getNamaPenghargaan());
        penghargaan.setKandidat(penghargaanDetails.getKandidat());

        Penghargaan penghargaanUpdate = penghargaanDAO.save(penghargaan);
        return ResponseEntity.ok().body(penghargaanUpdate);
    }

    @DeleteMapping("/penghargaan/{id}")
    public ResponseEntity<Penghargaan> deletePenghargaan(@PathVariable(value = "id") Long id) {
        Penghargaan penghargaan = penghargaanDAO.findOne(id);
        if (penghargaan == null) {
            return ResponseEntity.notFound().build();
        }
        penghargaanDAO.delete(penghargaan);
        return ResponseEntity.ok().build();
    }
}
