/**
 * 
 */
package banque;

import java.time.LocalDate;

import javax.persistence.Entity;

/** Représentation d'un compte Assurance vie
 *
 * @author KOMINIARZ Anaïs
 *
 */

@Entity
public class AssuranceVie extends Compte {

	/** date de la fin du compte **/
	private LocalDate dateFin;
	/** taux du compte **/
	private double taux;
	
	public AssuranceVie() {
		
	}
	
	/** Constructeur
	 *
	 * @param dateFin
	 * @param taux
	 */
	public AssuranceVie(LocalDate dateFin, double taux) {
		super();
		this.dateFin = dateFin;
		this.taux = taux;
	}



	/** Getter
	 *
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}
	/** Setter
	 *
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
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
