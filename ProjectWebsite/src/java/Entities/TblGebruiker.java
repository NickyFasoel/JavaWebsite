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
@Table(name = "tbl_gebruiker")
@NamedQueries({
    @NamedQuery(name = "TblGebruiker.findAll", query = "SELECT t FROM TblGebruiker t"),
    @NamedQuery(name = "TblGebruiker.findById", query = "SELECT t FROM TblGebruiker t WHERE t.id = :id"),
    @NamedQuery(name = "TblGebruiker.findByNaam", query = "SELECT t FROM TblGebruiker t WHERE t.naam = :naam"),
    @NamedQuery(name = "TblGebruiker.findByVoornaam", query = "SELECT t FROM TblGebruiker t WHERE t.voornaam = :voornaam"),
    @NamedQuery(name = "TblGebruiker.findByEmail", query = "SELECT t FROM TblGebruiker t WHERE t.email = :email"),
    @NamedQuery(name = "TblGebruiker.findByPaswoord", query = "SELECT t FROM TblGebruiker t WHERE t.paswoord = :paswoord")})
public class TblGebruiker implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "Naam")
    private String naam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "Voornaam")
    private String voornaam;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "Paswoord")
    private String paswoord;

    public TblGebruiker() {
    }

    public TblGebruiker(Integer id) {
        this.id = id;
    }

    public TblGebruiker(Integer id, String naam, String voornaam, String email, String paswoord) {
        this.id = id;
        this.naam = naam;
        this.voornaam = voornaam;
        this.email = email;
        this.paswoord = paswoord;
    }
    
    public TblGebruiker(String naam, String voornaam, String email, String paswoord) {
        this.naam = naam;
        this.voornaam = voornaam;
        this.email = email;
        this.paswoord = paswoord;
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

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaswoord() {
        return paswoord;
    }

    public void setPaswoord(String paswoord) {
        this.paswoord = paswoord;
    }

    @Override
    public String toString() {
        return "Entities.TblGebruiker[ id=" + id + " ]";
    }
    
}
