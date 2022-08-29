package gestionlithopital.TestUnitaire;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

import java.net.URI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import gestionlithopital.entities.ReservationLit;
import gestionlithopital.repositories.ReservationLitRepository;
import gestionlithopital.service.ReservationLitServiceImpl;

@ExtendWith(MockitoExtension.class)

public class ReservationLitServiceImplTest {

	@InjectMocks
	ReservationLitServiceImpl reservationLitServiceImpl;

	@Mock
	ReservationLitRepository reservationLitRepository;

	@Mock
	RestTemplate restTemplate;

	@Mock
	Environment environment;

	ReservationLit reservationLit;

	private MockRestServiceServer mockRestServiceServer;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);

		mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);

		reservationLit = new ReservationLit();

		reservationLit.setCodeHopital(1L);
		reservationLit.setCodeSpecialisation(1L);
		reservationLit.setNomPatient("Achille");
		reservationLit.setPrenomPatient("Dona");

		restTemplate = new RestTemplate();

	}

	@Test
	public void testReserverLit() throws Exception {

		when(environment.getProperty("backend.url")).thenReturn("http://localhost:8084/");

		mockRestServiceServer.expect(ExpectedCount.once(), requestTo(new URI("urgences/nombreLit/1/1")))
				.andExpect(method(HttpMethod.PUT))
				.andRespond(withStatus(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body("Expected"));

		when(reservationLitRepository.save(any())).thenReturn(reservationLit);

		ReservationLit reservationLitResult = reservationLitServiceImpl.reserverLit(1L, 1L, "Achille", "Dona");

		assertEquals(reservationLitResult.getCodeHopital(), 1);
		assertEquals(reservationLitResult.getCodeSpecialisation(), 1);
		assertEquals(reservationLitResult.getNomPatient(), "Achille");
		assertEquals(reservationLitResult.getPrenomPatient(), "Dona");
	}

}
