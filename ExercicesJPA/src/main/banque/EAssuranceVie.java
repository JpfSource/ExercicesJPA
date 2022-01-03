package main.banque;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="ASSURANCE_VIE")
public class EAssuranceVie extends ECompte {
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_FIN", nullable=true)
	private Date dateFin;	
	
	@Column(name = "TAUX", nullable = true, unique = false)
	private Double taux;

	public EAssuranceVie() {
		super();
	}

	public EAssuranceVie(String numero, Double solde, Date dateFin, Double taux) {
		super(numero, solde);
		this.dateFin = dateFin;
		this.taux = taux;
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
	 * @return the taux
	 */
	public Double getTaux() {
		return taux;
	}

	/**
	 * @param taux the taux to set
	 */
	public void setTaux(Double taux) {
		this.taux = taux;
	}
	
}
