package Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_vertoning")
@NamedQueries({
    @NamedQuery(name = "TblVertoning.findAll", query = "SELECT t FROM TblVertoning t"),
    @NamedQuery(name = "TblVertoning.findById", query = "SELECT t FROM TblVertoning t WHERE t.id = :id"),
    @NamedQuery(name = "TblVertoning.findBySpeelDag", query = "SELECT t FROM TblVertoning t WHERE t.speelDag = :speelDag"),
    @NamedQuery(name = "TblVertoning.findBySpeelUur", query = "SELECT t FROM TblVertoning t WHERE t.speelUur = :speelUur"),
    @NamedQuery(name = "TblVertoning.findByZaalID", query = "SELECT t FROM TblVertoning t WHERE t.zaalID = :zaalID")})
public class TblVertoning implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vertoningID")
    private Collection<TblKlant> tblKlantCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voorstellingId")
    private Collection<TblGekendeklant> tblGekendeklantCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "SpeelDag")
    private String speelDag;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "SpeelUur")
    private String speelUur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Zaal_ID")
    private int zaalID;
    @JoinColumn(name = "Film_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TblFilm filmID;

    public TblVertoning() {
    }

    public TblVertoning(Integer id) {
        this.id = id;
    }

    public TblVertoning(Integer id, String speelDag, String speelUur, int zaalID) {
        this.id = id;
        this.speelDag = speelDag;
        this.speelUur = speelUur;
        this.zaalID = zaalID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpeelDag() {
        return speelDag;
    }

    public void setSpeelDag(String speelDag) {
        this.speelDag = speelDag;
    }

    public String getSpeelUur() {
        return speelUur;
    }

    public void setSpeelUur(String speelUur) {
        this.speelUur = speelUur;
    }

    public int getZaalID() {
        return zaalID;
    }

    public void setZaalID(int zaalID) {
        this.zaalID = zaalID;
    }

    public TblFilm getFilmID() {
        return filmID;
    }

    public void setFilmID(TblFilm filmID) {
        this.filmID = filmID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Entities.TblVertoning[ id=" + id + " ]";
    }

    public Collection<TblKlant> getTblKlantCollection() {
        return tblKlantCollection;
    }

    public void setTblKlantCollection(Collection<TblKlant> tblKlantCollection) {
        this.tblKlantCollection = tblKlantCollection;
    }

    public Collection<TblGekendeklant> getTblGekendeklantCollection() {
        return tblGekendeklantCollection;
    }

    public void setTblGekendeklantCollection(Collection<TblGekendeklant> tblGekendeklantCollection) {
        this.tblGekendeklantCollection = tblGekendeklantCollection;
    }
    
}
