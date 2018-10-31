/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.cvonlinerestserver.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author Nande
 */
@Entity
@Table(name = "penghargaan")
@XmlRootElement
@EntityListeners(AuditingEntityListener.class)
@NamedQueries({
    @NamedQuery(name = "Penghargaan.findAll", query = "SELECT p FROM Penghargaan p")
    , @NamedQuery(name = "Penghargaan.findByIdPenghargaan", query = "SELECT p FROM Penghargaan p WHERE p.idPenghargaan = :idPenghargaan")
    , @NamedQuery(name = "Penghargaan.findByNamaPenghargaan", query = "SELECT p FROM Penghargaan p WHERE p.namaPenghargaan = :namaPenghargaan")})
public class Penghargaan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_penghargaan")
    private Integer idPenghargaan;
    @Size(max = 255)
    @Column(name = "nama_penghargaan")
    private String namaPenghargaan;
    @JoinColumn(name = "id_kandidat", referencedColumnName = "id_kandidat")
    @ManyToOne(fetch = FetchType.LAZY)
    private Kandidat idKandidat;

    public Penghargaan() {
    }

    public Penghargaan(Integer idPenghargaan) {
        this.idPenghargaan = idPenghargaan;
    }

    public Integer getIdPenghargaan() {
        return idPenghargaan;
    }

    public void setIdPenghargaan(Integer idPenghargaan) {
        this.idPenghargaan = idPenghargaan;
    }

    public String getNamaPenghargaan() {
        return namaPenghargaan;
    }

    public void setNamaPenghargaan(String namaPenghargaan) {
        this.namaPenghargaan = namaPenghargaan;
    }

    public Kandidat getIdKandidat() {
        return idKandidat;
    }

    public void setIdKandidat(Kandidat idKandidat) {
        this.idKandidat = idKandidat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPenghargaan != null ? idPenghargaan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Penghargaan)) {
            return false;
        }
        Penghargaan other = (Penghargaan) object;
        if ((this.idPenghargaan == null && other.idPenghargaan != null) || (this.idPenghargaan != null && !this.idPenghargaan.equals(other.idPenghargaan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii.cvonlinerestserver.models.Penghargaan[ idPenghargaan=" + idPenghargaan + " ]";
    }
    
}
