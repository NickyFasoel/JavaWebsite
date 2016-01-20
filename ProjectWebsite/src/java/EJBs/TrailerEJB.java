package EJBs;

import Entities.TblTrailer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class TrailerEJB {

    @PersistenceContext(unitName = "ProjectWebsitePU")
    private EntityManager em;
    
    public List<TblTrailer> getTrailers() {
        List<TblTrailer> lstTrailers = null;
        
        Query q = em.createNamedQuery("TblTrailer.findAll");
        lstTrailers = q.getResultList();
        
        return lstTrailers;
    }
    
}
