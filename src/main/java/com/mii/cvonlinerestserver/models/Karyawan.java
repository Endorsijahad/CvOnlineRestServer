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
import javax.persistence.Id;
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
@Table(name = "karyawan")
@XmlRootElement
@EntityListeners(AuditingEntityListener.class)
@NamedQueries({
    @NamedQuery(name = "Karyawan.findAll", query = "SELECT k FROM Karyawan k")
    , @NamedQuery(name = "Karyawan.findByIdKaryawan", query = "SELECT k FROM Karyawan k WHERE k.idKaryawan = :idKaryawan")
    , @NamedQuery(name = "Karyawan.findByNamaKaryawan", query = "SELECT k FROM Karyawan k WHERE k.namaKaryawan = :namaKaryawan")
    , @NamedQuery(name = "Karyawan.findByNoHp", query = "SELECT k FROM Karyawan k WHERE k.noHp = :noHp")
    , @NamedQuery(name = "Karyawan.findByUsername", query = "SELECT k FROM Karyawan k WHERE k.username = :username")
    , @NamedQuery(name = "Karyawan.findByPassword", query = "SELECT k FROM Karyawan k WHERE k.password = :password")
    , @NamedQuery(name = "Karyawan.findByRole", query = "SELECT k FROM Karyawan k WHERE k.role = :role")})
public class Karyawan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_karyawan")
    private Integer idKaryawan;
    @Size(max = 50)
    @Column(name = "nama_karyawan")
    private String namaKaryawan;
    @Size(max = 13)
    @Column(name = "no_hp")
    private String noHp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Role")
    private String role;

    public Karyawan() {
    }

    public Karyawan(Integer idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public Karyawan(Integer idKaryawan, String username, String password, String role) {
        this.idKaryawan = idKaryawan;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Integer getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(Integer idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKaryawan != null ? idKaryawan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Karyawan)) {
            return false;
        }
        Karyawan other = (Karyawan) object;
        if ((this.idKaryawan == null && other.idKaryawan != null) || (this.idKaryawan != null && !this.idKaryawan.equals(other.idKaryawan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii.cvonlinerestserver.models.Karyawan[ idKaryawan=" + idKaryawan + " ]";
    }
    
}
