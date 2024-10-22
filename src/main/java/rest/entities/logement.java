package rest.entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class logement {
    //@XmlAttribute
    private int reference;
    //@XmlTransient
    private String adresse;
    private String delegation;
    private String gouvernorat;
    private String type;
    private String description;
    private float prix;

    public logement() {
    }

    public logement(int reference, String adresse, String delegation, String gouvernorat, String type, String description, float prix) {
        this.reference = reference;
        this.adresse = adresse;
        this.delegation = delegation;
        this.gouvernorat = gouvernorat;
        this.type = type;
        this.description = description;
        this.prix = prix;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDelegation() {
        return delegation;
    }

    public void setDelegation(String delegation) {
        this.delegation = delegation;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        logement logement = (logement) object;
        return reference == logement.reference &&
                Float.compare(logement.prix, prix) == 0 &&
                java.util.Objects.equals(adresse, logement.adresse) &&
                java.util.Objects.equals(delegation, logement.delegation) &&
                java.util.Objects.equals(gouvernorat, logement.gouvernorat) &&
                java.util.Objects.equals(type, logement.type) &&
                java.util.Objects.equals(description, logement.description);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(reference, adresse, delegation, gouvernorat, type, description, prix);
    }
}