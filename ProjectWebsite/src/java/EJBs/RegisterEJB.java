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
            em.createNativeQuery("INSERT INTO tbl_gebruiker (Naam, Voornaam, Email, Paswoord) "
                    + "VALUES ('" + naam + "', '" + voornaam + "', '" + email +  "', '" + pass + "')", TblGebruiker.class);
            return true;
        } else {
            return false;
        }
        
    }
    
}
