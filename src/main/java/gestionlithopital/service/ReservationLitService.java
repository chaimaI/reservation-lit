package gestionlithopital.service;

import gestionlithopital.entities.ReservationLit;

public interface ReservationLitService {

	public ReservationLit reserverLit(Long codeHopital, Long codeSpecialisation, String nomPatient,
			String prenomPatient) throws Exception;
}
