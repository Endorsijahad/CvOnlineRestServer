/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.cvonlinerestserver.controller;

import com.mii.cvonlinerestserver.dao.OrganisasiDAO;
import com.mii.cvonlinerestserver.models.Organisasi;
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
public class OrganisasiController {

    @Autowired
    OrganisasiDAO organisasiDAO;

    @PostMapping("/organisasi")
    public Organisasi createOrganisasi(@Valid @RequestBody Organisasi organisasi) {
        return organisasiDAO.save(organisasi);
    }

    @GetMapping("/organisasi")
    public List<Organisasi> getAll() {
        return organisasiDAO.findAll();
    }

    @GetMapping("/organisasi/{id}")
    public ResponseEntity<Organisasi> getOrganisasiById(@PathVariable(value = "id") Long id) {
        Organisasi organisasi = organisasiDAO.findOne(id);

        if (organisasi == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(organisasi);
    }

    @PutMapping("/organisasi/{id}")
    public ResponseEntity<Organisasi> updateOrganisasi(@PathVariable(value = "id") Long id,
             @Valid @RequestBody Organisasi organisasiDetails) {
        Organisasi organisasi = organisasiDAO.findOne(id);
        if (organisasi == null) {
            return ResponseEntity.notFound().build();
        }

        organisasi.setNamaOrganisasi(organisasiDetails.getNamaOrganisasi());
        organisasi.setKandidat(organisasiDetails.getKandidat());

        Organisasi organisasiUpdate = organisasiDAO.save(organisasi);
        return ResponseEntity.ok().body(organisasiUpdate);
    }

    @DeleteMapping("/organisasi/{id}")
    public ResponseEntity<Organisasi> deleteOrganisasi(@PathVariable(value = "id") Long id) {
        Organisasi organisasi = organisasiDAO.findOne(id);
        if (organisasi == null) {
            return ResponseEntity.notFound().build();
        }
        organisasiDAO.delete(organisasi);
        return ResponseEntity.ok().build();
    }
}
