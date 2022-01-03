package main.banque;

import java.util.Date;

import javax.persistence.*;
@Entity
@Table(name="VIREMENT")
public class EVirement extends EOperation {
	
	@Column(name = "BENEFICIAIRE", length = 100, nullable = true, unique = false)
	private String beneficiaire;

	public EVirement() {
		super();
	}

	
	
	
	public EVirement(Date date, Double montant, String motif, ECompte operationCompte, String beneficiaire) {
		super(date, montant, motif, operationCompte);
		this.beneficiaire = beneficiaire;
	}

	/**
	 * @return the beneficiaire
	 */
	public String getBeneficiaire() {
		return beneficiaire;
	}
	
	/**
	 * @param beneficiaire the beneficiaire to set
	 */
	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	
}
