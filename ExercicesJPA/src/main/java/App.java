package main.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.*;

import main.banque.Adresse;
import main.banque.EAssuranceVie;
import main.banque.EBanque;
import main.banque.ECompte;
import main.banque.ELivretA;
import main.banque.EOperation;
import main.banque.EVirement;
import main.model.EClient;
import main.model.EEmprunt;
import main.model.ELivre;

public class App {
	/* CONSTANTES */

	// CONSTANTES / Menu principal
	/** Préfixe pour faire ressortir les lignes affichées dans la console */
	private final static String PREFIX	= "-> ";
	
	/** Titre pour le menu principal */
	private final static String MENU_LIB	= PREFIX +"Menu principal :";
	
	/** Pour demander le choix de l'utilisateur */
	private final static String QUEL_CHOIX_LIB		= PREFIX +"Quel est votre choix ? ";
	
	/** Pour afficher un message d'erreur pour le choix sélectionné par l'utilisateur */
	private final static String CHOIX_INCONNU		= PREFIX +"KO : Choix inconnu !";
	
	/** Pour afficher le début du TP */
	private final static String DEBUT_TP			= "\n"+ PREFIX +"Début du TP";

	/** Pour afficher la fin du TP */
	private final static String FIN_TP				= PREFIX +"Fin du TP";
	

	
	// CONSTANTES / Menu principal / Choix / Codes
	/** Code du choix {@value #MENU_QUITTER_LIB} pour le menu principal */
	private final static String MENU_QUITTER		= "0";
	
	/** Code du choix {@value #MENU_TP1_LIB} pour le menu principal */
	private final static String MENU_TP1			= "1";
	
	/** Code du choix {@value #MENU_TP2_LIB} pour le menu principal */
	private final static String MENU_TP2			= "2";
	
	/** Code du choix {@value #MENU_TP3_LIB} pour le menu principal */
	private final static String MENU_TP3			= "3";
	
	/** Code du choix {@value #MENU_TP4_LIB} pour le menu principal */
	private final static String MENU_TP4			= "4";

	/** Code du choix {@value #MENU_TP5_LIB} pour le menu principal */
	private final static String MENU_TP5			= "5";

	
	// CONSTANTES / Menu principal / Choix / Libellés
	/** Libellé complet du choix {@value #MENU_QUITTER_LIB} pour le menu principal */
	private final static String MENU_QUITTER_LIB		= MENU_QUITTER	+ ". Quitter le programme";

	/** Libellé complet du choix {@value #MENU_TP1_LIB} pour le menu principal */
	private final static String MENU_TP1_LIB			= MENU_TP1	+ ". Prendre en main JPA avec un accès simple en base de données";
	
	/** Libellé complet du choix {@value #MENU_TP2_LIB} pour le menu principal */
	private final static String MENU_TP2_LIB			= MENU_TP2	+ ". Savoir utiliser des entités (débutant)";
	
	/** Libellé complet du choix {@value #MENU_TP3_LIB} pour le menu principal */
	private final static String MENU_TP3_LIB			= MENU_TP3	+ ". Savoir utiliser des entités (avancé)";
	
	/** Libellé complet du choix {@value #MENU_TP4_LIB} pour le menu principal */
	private final static String MENU_TP4_LIB			= MENU_TP4	+ ". Se renforcer dans la modélisation JPA (annotations relationnelles)";

