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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_film")
@NamedQueries({
    @NamedQuery(name = "TblFilm.findAll", query = "SELECT t FROM TblFilm t"),
    @NamedQuery(name = "TblFilm.findById", query = "SELECT t FROM TblFilm t WHERE t.id = :id"),
    @NamedQuery(name = "TblFilm.findByNaam", query = "SELECT t FROM TblFilm t WHERE t.naam = :naam"),
    @NamedQuery(name = "TblFilm.findByActief", query = "SELECT t FROM TblFilm t WHERE t.actief = :actief"),
    @NamedQuery(name = "TblFilm.findByGenre", query = "SELECT t FROM TblFilm t WHERE t.genre = :genre"),
    @NamedQuery(name = "TblFilm.findByBeschrijving", query = "SELECT t FROM TblFilm t WHERE t.beschrijving = :beschrijving"),
    @NamedQuery(name = "TblFilm.findByImage", query = "SELECT t FROM TblFilm t WHERE t.image = :image"),
    @NamedQuery(name = "TblFilm.findByShowInfoBackgroundImage", query = "SELECT t FROM TblFilm t WHERE t.showInfoBackgroundImage = :showInfoBackgroundImage"),
    @NamedQuery(name = "TblFilm.findByBgImageCorrection", query = "SELECT t FROM TblFilm t WHERE t.bgImageCorrection = :bgImageCorrection"),
    @NamedQuery(name = "TblFilm.findBySpeeluren", query = "SELECT t FROM TblFilm t WHERE t.speeluren = :speeluren"),
    @NamedQuery(name = "TblFilm.findBySpeeldagen", query = "SELECT t FROM TblFilm t WHERE t.speeldagen = :speeldagen"),
    @NamedQuery(name = "TblFilm.findByPrijs", query = "SELECT t FROM TblFilm t WHERE t.prijs = :prijs")})
public class TblFilm implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "filmID")
    private Collection<TblVertoning> tblVertoningCollection;

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
    @Column(name = "Actief")
    private boolean actief;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Genre")
    private String genre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "Beschrijving")
    private String beschrijving;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ShowInfoBackgroundImage")
    private String showInfoBackgroundImage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BgImageCorrection")
    private int bgImageCorrection;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Speeluren")
    private String speeluren;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Speeldagen")
    private String speeldagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Prijs")
    private double prijs;

    public TblFilm() {
    }

    public TblFilm(Integer id) {
        this.id = id;
    }

    public TblFilm(Integer id, String naam, boolean actief, String genre, String beschrijving, String image, String showInfoBackgroundImage, int bgImageCorrection, String speeluren, String speeldagen, double prijs) {
        this.id = id;
        this.naam = naam;
        this.actief = actief;
        this.genre = genre;
        this.beschrijving = beschrijving;
        this.image = image;
        this.showInfoBackgroundImage = showInfoBackgroundImage;
        this.bgImageCorrection = bgImageCorrection;
        this.speeluren = speeluren;
        this.speeldagen = speeldagen;
        this.prijs = prijs;
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

    public boolean getActief() {
        return actief;
    }

    public void setActief(boolean actief) {
        this.actief = actief;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShowInfoBackgroundImage() {
        return showInfoBackgroundImage;
    }

    public void setShowInfoBackgroundImage(String showInfoBackgroundImage) {
        this.showInfoBackgroundImage = showInfoBackgroundImage;
    }

    public int getBgImageCorrection() {
        return bgImageCorrection;
    }

    public void setBgImageCorrection(int bgImageCorrection) {
        this.bgImageCorrection = bgImageCorrection;
    }

    public String getSpeeluren() {
        return speeluren;
    }

    public void setSpeeluren(String speeluren) {
        this.speeluren = speeluren;
    }

    public String getSpeeldagen() {
        return speeldagen;
    }

    public void setSpeeldagen(String speeldagen) {
        this.speeldagen = speeldagen;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    @Override
    public String toString() {
        return getNaam();
    }

    public Collection<TblVertoning> getTblVertoningCollection() {
        return tblVertoningCollection;
    }

    public void setTblVertoningCollection(Collection<TblVertoning> tblVertoningCollection) {
        this.tblVertoningCollection = tblVertoningCollection;
    }
    
}
