/**
 * 
 */
package banque;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/** Repr�sentation d'une op�ration de la banque
 *
 * @author KOMINIARZ Ana�s
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	/** date de l'op�ration **/
	private LocalDateTime date;
	/** montant de l'op�ration **/
	private Double montant;
	/** motif de l'op�ration **/
	private String motif;
	
	/** operations sur un compte **/
	@ManyToOne
	@JoinColumn(name = "COMPTE_ID")
	private Compte compte;
	
	
	
	/** Constructeur
	 *
	 */
	public Operation() {
		
	}

	/** Constructeur
	 *
	 * @param date
	 * @param montant
	 * @param motif
	 */
	public Operation(LocalDateTime date, Double montant, String motif) {
		super();
		this.date = date;
		this.montant = montant;
		this.motif = motif;
	}
	
	/** Getter
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/** Setter
	 *
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/** Getter
	 *
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}
	/** Setter
	 *
	 * @param date the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	/** Getter
	 *
	 * @return the montant
	 */
	public Double getMontant() {
		return montant;
	}
	/** Setter
	 *
	 * @param montant the montant to set
	 */
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	/** Getter
	 *
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}
	/** Setter
	 *
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

	/** Getter
	 *
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/** Setter
	 *
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
}
