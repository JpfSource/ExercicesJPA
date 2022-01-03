package main.banque;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="OPERATION")
@Inheritance(strategy = InheritanceType.JOINED)
public class EOperation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_OPERATION", nullable=true)
	private Date date;
	
	@Column(name = "MONTANT", nullable = true, unique = false)
	private Double montant;
	
	@Column(name = "MOTIF", nullable = true, unique = false)
	private String motif;
	
	
	@ManyToOne
	@JoinColumn(name = "ID_COMPTE")
	private ECompte operationCompte;
	
	
	public EOperation() {
		super();
	}

	public EOperation(Date date, Double montant, String motif, ECompte operationCompte) {
		super();
		this.date = date;
		this.montant = montant;
		this.motif = motif;
		this.operationCompte = operationCompte;
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}

	/**
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

	/**
	 * @return the montant
	 */
	public Double getMontant() {
		return montant;
	}

	/**
	 * @param montant the montant to set
	 */
	public void setMontant(Double montant) {
		this.montant = montant;
	}

	/**
	 * @return the operationCompte
	 */
	public ECompte getOperationCompte() {
		return operationCompte;
	}

	/**
	 * @param operationCompte the operationCompte to set
	 */
	public void setOperationCompte(ECompte operationCompte) {
		this.operationCompte = operationCompte;
	}
	
	@Override
	public String toString() {
		return "EOperation [id=" + id + ", date=" + date + ", montant=" + montant + ", motif=" + motif
				+ ", operationCompte=" + operationCompte + "]";
	}
	
	
	
}