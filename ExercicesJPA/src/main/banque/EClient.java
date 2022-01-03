package main.banque;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="CLIENT")
public class EClient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private int id;

	@Column(name = "NOM", length = 50, nullable = true, unique = false)
	private String nom;
	
	@Column(name = "PRENOM", length = 50, nullable = true, unique = false)
	private String prenom;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_NAISSANCE", nullable=true)
	private Date dateNaissance;

	@Embedded
	private Adresse adresse;
	
	@ManyToOne
	@JoinColumn(name="ID_BANQUE")
	private EBanque clientBanque;
	
	@ManyToMany
	@JoinTable( name = "CLIENT_COMPTE"
	          , joinColumns = @JoinColumn(name="ID_CLIENT", referencedColumnName = "ID")
	          , inverseJoinColumns = @JoinColumn(name="ID_COMPTE", referencedColumnName = "ID")
	          )
	private Set<ECompte> clientComptes;

	
	public EClient() {
		super();
		this.clientComptes = new HashSet<ECompte>();
	}

	public EClient(String nom, String prenom, Date dateNaissance, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.clientComptes = new HashSet<ECompte>();
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

	/**
	 * @return the dateNaissance
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
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
	 * @return the clientBanque
	 */
	public EBanque getClientBanque() {
		return clientBanque;
	}

	/**
	 * @param clientBanque the banque to set
	 */
	public void setClientBanque(EBanque clientBanque) {
		this.clientBanque = clientBanque;
	}




	/**
	 * @return the clientComptes
	 */
	public Set<ECompte> getClientComptes() {
		return clientComptes;
	}




	/**
	 * @param clientComptes the clientComptes to set
	 */
	public void setClientComptes(Set<ECompte> clientComptes) {
		this.clientComptes = clientComptes;
	}
	
	
	@Override
	public String toString() {
		return "EClient [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", adresse=" + adresse + "]";
	}
	
}