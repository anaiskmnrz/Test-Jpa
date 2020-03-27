/**
 * 
 */
package banque;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Repr�sentation d'un compte d'un client de la banque : LivretA ou AssuranceVie
 *
 * @author KOMINIARZ Ana�s
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** numero de compte **/
	private String numero;

	/** solde du compte **/
	private Double solde;




	@ManyToMany
	@JoinTable(name = "compte_client", 
					joinColumns = @JoinColumn(name = "COMPTE_ID", referencedColumnName = "ID"), 
					inverseJoinColumns = @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID"))
	private Set<Client> clients = new HashSet<Client>();
	
	
	@OneToMany(mappedBy="compte") 
	private Set<Operation> operations = new HashSet<Operation>(); 
	
	/** Constructeur
	 *
	 */

	public Compte() {
		operations = new HashSet<Operation>();
	}
	
	/** Constructeur
	 *
	 * @param numero
	 * @param solde
	 */
	public Compte(String numero, Double solde, Set<Operation> operations) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.operations = operations;
	}
	
	
	/** Constructeur
	 *
	 * @param numero
	 * @param solde
	 */
	public Compte(String numero, Double solde) {
		super();
		this.numero = numero;
		this.solde = solde;
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
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/** Setter
	 *
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/** Getter
	 *
	 * @return the solde
	 */
	public Double getSolde() {
		return solde;
	}

	/** Setter
	 *
	 * @param solde the solde to set
	 */
	public void setSolde(Double solde) {
		this.solde = solde;
	}



	/** Getter
	 *
	 * @return the clients
	 */
	public Set<Client> getClients() {
		return clients;
	}

	/** Setter
	 *
	 * @param clients the clients to set
	 */
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	/** Getter
	 *
	 * @return the operations
	 */
	public Set<Operation> getOperations() {
		return operations;
	}

	/** Setter
	 *
	 * @param operations the operations to set
	 */
	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

}
