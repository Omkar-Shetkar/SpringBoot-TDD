package io.spring.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import io.spring.demo.controller.CarController;
import io.spring.demo.domain.Car;
import io.spring.demo.service.CarService;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CarService carService;

	@Test
	public void getCar_ShouldReturnCar() throws Exception {
		given(carService.getCarDetails(anyString())).willReturn(new Car("prius", "hybrid"));
		mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius")) //
				.andExpect(status().isOk()) //
				.andExpect(jsonPath("name").value("prius")) //
				.andExpect(jsonPath("type").value("hybrid")); //
	}

}
