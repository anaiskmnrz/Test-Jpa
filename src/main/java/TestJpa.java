import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("compta-pu");

        // étape 3 - Obtention d'une instance d'EntityManager (idéalement durée de vie courte)
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // vérification que l'entityManager est bien ouvert
        LOGGER.log(Level.INFO, "Etat : " + entityManager.isOpen());
        
        entityManager.close();
        entityManagerFactory.close();
	}

}
