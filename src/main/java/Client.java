import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** Représentation d'un client de la bibliothèque
 *
 * @author KOMINIARZ Anaïs
 *
 */
@Entity
@Table(name = "client")
public class Client {

	@Id
	private Integer id;
	
	private String nom;
	private String prenom;
	
	@OneToMany(mappedBy="client") 
	private Set<Emprunt> emprunts; // référence vers les chambres
	
	
	public Client() {
		emprunts = new HashSet<Emprunt>(); 
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
	 * @return the emprunts
	 */
	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}

	/** Setter
	 *
	 * @param emprunts the emprunts to set
	 */
	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
}
