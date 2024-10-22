
package rest.metiers;

import rest.entities.logement;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogementBusiness {
    public Object getLogements;
    private List<logement> logements ;

    public LogementBusiness() {
        logements=new ArrayList<logement>();
        logements.add(new logement(1,"27, Rue des roses", "El ghazela","Ariana","Studio","cuisine equipee",300f));
        logements.add(new logement(5,"58, Rue des roses", "El ghazela","Ariana","EtageVilla","cuisine equipee",450f));
        logements.add(new logement(2,"201, R�sidence Omrane4", "Riadh El Andalous","Ariana","EtageVilla","chauffage central, ascenseur, climatisation",700f));
        logements.add(new logement(3,"540, R�sidence Les Tulipes", "El Aouina","Ariana","Appartement","S+2, chauffage central, ascenseur, climatisation",500f));
        logements.add(new logement(4,"78, Rue des Oranges", "Bardo","Tunis","EtageVilla","chauffage central, ascenseur, climatisation",400f));

    }

    public logement getLogementsByReference(int reference){

        for (logement l:logements){
            if(l.getReference()==reference)
                return l;
        }
        return null;
    }
    public boolean addLogement(logement logement){

        return logements.add(logement);
    }
    public List<logement> getLogementsByDeleguation(String deleguation){
        List<logement> liste=new ArrayList<logement>();
        for (logement l:logements){
            if(l.getDelegation().equals(deleguation))
                liste.add(l);
        }
        return liste;
    }
    public List<logement> getLogementsListeByref(int reference){
        List<logement> liste=new ArrayList<logement>();
        for (logement l:logements){
            if(l.getReference()== reference)
                liste.add(l);
        }
        return liste;
    }
    public boolean deleteLogement(int reference){
        Iterator<logement> iterator=logements.iterator();
        while(iterator.hasNext()){
            logement l=iterator.next();
            if(l.getReference()==reference){
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    public boolean updateLogement(int reference, logement logement){
        int index = -1;
        for (int i = 0; i < logements.size(); i++) {
            if (logements.get(i).getReference() == reference) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            logements.set(index, logement);
            return true;
        } else {
            return false;
        }
    }
    public List<logement> getLogements() {
        return logements;
    }

    public void setLogements(List<logement> logements) {
        this.logements = logements;
    }

}
