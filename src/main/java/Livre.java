import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 */

/** Représentation d'un livre
 *
 * @author KOMINIARZ Anaïs
 *
 */

@Entity
@Table(name = "livre")
public class Livre {

	@Id
	private Integer id;
	private String titre;
	private String auteur;

	@Override
	public String toString() {
		return "Titre : " + titre + " - Auteur : " + auteur;
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
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/** Setter
	 *
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/** Getter
	 *
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}

	/** Setter
	 *
	 * @param auteur the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	
	
}