	/** Libellé complet du choix {@value #MENU_TP5_LIB} pour le menu principal */
	private final static String MENU_TP5_LIB			= MENU_TP5	+ ". Se renforcer dans la modélisation JPA (relations d’héritage)";

	
	/** Affichage du menu principal et aiguillage sur le tp adéquat.
	 * @param args Arguments en entrée si nécessaire
	 */
	public static void main(String[] args) {
		System.out.println("Début du programme...");
		Scanner in = new Scanner(System.in);

		String reponse = "";
		while(!reponse.equals(MENU_QUITTER)) {
			reponse = afficherMenuPrincipal(in);
	        switch(reponse) {
	        	case MENU_QUITTER :
	        		break;
	        	case MENU_TP1 :
	        		System.out.println(DEBUT_TP + MENU_TP1_LIB);
	        		tp1();
	        		System.out.println(FIN_TP + MENU_TP1_LIB);
	        		break;
	        	case MENU_TP2 :
	        		System.out.println(DEBUT_TP + MENU_TP2_LIB);
	        		tp2();
	        		System.out.println(FIN_TP + MENU_TP2_LIB);
	        		break;
	        	case MENU_TP3 :
	        		System.out.println(DEBUT_TP + MENU_TP3_LIB);
	        		tp3();
	        		System.out.println(FIN_TP + MENU_TP3_LIB);
	        		break;
	        	case MENU_TP4 :
	        		System.out.println(DEBUT_TP + MENU_TP4_LIB);
	        		tp4();
	        		System.out.println(FIN_TP + MENU_TP4_LIB);
	        		break;
	        	case MENU_TP5 :
	        		System.out.println(DEBUT_TP + MENU_TP5_LIB);
	        		tp5();
	        		System.out.println(FIN_TP + MENU_TP5_LIB);
	        		break;
	        	default :
	        		System.out.println(CHOIX_INCONNU);
	        		break;
	        }
		}
		in.close();
		System.out.println("\nFin du programme !");
	}
	
	
	/** Affiche la liste des choix possibles pour le menu principal
	 * @param in Scanner permettant de lire le choix saisi par l'utilisateur
	 * @return Choix du menu principal saisi par l'utilisateur
	 */
	private static String afficherMenuPrincipal(Scanner in) {
		System.out.println("");
		System.out.println(MENU_LIB);
		System.out.println(MENU_QUITTER_LIB);		
		System.out.println(MENU_TP1_LIB);
		System.out.println(MENU_TP2_LIB);
		System.out.println(MENU_TP3_LIB);
		System.out.println(MENU_TP4_LIB);
		System.out.println(MENU_TP5_LIB);
		System.out.print  (QUEL_CHOIX_LIB);	
		return in.nextLine();
	}
	
	private static void afficheConsole(String msg) {
		System.out.println(PREFIX + msg);
	}

	private static void tp1() {
		EntityManagerFactory efm = null;
		EntityManager em = null;
    	try 
    	{
	        efm = Persistence.createEntityManagerFactory("bddExercicesJPA");
	        em = efm.createEntityManager();
    	}
    	catch(Exception e) {e.printStackTrace();}
    	finally {
    		if(em != null && em.isOpen()) {
    			em.close();
    		}
    		if(efm != null) {
    			efm.close();
    		}
    	}
	}

