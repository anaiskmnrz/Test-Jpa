/**
 * 
 */
package banque;

import javax.persistence.Embeddable;

/** Représentation de l'adresse d'un client de la banque
 *
 * @author KOMINIARZ Anaïs
 *
 */
@Embeddable
public class Adresse {
	
	/** numero de la rue **/
	private Integer numero;
	/** nom de la rue **/
	private String rue;
	/** code postal **/
	private Integer codePostal;
	/** nom de la ville **/
	private String ville;
	
	
	/** Constructeur
	 *
	 */
	public Adresse() {
	}
	
	
	/** Constructeur
	 *
	 * @param numero
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Adresse(Integer numero, String rue, Integer codePostal, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}


}
