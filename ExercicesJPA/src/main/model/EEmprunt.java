package main.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="EMPRUNT")
public class EEmprunt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_DEBUT",nullable=false)
	private Date dateDebut;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_FIN",nullable=true)
	private Date dateFin;
	
	@Column(name = "DELAI",nullable=true)
	private int delai;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private EClient empruntClients;

	
	@ManyToMany
	@JoinTable(name = "COMPO"
			  ,joinColumns = @JoinColumn(name="ID_EMP",referencedColumnName="ID")
			  ,inverseJoinColumns = @JoinColumn(name="ID_LIV",referencedColumnName="ID")
	  		  )
	private Set<ELivre> empruntLivres;	
	
	public EEmprunt() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the empruntLivres
	 */
	public Set<ELivre> getEmpruntLivres() {
		return empruntLivres;
	}

	/**
	 * @param empruntLivres the empruntLivres to set
	 */
	public void setEmpruntLivres(Set<ELivre> empruntLivres) {
		this.empruntLivres = empruntLivres;
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
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the delai
	 */
	public int getDelai() {
		return delai;
	}

	/**
	 * @param delai the delai to set
	 */
	public void setDelai(int delai) {
		this.delai = delai;
	}

	/**
	 * @return the empruntClients
	 */
	public EClient getEmpruntClients() {
		return empruntClients;
	}

	/**
	 * @param empruntClients the empruntClients to set
	 */
	public void setEmpruntClients(EClient empruntClients) {
		this.empruntClients = empruntClients;
	}

	@Override
	public String toString() {
		return "EEmprunt [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", delai=" + delai +"]";
	}
}