	private static void tp2() {
		EntityManagerFactory efm = null;
		EntityManager em = null;
    	try 
    	{
	        efm = Persistence.createEntityManagerFactory("bddExercicesJPA");
	        em = efm.createEntityManager();
	        em.getTransaction().begin();

	        System.out.println();
	        afficheConsole("Exo 1 : Réalisez un find simple permettant d’extraire un livre en fonction de son identifiant et affichez son titre et son auteur.");
	        afficheConsole("Extraire le livre n°1");
	        ELivre livreSelect = em.find(ELivre.class, 1);
	        afficheConsole("Résultat = "+ livreSelect);
	        
	        System.out.println();
	        afficheConsole("Exo 2 : Insérez un nouveau Livre de votre choix en base de données");
	        afficheConsole("Insérer le livre « Notre-Dame de Paris » écrit par « Victor Hugo »");
	        ELivre livreInsert = new ELivre();
	        livreInsert.setTitre("Notre-Dame de Paris");
	        livreInsert.setAuteur("Victor Hugo");
	        em.persist(livreInsert);
	        afficheConsole("Résultat = "+ livreInsert);
        
	        System.out.println();
	        afficheConsole("Exo 3 : Modifiez le titre du livre n°5  : le nouveau titre doit être « Du plaisir dans la cuisine » au lieu de « 1001 recettes de Cuisine ».");
	        afficheConsole("Modifier le titre du livre n°5 « Du plaisir dans la cuisine » par « 1001 recettes de Cuisine »");
	        ELivre livreUpdate = em.find(ELivre.class, 5);
	        livreUpdate.setTitre("1001 recettes de Cuisine");
	        em.persist(livreUpdate);
	        afficheConsole("Résultat = "+ livreUpdate);
	        
	        System.out.println();
	        afficheConsole("Exo 4 : Faites une requête JPQL pour extraire de la base un livre en fonction de son titre.");
	        afficheConsole("Extraire le livre dont le titre est « Germinal »");
	        TypedQuery<ELivre> qLivreTitre = em.createQuery("select l from ELivre l where l.titre = 'Germinal'", ELivre.class);
	        ELivre livreByTitre = qLivreTitre.getResultList().get(0);
	        afficheConsole("Résultat = "+ livreByTitre);

	        System.out.println();
	        afficheConsole("Exo 5 : Faites une requête JPQL pour extraire de la base un livre en fonction de son auteur.");
	        afficheConsole("Extraire le livre dont l'auteur est « Jean-Pierre Coffe »");
	        TypedQuery<ELivre> qLivreAuteur = em.createQuery("select l from ELivre l where l.auteur = 'Jean-Pierre Coffe'", ELivre.class);
	        ELivre livreByAuteur = qLivreAuteur.getResultList().get(0);
	        afficheConsole("Résultat = "+ livreByAuteur);
	        
	        System.out.println();
	        afficheConsole("Exo 6 : Supprimez un livre de votre choix en base de données.");
	        afficheConsole("Supprimer le livre n°"+ livreInsert.getId() +" « Notre-Dame de Paris » écrit par « Victor Hugo »");
	        em.remove(livreInsert);
	        ELivre livreDeleted = em.find(ELivre.class, livreInsert.getId());
	        if(livreDeleted == null) {
	        	afficheConsole("Résultat = Livre effectivement supprimé\n");
	        }
	        else {
	        	afficheConsole("Résultat = Livre non supprimé -> "+ livreDeleted);
	        }
	        
	        System.out.println();
	        afficheConsole("Exo 7 : Affichez la liste de tous les livres présents en base de données (titre et auteur).");
	        TypedQuery<ELivre> qLivres = em.createQuery("select l from ELivre l", ELivre.class);
	        afficheConsole("Résultat =");
	        for(ELivre livre : qLivres.getResultList()) {
	        	afficheConsole("   "+ livre);
	        }
	        System.out.println();
    	}
    	catch(Exception e) {e.printStackTrace();}
    	finally {
    		if(em.getTransaction().isActive()) {
    			em.getTransaction().rollback();
    		}
    		if(em != null && em.isOpen()) {
    			em.close();
    		}
    		if(efm != null) {
    			efm.close();
    		}
    	}
	}

	private static void tp3() {
		EntityManagerFactory efm = null;
		EntityManager em = null;
    	try 
    	{
	        efm = Persistence.createEntityManagerFactory("bddExercicesJPA");
	        em = efm.createEntityManager();
	        em.getTransaction().begin();
	        
	        afficheConsole("Exo 1 : Réalisez une requête qui permet d’extraire un emprunt et tous ses livres associés.");
	        afficheConsole("Extraire la liste des livres de l'emprunt n°1");
	        EEmprunt empruntLivres = em.find(EEmprunt.class, 1);
	        afficheConsole("Résultat = ");
	        afficheConsole(empruntLivres.toString());
	        empruntLivres.getEmpruntLivres().stream().forEach(el -> afficheConsole(el.toString()));

	        System.out.println();
	        afficheConsole("Exo 2 : Réalisez une requête qui permet d’extraire tous les emprunts d’un client donné.");
	        afficheConsole("Extraire la liste des emprunts du client n°3");
	        EClient clientEmprunts = em.find(EClient.class, 3);
	        afficheConsole("Résultat = ");
	        afficheConsole(clientEmprunts.toString());
	        clientEmprunts.getClientEmprunts().stream().forEach(ce -> afficheConsole(ce.toString()));
    	
    	}
    	catch(Exception e) {e.printStackTrace();}
    	finally {
    		if(em.getTransaction().isActive()) {
    			em.getTransaction().rollback();
    		}
    		if(em != null && em.isOpen()) {
    			em.close();
    		}
    		if(efm != null) {
    			efm.close();
    		}
    	}
	}

