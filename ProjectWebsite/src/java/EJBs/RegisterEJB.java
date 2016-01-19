package EJBs;

import Entities.TblGebruiker;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class RegisterEJB {

    @PersistenceContext(unitName = "ProjectWebsitePU")
    private EntityManager em;
    
    public boolean register(String naam, String voornaam, String email, String pass) {
        
        Query q = em.createNativeQuery("SELECT * from tbl_gebruiker WHERE tbl_gebruiker.Email = '" + email + "'");
        List lst = q.getResultList();
        
        if (lst.isEmpty()) {
            
            em.persist(new TblGebruiker(naam, voornaam, email, pass));

            return true;
        } else {
            return false;
        }
        
    }
    
}
