package main.banque;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="BANQUE")
public class EBanque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private int id;
	
	@Column(name = "NOM", length = 50, nullable = true, unique = false)
	private String nom;

	@OneToMany(mappedBy="clientBanque")
	private Set<EClient> clients;
	
	public EBanque() {
		super();
		this.clients = new HashSet<EClient>();
	}

	public EBanque(String nom) {
		super();
		this.nom = nom;
		this.clients = new HashSet<EClient>();
	}

	public EBanque(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
		this.clients = new HashSet<EClient>();
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

	@Override
	public String toString() {
		return "EBanque [id=" + id + ", nom=" + nom + "]";
	}
	
	
}
