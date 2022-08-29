package gestionlithopital.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import gestionlithopital.entities.ReservationLit;
import gestionlithopital.service.ReservationLitService;

@RequestMapping("/hopitals")
@RestController
public class GestionLitController {

	@Autowired
	ReservationLitService reservationLitService;

	@PutMapping("/reservationLit/{hopital}/{specialisation}/{nomPatient}/{prenomPatient}")

	public ReservationLit reserverLit(

			@PathVariable(name = "hopital") Long codeHopital,
			@PathVariable(name = "specialisation") Long codeSpecialisation,
			@PathVariable(name = "nomPatient") String nomPatient,
			@PathVariable(name = "prenomPatient") String prenomPatient) throws Exception {

		return reservationLitService.reserverLit(codeHopital, codeSpecialisation, nomPatient, prenomPatient);

	}

}