	private static void tp4() {
		EntityManagerFactory efm = null;
		EntityManager em = null;
    	try 
    	{
	        efm = Persistence.createEntityManagerFactory("bddBanqueJPA_tp4");
	        em = efm.createEntityManager();
	        em.getTransaction().begin();

	        insererBanques(em);
	        insererComptes(em);
	        insererClients(em);
	        insererOperations(em);

    	}
    	catch(Exception e) {e.printStackTrace();}
    	finally {
    		if(em.getTransaction().isActive()) {
    			em.getTransaction().commit();
    		}
    		if(em != null && em.isOpen()) {
    			em.close();
    		}
    		if(efm != null) {
    			efm.close();
    		}
    	}
	}

	
	private static void tp5() {
		EntityManagerFactory efm = null;
		EntityManager em = null;
    	try 
    	{
	        efm = Persistence.createEntityManagerFactory("bddBanqueJPA_tp5");
	        em = efm.createEntityManager();
	        em.getTransaction().begin();
	        
	        insererBanques(em);
	        insererComptes(em);
	        insererLivretsA(em);
	        insererAssurancesVie(em);
	        insererClients(em, true, true, true);
	        insererOperations(em);
	        insererVirements(em);
   	
    	}
    	catch(Exception e) {e.printStackTrace();}
    	finally {
    		if(em.getTransaction().isActive()) {
    			em.getTransaction().commit();
    		}
    		if(em != null && em.isOpen()) {
    			em.close();
    		}
    		if(efm != null) {
    			efm.close();
    		}
    	}
	}
	
	
	private static void insererBanques(EntityManager em){
        System.out.println();
        afficheConsole("Etape 1 : Insérer des banques");
        em.persist(new EBanque("Crédit Agricole"));
        em.persist(new EBanque("Crédit Mutuel"));
        em.persist(new EBanque("Société Générale"));
        em.persist(new EBanque("BNP Paribas"));
        TypedQuery<EBanque> qBanques = em.createQuery("select b from EBanque b", EBanque.class);
        afficheConsole("Résultats =");
        qBanques.getResultList().stream().forEach(b -> afficheConsole("   "+b.toString()));
	}
	
	private static void insererComptes(EntityManager em){
	    System.out.println();
	    afficheConsole("Etape 2.1 : Insérer des comptes");
	    for(int i = 0; i < 16; i++) {
	    	String numero = calcRandomValue(100000, 900000).toString();
	    	Double solde = Double.valueOf(calcRandomValue(-100000, 500000)) / 100;
	    	em.persist(new ECompte(numero, solde));
	    }
	    TypedQuery<ECompte> qComptes = em.createQuery("select c from ECompte c", ECompte.class);
	    afficheConsole("Résultats =");
	    qComptes.getResultList().stream().forEach(c -> afficheConsole("   "+c.toString()));
	}

	private static void insererLivretsA(EntityManager em){
	    System.out.println();
	    afficheConsole("Etape 2.2 : Insérer des livrets A");
	    for(int i = 0; i < 16; i++) {
	    	String numero = calcRandomValue(100000, 900000).toString();
	    	Double solde = Double.valueOf(calcRandomValue(-100000, 500000)) / 100;
	    	Double taux = Double.valueOf(calcRandomValue(80, 650)) / 100;
	    	em.persist(new ELivretA(numero, solde, taux));
	    }
	    TypedQuery<ELivretA> qLivretA = em.createQuery("select l from ELivretA l", ELivretA.class);
	    afficheConsole("Résultats =");
	    qLivretA.getResultList().stream().forEach(c -> afficheConsole("   "+c.toString()));
	}
	
