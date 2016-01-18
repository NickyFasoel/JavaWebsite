package EJBs;

import Entities.TblGebruiker;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GebruikerEJB {

    @PersistenceContext(unitName = "ProjectWebsitePU")
    private EntityManager em;
    
    public TblGebruiker getGebruiker(String email, String pass) {
        TblGebruiker user = null;
        
        try {
            user = (TblGebruiker) em.createNativeQuery("SELECT * FROM tbl_gebruiker WHERE Email = '" + email + "' AND Paswoord = '"+ pass + "'", TblGebruiker.class).getSingleResult();
        } catch (Exception e) {
            
        }
        
        return user;
    } 
 
}
