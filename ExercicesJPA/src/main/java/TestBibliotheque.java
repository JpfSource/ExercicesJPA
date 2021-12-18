package main.java;

import javax.persistence.*;

import main.model.EClient;
import main.model.EEmprunt;
import main.model.ELivre;

public class TestBibliotheque {

	public static void main(String[] args) {
		tp3();
	}
	
	private static void tp3() {
		EntityManagerFactory efm =null;
    	try 
    	{
	        efm = Persistence.createEntityManagerFactory("bddExercicesJPA");
	        EntityManager em = efm.createEntityManager();

	        // Extraire un emprunt et tous ses livres associés
	        EEmprunt empruntLivres = em.find(EEmprunt.class, 1);
	        if(empruntLivres != null) {
		        for(ELivre livre : empruntLivres.getEmpruntLivres()) {
			        System.out.println("-> Liste des livres de l'emprunt n°1 (Titre : "+ livre.getTitre() +", Auteur : "+ livre.getAuteur()+")");
		        }
	        }

	        // Extraire un client et tous ses emprunts associéss
	        EClient clientEmprunts = em.find(EClient.class, 3);
	        for(EEmprunt emprunt : clientEmprunts.getClientEmprunts() ) {
		        System.out.println("-> Liste des emprunts du client n°3 (Début : "+ emprunt.getDateDebut() +", Fin : "+ emprunt.getDateFin() +", Délai : "+ emprunt.getDelai() +")");
	        }

	        em.close();
    	}
    	catch(Exception e) {e.printStackTrace();}
    	finally {
    		if(efm != null) efm.close();
    	}
	}

}
