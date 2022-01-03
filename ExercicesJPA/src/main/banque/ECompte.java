package main.banque;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="COMPTE")
@Inheritance(strategy = InheritanceType.JOINED)
public class ECompte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private int id;

	@Column(name = "NUMERO", length = 20, nullable = true, unique = false)
	private String numero;

	@Column(name = "SOLDE", nullable = true, unique = false)
	private Double solde;

	@ManyToMany(mappedBy = "clientComptes")
	private Set<EClient> clients;
	
	@OneToMany(mappedBy = "operationCompte")
	private Set<EOperation> operations;
	
	
	
	public ECompte() {
		super();
		this.clients = new HashSet<EClient>();
		this.operations = new HashSet<EOperation>();
	}

	public ECompte(String numero, Double solde) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.clients = new HashSet<EClient>();
		this.operations = new HashSet<EOperation>();
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
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the solde
	 */
	public Double getSolde() {
		return solde;
	}

	/**
	 * @param solde the solde to set
	 */
	public void setSolde(Double solde) {
		this.solde = solde;
	}

	/**
	 * @return the clients
	 */
	public Set<EClient> getClients() {
		return clients;
	}

	/**
	 * @param clients the clients to set
	 */
	public void setClients(Set<EClient> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "ECompte [id=" + id + ", numero=" + numero + ", solde=" + solde + "]";
	}
	
	
	
	
	
}