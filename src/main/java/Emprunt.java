import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 */

/** Représentation d'un emprunt à la bibliothèque
 *
 * @author KOMINIARZ Anaïs
 *
 */

@Entity
@Table(name = "emprunt")
public class Emprunt {

	@Id
	private Integer id;
	private Date date_debut;
	private Date date_fin;
	private Integer delai;
	private Integer id_client;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	
	@ManyToMany
	@JoinTable ( name = "compo", 
				joinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"),
				inverseJoinColumns = @JoinColumn(name = "ID_EMP",referencedColumnName = "ID")
	)
	private Set<Livre> livres;
	
	@Override
	public String toString() {
		return " Emprunt du " + date_debut + " au " + date_fin + " - délai : " + delai + " jours";
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
	 * @return the date_debut
	 */
	public Date getDate_debut() {
		return date_debut;
	}
	/** Setter
	 *
	 * @param date_debut the date_debut to set
	 */
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	/** Getter
	 *
	 * @return the date_fin
	 */
	public Date getDate_fin() {
		return date_fin;
	}
	/** Setter
	 *
	 * @param date_fin the date_fin to set
	 */
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	/** Getter
	 *
	 * @return the delai
	 */
	public Integer getDelai() {
		return delai;
	}
	/** Setter
	 *
	 * @param delai the delai to set
	 */
	public void setDelai(Integer delai) {
		this.delai = delai;
	}
	/** Getter
	 *
	 * @return the id_client
	 */
	public Integer getId_client() {
		return id_client;
	}
	/** Setter
	 *
	 * @param id_client the id_client to set
	 */
	public void setId_client(Integer id_client) {
		this.id_client = id_client;
	}
	/** Getter
	 *
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}
	/** Setter
	 *
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	/** Getter
	 *
	 * @return the livre
	 */
	public Set<Livre> getLivre() {
		return livres;
	}
	/** Setter
	 *
	 * @param livre the livre to set
	 */
	public void setLivre(Set<Livre> livres) {
		this.livres = livres;
	}
}
