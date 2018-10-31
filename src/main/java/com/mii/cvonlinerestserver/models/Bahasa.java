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
@Table(name = "bahasa")
@XmlRootElement
@EntityListeners(AuditingEntityListener.class)
@NamedQueries({
    @NamedQuery(name = "Bahasa.findAll", query = "SELECT b FROM Bahasa b")
    , @NamedQuery(name = "Bahasa.findByIdBahasa", query = "SELECT b FROM Bahasa b WHERE b.idBahasa = :idBahasa")
    , @NamedQuery(name = "Bahasa.findByNamaBahasa", query = "SELECT b FROM Bahasa b WHERE b.namaBahasa = :namaBahasa")
    , @NamedQuery(name = "Bahasa.findBySpeaking", query = "SELECT b FROM Bahasa b WHERE b.speaking = :speaking")
    , @NamedQuery(name = "Bahasa.findByReading", query = "SELECT b FROM Bahasa b WHERE b.reading = :reading")
    , @NamedQuery(name = "Bahasa.findByWriting", query = "SELECT b FROM Bahasa b WHERE b.writing = :writing")})
public class Bahasa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_bahasa")
    private Integer idBahasa;
    @Size(max = 20)
    @Column(name = "nama_bahasa")
    private String namaBahasa;
    @Size(max = 5)
    @Column(name = "speaking")
    private String speaking;
    @Size(max = 5)
    @Column(name = "reading")
    private String reading;
    @Size(max = 5)
    @Column(name = "writing")
    private String writing;
    @JoinColumn(name = "id_kandidat", referencedColumnName = "id_kandidat")
    @ManyToOne(fetch = FetchType.LAZY)
    private Kandidat idKandidat;

    public Bahasa() {
    }

    public Bahasa(Integer idBahasa) {
        this.idBahasa = idBahasa;
    }

    public Integer getIdBahasa() {
        return idBahasa;
    }

    public void setIdBahasa(Integer idBahasa) {
        this.idBahasa = idBahasa;
    }

    public String getNamaBahasa() {
        return namaBahasa;
    }

    public void setNamaBahasa(String namaBahasa) {
        this.namaBahasa = namaBahasa;
    }

    public String getSpeaking() {
        return speaking;
    }

    public void setSpeaking(String speaking) {
        this.speaking = speaking;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public String getWriting() {
        return writing;
    }

    public void setWriting(String writing) {
        this.writing = writing;
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
        hash += (idBahasa != null ? idBahasa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bahasa)) {
            return false;
        }
        Bahasa other = (Bahasa) object;
        if ((this.idBahasa == null && other.idBahasa != null) || (this.idBahasa != null && !this.idBahasa.equals(other.idBahasa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii.cvonlinerestserver.models.Bahasa[ idBahasa=" + idBahasa + " ]";
    }
    
}
