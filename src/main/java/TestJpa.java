import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 */

/** Repr�sentation 
 *
 * @author KOMINIARZ Ana�s
 *
 */
public class TestJpa {

	private static final Logger LOGGER = Logger.getLogger(TestJpa.class.getName());
	
	public static void main(String[] args) {
		
		// �tape 2 - Construction de l'usine � EntityManager (EntityManagerFactory - vie durant toute l'application)
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("compta-pu");

        // �tape 3 - Obtention d'une instance d'EntityManager (id�alement dur�e de vie courte)
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // v�rification que l'entityManager est bien ouvert
        LOGGER.log(Level.INFO, "Etat : " + entityManager.isOpen());
        
        entityManager.close();
        entityManagerFactory.close();
	}

}
