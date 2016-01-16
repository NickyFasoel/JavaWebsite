package EJBs;

import Entities.TblFilm;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class FilmEJB {

    @PersistenceContext(unitName = "ProjectWebsitePU")
    private EntityManager em;
    
    public List<TblFilm> getAllFilms() {
        List<TblFilm> lstFilms = new ArrayList<>();
        
        lstFilms = em.createNativeQuery("SELECT * FROM tbl_film WHERE actief = 1", TblFilm.class). getResultList();
        
        return lstFilms;
    }
    
}