	private static void insererAssurancesVie(EntityManager em){
	    System.out.println();
	    afficheConsole("Etape 2.3 : Insérer des assurances vie");
	    for(int i = 0; i < 16; i++) {
	    	String numero = calcRandomValue(100000, 900000).toString();
	    	Double solde = Double.valueOf(calcRandomValue(-100000, 500000)) / 100;
	    	Date dateFin = calcRandomDate(2029);
	    	Double taux = Double.valueOf(calcRandomValue(-100000, 500000)) / 100;
	    	em.persist(new EAssuranceVie(numero, solde, dateFin, taux));
	    }
	    TypedQuery<EAssuranceVie> qAssuranceVie = em.createQuery("select a from EAssuranceVie a", EAssuranceVie.class);
	    afficheConsole("Résultats =");
	    qAssuranceVie.getResultList().stream().forEach(c -> afficheConsole("   "+c.toString()));
	}
	
	private static void insererClients(EntityManager em){
		insererClients(em, false, false, false);
	}

	private static void insererClients(EntityManager em, Boolean CompteMultiClients, Boolean withLivretA, Boolean withAssuranceVie){
        System.out.println();
        afficheConsole("Etape 3 : Insérer des clients");
        em.persist(creerClient(em, 1, "DUPONT", "Pierre", "27/11/1985", 13, "Rue de l'Eglise", 95130, "Le Plessis Bouchard", "Société Générale", CompteMultiClients, withLivretA, withAssuranceVie));
        em.persist(creerClient(em, 2, "DURANT", "Nathalie", "01/02/1975", 1, "Rue de la République", 95120, "Ermont", "Société Générale", CompteMultiClients, withLivretA, withAssuranceVie));
        em.persist(creerClient(em, 3, "PONSART", "Nicolas", "13/08/1968", 18, "Rue Henri Dunant", 95000, "Pontoise", "Crédit Agricole", CompteMultiClients, withLivretA, withAssuranceVie));
        em.persist(creerClient(em, 4, "MARZIN", "Eric", "19/01/1990", 26, "Rue Raymond Poincarré", 95210, "Saint Gratien", "Crédit Mutuel", CompteMultiClients, withLivretA, withAssuranceVie));
        em.persist(creerClient(em, 5, "LORRAIN", "Roxane", "30/12/2001", 10, "Rue de la Mairie", 95160, "Eaubonne", "Crédit Mutuel", CompteMultiClients, withLivretA, withAssuranceVie));
        em.persist(creerClient(em, 6, "DELEVALLEE", "Lionel", "02/06/1981", 35, "Rue Napoléon", 95130, "Franconville", "BNP Paribas", CompteMultiClients, withLivretA, withAssuranceVie));
        em.persist(creerClient(em, 7, "WAGNER", "Edouard", "29/09/1984", 7, "Rue des moineaux", 95580, "Margency", "Crédit Agricole", CompteMultiClients, withLivretA, withAssuranceVie));
        em.persist(creerClient(em, 8, "JOUGLAR", "Nicole", "10/07/1976", 11, "Rue Pasteur", 95240, "Andilly", "BNP Paribas", CompteMultiClients, withLivretA, withAssuranceVie));
        TypedQuery<main.banque.EClient> qClients = em.createQuery("select c from EClient c", main.banque.EClient.class);
        afficheConsole("Résultats =");
        qClients.getResultList().stream().forEach(c -> afficheConsole("   "+c.toString()));
	}
	
