
package proxy;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour compte complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>{@code
 * <complexType name="compte">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="num" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         <element name="solde" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "compte", propOrder = {
    "num",
    "solde"
})
public class Compte {

    protected long num;
    protected long solde;

    /**
     * Obtient la valeur de la propriété num.
     * 
     */
    public long getNum() {
        return num;
    }

    /**
     * Définit la valeur de la propriété num.
     * 
     */
    public void setNum(long value) {
        this.num = value;
    }

    /**
     * Obtient la valeur de la propriété solde.
     * 
     */
    public long getSolde() {
        return solde;
    }

    /**
     * Définit la valeur de la propriété solde.
     * 
     */
    public void setSolde(long value) {
        this.solde = value;
    }

}
