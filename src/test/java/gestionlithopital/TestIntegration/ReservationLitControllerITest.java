package gestionlithopital.TestIntegration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
public class ReservationLitControllerITest {

	@Autowired
	public MockMvc mockMvc;

	@Test
	public void testReservationLit() throws Exception {
		mockMvc.perform(put("/hopitals/reservationLit/1/1/Steve/Jule")).andExpect(status().isOk());

	}

}
