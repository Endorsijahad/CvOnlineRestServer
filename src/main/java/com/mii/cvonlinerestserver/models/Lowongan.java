/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.cvonlinerestserver.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author Nande
 */
@Entity
@Table(name = "lowongan")
@XmlRootElement
@EntityListeners(AuditingEntityListener.class)
@NamedQueries({
    @NamedQuery(name = "Lowongan.findAll", query = "SELECT l FROM Lowongan l")
    , @NamedQuery(name = "Lowongan.findByIdLowongan", query = "SELECT l FROM Lowongan l WHERE l.idLowongan = :idLowongan")
    , @NamedQuery(name = "Lowongan.findByNamaPosisi", query = "SELECT l FROM Lowongan l WHERE l.namaPosisi = :namaPosisi")
    , @NamedQuery(name = "Lowongan.findBySyarat", query = "SELECT l FROM Lowongan l WHERE l.syarat = :syarat")
    , @NamedQuery(name = "Lowongan.findByBatasAkhir", query = "SELECT l FROM Lowongan l WHERE l.batasAkhir = :batasAkhir")})
public class Lowongan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_lowongan")
    private Integer idLowongan;
    @Size(max = 50)
    @Column(name = "nama_posisi")
    private String namaPosisi;
    @Size(max = 255)
    @Column(name = "syarat")
    private String syarat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "batas_akhir")
    @Temporal(TemporalType.DATE)
    private Date batasAkhir;
    @OneToMany(mappedBy = "idLowongan", fetch = FetchType.LAZY)
    private List<Detillowongan> detillowonganList;

    public Lowongan() {
    }

    public Lowongan(Integer idLowongan) {
        this.idLowongan = idLowongan;
    }

    public Lowongan(Integer idLowongan, Date batasAkhir) {
        this.idLowongan = idLowongan;
        this.batasAkhir = batasAkhir;
    }

    public Integer getIdLowongan() {
        return idLowongan;
    }

    public void setIdLowongan(Integer idLowongan) {
        this.idLowongan = idLowongan;
    }

    public String getNamaPosisi() {
        return namaPosisi;
    }

    public void setNamaPosisi(String namaPosisi) {
        this.namaPosisi = namaPosisi;
    }

    public String getSyarat() {
        return syarat;
    }

    public void setSyarat(String syarat) {
        this.syarat = syarat;
    }

    public Date getBatasAkhir() {
        return batasAkhir;
    }

    public void setBatasAkhir(Date batasAkhir) {
        this.batasAkhir = batasAkhir;
    }

    @XmlTransient
    public List<Detillowongan> getDetillowonganList() {
        return detillowonganList;
    }

    public void setDetillowonganList(List<Detillowongan> detillowonganList) {
        this.detillowonganList = detillowonganList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLowongan != null ? idLowongan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lowongan)) {
            return false;
        }
        Lowongan other = (Lowongan) object;
        if ((this.idLowongan == null && other.idLowongan != null) || (this.idLowongan != null && !this.idLowongan.equals(other.idLowongan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii.cvonlinerestserver.models.Lowongan[ idLowongan=" + idLowongan + " ]";
    }
    
}
