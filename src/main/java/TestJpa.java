import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;




/**
 * 
 */

/** Représentation 
 *
 * @author KOMINIARZ Anaïs
 *
 */
public class TestJpa {

	private static final Logger LOGGER = Logger.getLogger(TestJpa.class.getName());
	
	public static void main(String[] args) {
		
		// Construction de l'usine à EntityManager (EntityManagerFactory - vie durant toute l'application)
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bibliotheque-pu");

        // Obtention d'une instance d'EntityManager (idéalement durée de vie courte)
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // vérification que l'entityManager est bien ouvert
        LOGGER.log(Level.INFO, "Etat : " + entityManager.isOpen());
        
        // récupération du livre d'id 3
        Livre livre1 = entityManager.find(Livre.class, 3);
        LOGGER.log(Level.INFO, "Id du livre : " + livre1.getId() + " - Titre du livre : " + livre1.getTitre() + 
        		" - Auteur du livre : " + livre1.getAuteur());
        
        // récupérer le livre de nom Guerre et Paix
        TypedQuery<Livre> createQuery = entityManager.createQuery("SELECT l FROM Livre l WHERE l.titre= :titre", Livre.class);
        createQuery.setParameter("titre", "Guerre et Paix");
  
        // soit de cette façon
        List<Livre> resultList = createQuery.getResultList();
        
        // soit de celle-ci car on est sûrs qu'il n'y a qu'un Guerre et Paix
        Livre singleResult = createQuery.getSingleResult();
        System.out.println(singleResult);
        
        // extraire un emprunt avec tous les livres associés
       TypedQuery<Emprunt> createQuery2 = entityManager.createQuery("SELECT e FROM Emprunt e",Emprunt.class);
       List<Emprunt> resultList2 = createQuery2.getResultList();
       
       for (Emprunt emprunt : resultList2) {
    	   System.out.println(emprunt.getLivre());
       }
       
       /* Travail en plus car j'avais mal lu la consigne
        * 
        * // extraire un livre avec tous ses emprunts associés
       Livre livre2 = entityManager.find(Livre.class, 2);
       System.out.println(livre2.getEmprunts());
        */
       
       
        // extraire tous les emprunts d'un client donné
       Client client1 = entityManager.find(Client.class, 2);
       System.out.println(client1.getEmprunts());
        
        entityManager.close();
        entityManagerFactory.close();
	}

}
