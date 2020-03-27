package banque;

import javax.persistence.Entity;

/** Repr�sentation d'une op�ration Virement
 *
 * @author KOMINIARZ Ana�s
 *
 */
@Entity
public class Virement extends Operation {

	/** beneficiaire du virement **/
	private String beneficiaire;

	public Virement() {
		
	}
	
	public Virement(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	/** Getter
	 *
	 * @return the beneficiaire
	 */
	public String getBeneficiaire() {
		return beneficiaire;
	}

	/** Setter
	 *
	 * @param beneficiaire the beneficiaire to set
	 */
	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	} 
}
