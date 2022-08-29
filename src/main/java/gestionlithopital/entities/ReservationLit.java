package gestionlithopital.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReservationLit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeReseration;
	private Long codeHopital;
	private Long codeSpecialisation;
	private Date dateReservation;
	private String nomPatient;
	private String prenomPatient;

	public ReservationLit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReservationLit(Long codeReseration, Long codeHopital, Long codeSpecialisation, Date dateReservation,
			String nomPatient, String prenomPatient) {
		super();
		this.codeReseration = codeReseration;
		this.codeHopital = codeHopital;
		this.codeSpecialisation = codeSpecialisation;
		this.dateReservation = dateReservation;
		this.nomPatient = nomPatient;
		this.prenomPatient = prenomPatient;
	}

	public Long getCodeReseration() {
		return codeReseration;
	}

	public void setCodeReseration(Long codeReseration) {
		this.codeReseration = codeReseration;
	}

	public Long getCodeHopital() {
		return codeHopital;
	}

	public void setCodeHopital(Long codeHopital) {
		this.codeHopital = codeHopital;
	}

	public Long getCodeSpecialisation() {
		return codeSpecialisation;
	}

	public void setCodeSpecialisation(Long codeSpecialisation) {
		this.codeSpecialisation = codeSpecialisation;
	}

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public String getNomPatient() {
		return nomPatient;
	}

	public void setNomPatient(String nomPatient) {
		this.nomPatient = nomPatient;
	}

	public String getPrenomPatient() {
		return prenomPatient;
	}

	public void setPrenomPatient(String prenomPatient) {
		this.prenomPatient = prenomPatient;
	}

}
