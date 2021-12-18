package main.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="CLIENT")
public class EClient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NOM", length = 50, nullable = false, unique = false)
	private String nom;
	
	@Column(name = "PRENOM", length = 50, nullable = false, unique = false)
	private String prenom;
	
	@OneToMany(mappedBy = "empruntClients")
	private Set<EEmprunt> clientEmprunts;

	
	public EClient() {

	}

	
	
	/**
	 * @return the clientEmprunts
	 */
	public Set<EEmprunt> getClientEmprunts() {
		return clientEmprunts;
	}



	/**
	 * @param clientEmprunts the clientEmprunts to set
	 */
	public void setClientEmprunts(Set<EEmprunt> clientEmprunts) {
		this.clientEmprunts = clientEmprunts;
	}



	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}
