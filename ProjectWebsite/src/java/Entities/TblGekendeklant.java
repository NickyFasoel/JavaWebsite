package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_gekendeklant")
@NamedQueries({
    @NamedQuery(name = "TblGekendeklant.findAll", query = "SELECT t FROM TblGekendeklant t"),
    @NamedQuery(name = "TblGekendeklant.findById", query = "SELECT t FROM TblGekendeklant t WHERE t.id = :id"),
    @NamedQuery(name = "TblGekendeklant.findByAantal", query = "SELECT t FROM TblGekendeklant t WHERE t.aantal = :aantal")})
public class TblGekendeklant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aantal")
    private int aantal;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "datum")
    private String datum;
    @JoinColumn(name = "voorstelling_id", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TblVertoning voorstellingId;
    @JoinColumn(name = "gebruiker_id", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TblGebruiker gebruikerId;

    public TblGekendeklant() {
    }

    public TblGekendeklant(Integer id) {
        this.id = id;
    }

    public TblGekendeklant(Integer id, int aantal, String datum) {
        this.id = id;
        this.aantal = aantal;
        this.datum = datum;
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

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public TblVertoning getVoorstellingId() {
        return voorstellingId;
    }

    public void setVoorstellingId(TblVertoning voorstellingId) {
        this.voorstellingId = voorstellingId;
    }

    public TblGebruiker getGebruikerId() {
        return gebruikerId;
    }

    public void setGebruikerId(TblGebruiker gebruikerId) {
        this.gebruikerId = gebruikerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Entities.TblGekendeklant[ id=" + id + " ]";
    }
    
}
