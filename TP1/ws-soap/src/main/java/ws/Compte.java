package ws;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;

import java.util.Date;
@XmlAccessorType(XmlAccessType.FIELD)
public class Compte {
    private long num;
    private long solde;

    @XmlTransient
    private Date dateCreation;

    public Compte(long num,long solde)
    {
        this.num=num;
        this.solde=solde;
        this.dateCreation=new Date();
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public long getSolde() {
        return solde;
    }

    public void setSolde(long solde) {
        this.solde = solde;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
