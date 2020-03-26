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
		
		// étape 2 - Construction de l'usine à EntityManager (EntityManagerFactory - vie durant toute l'application)
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bibliotheque-pu");

        // étape 3 - Obtention d'une instance d'EntityManager (idéalement durée de vie courte)
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // vérification que l'entityManager est bien ouvert
        LOGGER.log(Level.INFO, "Etat : " + entityManager.isOpen());
        
        //récupérer le livre d'id 3
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
        
        entityManager.close();
        entityManagerFactory.close();
	}

}
