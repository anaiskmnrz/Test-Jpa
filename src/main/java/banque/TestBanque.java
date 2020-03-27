/**
 * 
 */
package banque;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/** Construction de notre base de donn�es banque
 *
 * @author KOMINIARZ Ana�s
 *
 */
public class TestBanque {

	private static final Logger LOGGER = Logger.getLogger(TestBanque.class.getName());
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Construction de l'usine � EntityManager (EntityManagerFactory - vie durant toute l'application)
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque-pu");
		 EntityManager entityManager = entityManagerFactory.createEntityManager();

	        // v�rification que l'entityManager est bien ouvert
	        LOGGER.log(Level.INFO, "Etat : " + entityManager.isOpen());
	        
	        EntityTransaction tx1 = entityManager.getTransaction();
	        tx1.begin();
	        
	        // insertion des banques
	        Banque banque1 = new Banque("Credit Agricole"); // objet transient
	        entityManager.persist(banque1);
	        
	        Banque creditMutuel = new Banque("Credit Mutuel"); // objet transient
	        entityManager.persist(creditMutuel);
	        
	        Banque banque3 = new Banque("ING Direct"); // objet transient
	        entityManager.persist(banque3);
	        
	        // insertion des clients
	         Client client1 = new Client("dupont", "cedric", creditMutuel);
	         entityManager.persist(client1);
	         
	         Adresse adresse2 = new Adresse(12, "rue des capucines", 59000, "Lille");
	         Client client2 = new Client("durand", "josephine", adresse2);
	         client2.setBanque(creditMutuel);
	         entityManager.persist(client2);
	         
	         
	         /*
	          * insertion d'une operation et d'un compte
	          */
	         //date de l'operation
	         LocalDateTime date3 = LocalDateTime.now().withDayOfMonth(31).withYear(2019).withMonth(7);
	         
	         //creation de l'operation  
	         Operation operation3 = new Operation(date3,150.0,"remboursement");
	         entityManager.persist(operation3);
	         
	         // creation d'un compte avec une opération 
	         Compte c3 = new Compte("0012",2589.23);
	         operation3.setCompte(c3);
	         c3.getOperations().add(operation3);
	         entityManager.persist(c3);
	         
	         // insertion d'un client avec un compte
	         Adresse adresse3 = new Adresse(14, "rue des cocquelicots", 59000, "Lille");
	         Client client3 = new Client("troino", "albert", adresse3);
	         client3.getComptes().add(c3);
	         c3.getClients().add(client3);
	         entityManager.persist(client3);
	        
	         // inserer un compte associe a deux clients
	         Compte c4 = new Compte("0013", 10500.01);
	         c4.getClients().add(client1);
	         c4.getClients().add(client2);
	         client1.getComptes().add(c4);
	         client2.getComptes().add(c4);
	         
	         entityManager.persist(c4);
	        
	        //inserer un client avec plusieurs comptes : 
	        
	        Adresse adresse4 = new Adresse(19, "rue des lilas", 59000, "Lille");
	        Client client4 = new Client("durand", "celestine", adresse4);
	        client4.setBanque(banque1);
	        
	        entityManager.persist(client4);
	        
	         // creation livret A
	         Compte lA = new LivretA(1.75);
	         lA.setNumero("123");
	         lA.setSolde(1569.4);
	         lA.getClients().add(client4);
	         client4.getComptes().add(lA);
	         
	         entityManager.persist(lA);
	         
	         //creation assurance vie
	         LocalDate date4 = LocalDate.of(2023, Month.DECEMBER, 25);
	         Compte AssuVie = new AssuranceVie(date4, 0.6);
	         AssuVie.setSolde(48749.0);
	         AssuVie.setNumero("234");
	         AssuVie.getClients().add(client4);
	         client4.getComptes().add(AssuVie);
	         
	         entityManager.persist(AssuVie);
	   
	         
	         //inserer des operations de type virement sur un compte
	         Operation virement = new Virement("lisa fretin");
	         virement.setMontant(15.5);
	         virement.setMotif("remboursement restaurant");
	         virement.setCompte(lA);
	         lA.getOperations().add(virement);
	         
	         entityManager.persist(virement);
	         entityManager.persist(lA); 
	         
	        //inserer des operations de type operation sur un compte 
	         Operation operation4 = new Operation(date3,150.0,"remboursement des vacances ");
	         entityManager.persist(operation4);
	         lA.getOperations().add(operation4);
	         operation4.setCompte(lA);
	        entityManager.persist(operation4);
	         
	        entityManager.persist(lA);
	         
	        tx1.commit();
	        entityManager.close();
	        entityManagerFactory.close();

	}

}
