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

@Entity
@Table(name = "tbl_trailer")
@NamedQueries({
    @NamedQuery(name = "TblTrailer.findAll", query = "SELECT t FROM TblTrailer t"),
    @NamedQuery(name = "TblTrailer.findById", query = "SELECT t FROM TblTrailer t WHERE t.id = :id"),
    @NamedQuery(name = "TblTrailer.findByNaam", query = "SELECT t FROM TblTrailer t WHERE t.naam = :naam"),
    @NamedQuery(name = "TblTrailer.findByImage", query = "SELECT t FROM TblTrailer t WHERE t.image = :image"),
    @NamedQuery(name = "TblTrailer.findByUrl", query = "SELECT t FROM TblTrailer t WHERE t.url = :url")})
public class TblTrailer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Naam")
    private String naam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "Url")
    private String url;

    public TblTrailer() {
    }

    public TblTrailer(Integer id) {
        this.id = id;
    }

    public TblTrailer(Integer id, String naam, String image, String url) {
        this.id = id;
        this.naam = naam;
        this.image = image;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTrailer)) {
            return false;
        }
        TblTrailer other = (TblTrailer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TblTrailer[ id=" + id + " ]";
    }
    
}
