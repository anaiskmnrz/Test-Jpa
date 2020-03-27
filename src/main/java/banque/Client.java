/**
 * 
 */
package banque;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/** Repr�sentation d'un client de la banque
 *
 * @author KOMINIARZ Ana�s
 *
 */
@Entity 
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	/** nom du client **/
	private String nom;

	/** prenom du client **/
	private String prenom;
	/** date de naissance du client **/
	private LocalDate dateNaissance;
	
	
	/** adresse du client **/
	@Embedded
	private Adresse adresse;
	
	@ManyToOne
	@JoinColumn(name = "BANQUE_ID")
	private Banque banque;
	
	@ManyToMany(mappedBy="clients") 
	private Set<Compte> comptes = new HashSet<Compte>();
	
	public Client() {
		
	}
	
	/** Constructeur
	 *
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param banque
	 */
	public Client(String nom, String prenom, Banque banque) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.banque = banque;
	}
	

	/** Constructeur
	 *
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param banque
	 */
	public Client(String nom, String prenom, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	
	public Client(String nom, String prenom, Adresse adresse, Banque banque, Set<Compte> comptes) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.banque = banque;
		this.comptes = comptes;
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 *
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Getter
	 *
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/** Setter
	 *
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/** Getter
	 *
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/** Setter
	 *
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/** Getter
	 *
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/** Setter
	 *
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/** Getter
	 *
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/** Setter
	 *
	 * @param banque the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/** Getter
	 *
	 * @return the comptes
	 */
	public Set<Compte> getComptes() {
		return comptes;
	}

	/** Setter
	 *
	 * @param comptes the comptes to set
	 */
	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

}
