package com.jspider.car_dekho_springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.car_dekho_springrest.pojo.CarPOJO;
import com.jspider.car_dekho_springrest.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository repository;

	public CarPOJO addStudent(CarPOJO pojo) {
		CarPOJO car= repository.addStudent(pojo);
		return car;
	}

	public List<CarPOJO> displayAll() {
		List<CarPOJO> cars = repository.displayAll();
		
		return cars;
	}

	public CarPOJO deleteData(int id) {
		CarPOJO car = repository.deleteData(id);
		return car;
	}

	public CarPOJO updateData(CarPOJO car) {
		CarPOJO pojo = repository.updateData(car);
		return pojo;
	}

	public CarPOJO searchSingle(int id) {
		CarPOJO car = repository.searchSingle(id); 
		return car;
	}
}
