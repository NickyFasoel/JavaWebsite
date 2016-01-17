/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Gebruiker
 */
@Entity
@Table(name = "tbl_zaal")
@NamedQueries({
    @NamedQuery(name = "TblZaal.findAll", query = "SELECT t FROM TblZaal t"),
    @NamedQuery(name = "TblZaal.findById", query = "SELECT t FROM TblZaal t WHERE t.id = :id"),
    @NamedQuery(name = "TblZaal.findByNummer", query = "SELECT t FROM TblZaal t WHERE t.nummer = :nummer"),
    @NamedQuery(name = "TblZaal.findByPlaatsen", query = "SELECT t FROM TblZaal t WHERE t.plaatsen = :plaatsen")})
public class TblZaal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Nummer")
    private int nummer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Plaatsen")
    private String plaatsen;

    public TblZaal() {
    }

    public TblZaal(Integer id) {
        this.id = id;
    }

    public TblZaal(Integer id, int nummer, String plaatsen) {
        this.id = id;
        this.nummer = nummer;
        this.plaatsen = plaatsen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public String getPlaatsen() {
        return plaatsen;
    }

    public void setPlaatsen(String plaatsen) {
        this.plaatsen = plaatsen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Entities.TblZaal[ id=" + id + " ]";
    }
    
}
