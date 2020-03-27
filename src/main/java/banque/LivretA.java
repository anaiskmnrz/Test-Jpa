/**
 * 
 */
package banque;

import javax.persistence.Entity;

/** Repr�sentation d'un compte Livret A
 *
 * @author KOMINIARZ Ana�s
 *
 */

@Entity
public class LivretA extends Compte {


	/** Constructeur
	 *
	 */
	public LivretA() {
		
	}
	
	/** Constructeur
	 *
	 * @param taux
	 */
	public LivretA(double taux) {
		super();
		this.taux = taux;
	}
	
	/** taux du compte **/
	private double taux;

	/** Getter
	 *
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}

	/** Setter
	 *
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}
}
