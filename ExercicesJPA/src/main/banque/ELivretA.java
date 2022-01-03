package main.banque;

import javax.persistence.*;

@Entity
@Table(name="LIVRET_A")
public class ELivretA extends ECompte {
	
	@Column(name = "TAUX", nullable = true, unique = false)
	private Double taux;

	public ELivretA() {
		super();
	}
	
	public ELivretA(String numero, Double solde, Double taux) {
		super(numero, solde);
		this.taux = taux;
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
