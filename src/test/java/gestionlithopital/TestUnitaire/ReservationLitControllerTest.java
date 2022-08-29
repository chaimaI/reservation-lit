package gestionlithopital.TestUnitaire;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import gestionlithopital.entities.ReservationLit;
import gestionlithopital.service.ReservationLitService;

@AutoConfigureMockMvc
@SpringBootTest
public class ReservationLitControllerTest {

	@Autowired
	public MockMvc mockMvc;

	@MockBean
	ReservationLitService reservationLitService;

	ReservationLit reservationLit;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);

		reservationLit = new ReservationLit();
		reservationLit.setCodeReseration(1L);
		reservationLit.setCodeHopital(1L);
		reservationLit.setCodeSpecialisation(1L);
		reservationLit.setNomPatient("Allan");
		reservationLit.setPrenomPatient("Celine");

	}

	@Test
	public void testReservationLit() throws Exception {

		when(reservationLitService.reserverLit(1L, 1L, "Allan", "Celine")).thenReturn(reservationLit);

		mockMvc.perform(put("/hopitals/reservationLit/1/1/Allan/Celine")).andExpect(status().isOk())
				.andExpect(jsonPath("$.codeReseration", is(1))).andExpect(jsonPath("$.codeHopital", is(1)))
				.andExpect(jsonPath("$.codeSpecialisation", is(1))).andExpect(jsonPath("$.nomPatient", is("Allan")))
				.andExpect(jsonPath("$.prenomPatient", is("Celine")));

	}

}