	private static main.banque.EClient creerClient(EntityManager em, Integer index, String nom, String prenom, String dtNaissance, int numero, String rue, int codePostal, String ville, String nomBanque, Boolean CompteMultiClients, Boolean withLivretA, Boolean withAssuranceVie){
		main.banque.EClient client = new main.banque.EClient();
		client.setNom(nom);
		client.setPrenom(prenom);
		try {
			client.setDateNaissance(new SimpleDateFormat("dd/MM/yyyy").parse(dtNaissance));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		client.setAdresse(new Adresse(numero, rue, codePostal, ville));
        TypedQuery<EBanque> qBanque = em.createQuery("select b from EBanque b where b.nom = '"+ nomBanque +"'", EBanque.class);
        client.setClientBanque(qBanque.getResultList().get(0));
        
        client.getClientComptes().add(em.find(ECompte.class, index));
        client.getClientComptes().add(em.find(ECompte.class, index + 8));
        
        if(CompteMultiClients) {
            client.getClientComptes().add(em.find(ECompte.class, index + 4));
        }
        
        if(withLivretA) {
        	TypedQuery<ELivretA> qLivretA = em.createQuery("select l from ELivretA l", ELivretA.class);
            client.getClientComptes().add(qLivretA.getResultList().get(calcRandomValue(0, qLivretA.getResultList().size() - 1)));
        }
        if(withAssuranceVie) {
        	TypedQuery<EAssuranceVie> qAssuranceVie = em.createQuery("select a from EAssuranceVie a", EAssuranceVie.class);
            client.getClientComptes().add(qAssuranceVie.getResultList().get(calcRandomValue(0, qAssuranceVie.getResultList().size() - 1)));
        }
		return client;
	}

	private static void insererOperations(EntityManager em) {
	    System.out.println();
	    TypedQuery<ECompte> qComptes = em.createQuery("select c from ECompte c", ECompte.class);
	    afficheConsole("Etape 4.1 : Insérer des opérations");
	    for(int i = 0; i < 100; i++) {
	    	em.persist(creerOperation(qComptes.getResultList()));
	    }
	    TypedQuery<EOperation> qOperations = em.createQuery("select o from EOperation o", EOperation.class);
	    afficheConsole("Résultats =");
	    qOperations.getResultList().stream().forEach(o -> afficheConsole("   "+o.toString()));
	}
	
	private static void insererVirements(EntityManager em) {
	    System.out.println();
	    TypedQuery<ECompte> qComptes = em.createQuery("select c from ECompte c", ECompte.class);
	    afficheConsole("Etape 4.2 : Insérer des virements");
	    for(int i = 0; i < 100; i++) {
	    	em.persist(creerVirement(qComptes.getResultList()));
	    }
	    TypedQuery<EOperation> qOperations = em.createQuery("select o from EOperation o", EOperation.class);
	    afficheConsole("Résultats =");
	    qOperations.getResultList().stream().forEach(o -> afficheConsole("   "+o.toString()));
	}

	private static EOperation creerOperation(List<ECompte> comptes){
		Boolean isDebit = (calcRandomValue(0, 1) == 0);
		Date date = calcRandomDate(2021);
    	Double montant = (Double.valueOf(calcRandomValue(10000, 100000)) / 100) * (isDebit ? -1 : 1);
    	String motif = (isDebit ? "Prélèvement n°" : "Versement n°")+ calcRandomValue(1000, 9000).toString();
		return new EOperation(date, montant, motif, comptes.get(calcRandomValue(0, comptes.size() - 1)));
	}

	private static EVirement creerVirement(List<ECompte> comptes){
		Boolean isDebit = (calcRandomValue(0, 1) == 0);
		Date date = calcRandomDate(2021);
    	Double montant = (Double.valueOf(calcRandomValue(10000, 100000)) / 100) * (isDebit ? -1 : 1);
    	String motif = "Virement n°"+ calcRandomValue(1000, 9000).toString();
		return new EVirement(date, montant, motif, comptes.get(calcRandomValue(0, comptes.size() - 1)), "Pierre Durand n°"+ calcRandomValue(1, 1000).toString());
	}
	
	
	
	private static Integer calcRandomValue(Integer min, Integer max) {
		return (int)Math.floor(Math.random() * (max - min + 1) + min);
	}
	
	public static Date calcRandomDate(Integer annee) {
		Long milliStart = null;
		Long milliEnd = null;
		try {
			milliStart = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/"+ annee.toString()).getTime();
			milliEnd = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/"+ annee.toString()).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Long randomMilli = ThreadLocalRandom.current().nextLong(milliStart, milliEnd);
	    return new Date(randomMilli);
	}
	
}
