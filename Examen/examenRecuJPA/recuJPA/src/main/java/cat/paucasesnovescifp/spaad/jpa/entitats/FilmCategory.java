/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.paucasesnovescifp.spaad.jpa.entitats;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alumne
 */
@Entity
@Table(name = "film_category")
public class FilmCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FilmCategoryPK filmCategoryPK;
    @Basic(optional = false)
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Category category;
    @JoinColumn(name = "film_id", referencedColumnName = "film_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Film film;

    public FilmCategory() {
    }

    public FilmCategory(FilmCategoryPK filmCategoryPK) {
        this.filmCategoryPK = filmCategoryPK;
    }

    public FilmCategory(FilmCategoryPK filmCategoryPK, Date lastUpdate) {
        this.filmCategoryPK = filmCategoryPK;
        this.lastUpdate = lastUpdate;
    }

    public FilmCategory(short filmId, short categoryId) {
        this.filmCategoryPK = new FilmCategoryPK(filmId, categoryId);
    }

    public FilmCategoryPK getFilmCategoryPK() {
        return filmCategoryPK;
    }

    public void setFilmCategoryPK(FilmCategoryPK filmCategoryPK) {
        this.filmCategoryPK = filmCategoryPK;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filmCategoryPK != null ? filmCategoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FilmCategory)) {
            return false;
        }
        FilmCategory other = (FilmCategory) object;
        if ((this.filmCategoryPK == null && other.filmCategoryPK != null) || (this.filmCategoryPK != null && !this.filmCategoryPK.equals(other.filmCategoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cat.paucasesnovescifp.swdws.entitats.FilmCategory[ filmCategoryPK=" + filmCategoryPK + " ]";
    }
    
}
