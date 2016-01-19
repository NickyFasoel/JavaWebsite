package EJBs;

import Entities.TblGebruiker;
import Entities.TblGekendeklant;
import Entities.TblVertoning;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PayEJB {

    @PersistenceContext(unitName = "ProjectWebsitePU")
    private EntityManager em;
    
    public void pay(TblGebruiker user, TblVertoning vert, int aantal) {
        
        TblGekendeklant gek = new TblGekendeklant();
        gek.setGebruikerId(user);
        gek.setVoorstellingId(vert);
        gek.setAantal(aantal);
        gek.setDatum(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        
        em.persist(gek);
    }
    
}
