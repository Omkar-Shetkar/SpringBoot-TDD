package io.spring.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.spring.demo.domain.Car;
import io.spring.demo.service.CarService;

@RestController
public class CarController {

	private CarService carService;

	public CarController(CarService carService) {
		this.carService = carService;
	}

	@GetMapping("/cars/{name}")
	private Car getCar(@PathVariable String name) {
		return carService.getCarDetails(name);
	}
}
