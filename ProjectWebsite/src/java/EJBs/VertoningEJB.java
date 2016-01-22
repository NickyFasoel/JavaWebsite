package EJBs;

import Entities.TblVertoning;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class VertoningEJB {

    @PersistenceContext(unitName = "ProjectWebsitePU")
    private EntityManager em;
    
    public TblVertoning isRoom(String tickets, long id, String speeluur, String speeldag) {
        
        TblVertoning vert = null;
        
        Query q = em.createNativeQuery("SELECT * FROM tbl_vertoning WHERE Film_ID = " + id + " AND SpeelDag = '" + speeldag + "' AND SpeelUur = '" + speeluur + "'", TblVertoning.class);
        
        // kan niet leeg of null zijn omdat de argumenten etc 
        // uit de geselecteerde vertoning/film komen en deze komen uit de database
        vert = (TblVertoning) q.getSingleResult();
        int id1 = 0;
        id1 = vert.getId();
        int zaalID = vert.getZaalID();

        int bezettePlaatsen = 0;
        bezettePlaatsen = getTakenSeats(id1);

        int zaalPlaatsen = 0;
        zaalPlaatsen = getMaxSeats(zaalID, zaalPlaatsen);
        
        // Controleren van aantal tickets en inclusief het aantal ingegeven tickets
        if (zaalPlaatsen >= bezettePlaatsen + Integer.parseInt(tickets)) {
            return vert;
        } else {
            // vertoning is vol
            vert = null;
        }
        
        return vert;
    }

    private int getMaxSeats(int zaalID, int zaalPlaatsen) throws NumberFormatException {
        Query quer = em.createNativeQuery("SELECT Plaatsen FROM tbl_zaal WHERE ID = " + zaalID);
        List rl3 = quer.getResultList();
        for (Object getal : rl3) {
            String temp = getal.toString();
            zaalPlaatsen = Integer.parseInt(temp);
        }
        return zaalPlaatsen;
    }

    private int getTakenSeats(int id1) {
        Query qu = em.createNativeQuery("SELECT Aantal FROM tbl_klant WHERE Vertoning_ID = " + id1);
        List<Integer> rl = qu.getResultList();
        int bezettePlaatsen = 0;
        for (Integer getal : rl) {
            bezettePlaatsen += getal;
        }
        
        Query que = em.createNativeQuery("SELECT aantal FROM tbl_gekendeklant WHERE voorstelling_id = " + id1);
        List<Integer> rl2 = que.getResultList();
        for (Integer getal : rl2) {
            bezettePlaatsen += getal;
        }
        return bezettePlaatsen;
    }
    
    public int isStarted (String speeluur) throws ParseException {
        
        Date currentFilmStartTime;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        currentFilmStartTime = sdf.parse(speeluur);
        Date test = sdf.parse(sdf.format(new Date()));
        
        return currentFilmStartTime.compareTo(test);
    }
    
}
