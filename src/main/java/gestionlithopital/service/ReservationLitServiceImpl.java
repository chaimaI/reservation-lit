package gestionlithopital.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import gestionlithopital.entities.ReservationLit;
import gestionlithopital.repositories.ReservationLitRepository;

@Service
public class ReservationLitServiceImpl implements ReservationLitService {

	@Autowired
	Environment environment;

	@Autowired
	private ReservationLitRepository reservationLitRepository;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public ReservationLit reserverLit(Long codeHopital, Long codeSpecialisation, String nomPatient,
			String prenomPatient) throws Exception {

		ReservationLit reservation = new ReservationLit();

		Date dateNow = new Date();

		reservation.setCodeHopital(codeHopital);
		reservation.setCodeSpecialisation(codeSpecialisation);
		reservation.setDateReservation(dateNow);
		reservation.setNomPatient(nomPatient);
		reservation.setPrenomPatient(prenomPatient);

		reduireNombreLit(codeHopital, codeSpecialisation);

		return reservationLitRepository.save(reservation);

	}

	private void reduireNombreLit(Long codeHopital, Long codeSpecialisation) throws Exception {

		restTemplate.put(
				environment.getProperty("backend.url") + "urgences/nombreLit/" + codeHopital + "/" + codeSpecialisation,
				null);
	}

}
