package main.java;

import javax.persistence.*;

import main.model.ELivre;

public class TestJpa {

	public static void main(String[] args) {
		tp2();
	}

	
	public static void tp2() {

		EntityManagerFactory efm =null;
    	try 
    	{
	        efm = Persistence.createEntityManagerFactory("bddExercicesJPA");
	        EntityManager em = efm.createEntityManager();
	        
	        // Extraire un livre...
	        ELivre livreSelect = em.find(ELivre.class, 1);
	        System.out.println("-> Extraire un livre (Titre : "+ livreSelect.getTitre() +", Auteur : "+ livreSelect.getAuteur()+")");

	        // Insérer un nouveau livre
	        em.getTransaction().begin();
	        ELivre livreInsert = new ELivre();
	        livreInsert.setTitre("Notre-Dame de Paris");
	        livreInsert.setAuteur("Victor Hugo");
	        em.persist(livreInsert);
	        em.getTransaction().commit();
	        System.out.println("-> Insérer un livre (Id : "+ livreInsert.getId() +", Titre : "+ livreInsert.getTitre() +", Auteur : "+ livreInsert.getAuteur()+")");
	        
	        // Modifier un livre
	        em.getTransaction().begin();
	        ELivre livreUpdate = em.find(ELivre.class, 5);
	        String oldTitre = livreUpdate.getTitre();
	        livreUpdate.setTitre("Du plaisir dans la cuisine");
	        em.persist(livreUpdate);
	        em.getTransaction().commit();
	        System.out.println("-> Modifier un livre (Ancien titre : "+ oldTitre +", Nouveau titre : "+ livreUpdate.getTitre() +")");

	        // Extraire un livre en fonction du titre
	        TypedQuery<ELivre> qLivreTitre = em.createQuery("select l from ELivre l where l.titre = 'Germinal'", ELivre.class);
	        ELivre livreByTitre = qLivreTitre.getResultList().get(0);
	        System.out.println("-> Extraire un livre par le titre (Id : "+ livreByTitre.getId() +", Titre : "+ livreByTitre.getTitre() +", Auteur : "+ livreByTitre.getAuteur()+")");

	        // Extraire un livre en fonction du titre
	        TypedQuery<ELivre> qLivreAuteur = em.createQuery("select l from ELivre l where l.auteur = 'Jean-Pierre Coffe'", ELivre.class);
	        ELivre livreByAuteur = qLivreAuteur.getResultList().get(0);
	        System.out.println("-> Extraire un livre par l'auteur (Id : "+ livreByAuteur.getId() +", Titre : "+ livreByAuteur.getTitre() +", Auteur : "+ livreByAuteur.getAuteur()+")");

	        // Supprimer un livre
	        TypedQuery<ELivre> qLivreDelete = em.createQuery("select l from ELivre l where l.titre = 'Notre-Dame de Paris'", ELivre.class);
	        ELivre livreDelete = qLivreDelete.getResultList().get(0);
	        if(livreDelete != null) {
	        	System.out.println("-> Extraire le livre à supprimer (Id : "+ livreDelete.getId() +", Titre : "+ livreDelete.getTitre() +", Auteur : "+ livreDelete.getAuteur()+")");
		        em.getTransaction().begin();
		        em.remove(livreDelete);
		        em.getTransaction().commit();
		        System.out.println("-> Suppression du livre extrait !");
	        }

	        // Extraire tous les livres
	        TypedQuery<ELivre> qLivres = em.createQuery("select l from ELivre l", ELivre.class);
        	System.out.println("-> Extraire tous les livres :");
	        for(ELivre livre : qLivres.getResultList()) {
	        	System.out.println("->   (Id : "+ livre.getId() +", Titre : "+ livre.getTitre() +", Auteur : "+ livre.getAuteur()+")");
	        }
	        
	        em.close();
    	}
    	catch(Exception e) {e.printStackTrace();}
    	finally {
    		if(efm != null) efm.close();
    	}
	}
}
