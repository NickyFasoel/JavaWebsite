package EJBs;

import Entities.TblVertoning;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class VertoningEJB {

    @PersistenceContext(unitName = "ProjectWebsitePU")
    private EntityManager em;
    
    public List<TblVertoning> getAllVertoningen(long id) {
        List<TblVertoning> lstVertoningen = new ArrayList<>();
       
        // TODO: check dit
        Query q = em.createNativeQuery("SELECT * FROM tbl_vertoning WHERE Film_ID = " + id, TblVertoning.class);
        lstVertoningen = q.getResultList();
        
        return lstVertoningen;
    }
    
}
