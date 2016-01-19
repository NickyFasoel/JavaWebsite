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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_klant")
@NamedQueries({
    @NamedQuery(name = "TblKlant.findAll", query = "SELECT t FROM TblKlant t"),
    @NamedQuery(name = "TblKlant.findById", query = "SELECT t FROM TblKlant t WHERE t.id = :id"),
    @NamedQuery(name = "TblKlant.findByAantal", query = "SELECT t FROM TblKlant t WHERE t.aantal = :aantal"),
    @NamedQuery(name = "TblKlant.findByZaalNummer", query = "SELECT t FROM TblKlant t WHERE t.zaalNummer = :zaalNummer"),
    @NamedQuery(name = "TblKlant.findByDatum", query = "SELECT t FROM TblKlant t WHERE t.datum = :datum"),
    @NamedQuery(name = "TblKlant.findByPrijs", query = "SELECT t FROM TblKlant t WHERE t.prijs = :prijs")})
public class TblKlant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Aantal")
    private int aantal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Zaal_Nummer")
    private int zaalNummer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Datum")
    private String datum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Prijs")
    private double prijs;
    @JoinColumn(name = "Vertoning_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TblVertoning vertoningID;

    public TblKlant() {
    }

    public TblKlant(Integer id) {
        this.id = id;
    }

    public TblKlant(Integer id, int aantal, int zaalNummer, String datum, double prijs) {
        this.id = id;
        this.aantal = aantal;
        this.zaalNummer = zaalNummer;
        this.datum = datum;
        this.prijs = prijs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public int getZaalNummer() {
        return zaalNummer;
    }

    public void setZaalNummer(int zaalNummer) {
        this.zaalNummer = zaalNummer;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public TblVertoning getVertoningID() {
        return vertoningID;
    }

    public void setVertoningID(TblVertoning vertoningID) {
        this.vertoningID = vertoningID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Entities.TblKlant[ id=" + id + " ]";
    }
    
}
