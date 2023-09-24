package com.jspider.car_dekho_springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.car_dekho_springrest.pojo.CarPOJO;
import com.jspider.car_dekho_springrest.response.CarResponse;
import com.jspider.car_dekho_springrest.service.CarService;

@RestController
public class CarController {
	
	@Autowired
	private CarService service;
	
	@PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> addStudent(@RequestBody CarPOJO pojo) {
		CarPOJO car = service.addStudent(pojo);
		
		if (car != null) {
			return new ResponseEntity<CarResponse>(new CarResponse("Record Added Successfully !", pojo, null),HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity<CarResponse>(new CarResponse("Record Not Added", null, null),HttpStatus.ACCEPTED);
	}
	
	@GetMapping(path = "/searchAll",produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<CarResponse> displayAll(){
		
		List<CarPOJO> cars = service.displayAll();
		
		if (!cars.isEmpty()) {
			return new ResponseEntity<CarResponse>(new CarResponse("Data Found Successfully !", null, cars),HttpStatus.FOUND);
		}
		return new ResponseEntity<CarResponse>(new CarResponse("Data Not Found", null, null),HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/delete",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> delete(@RequestParam int id){
		
		CarPOJO car = service.deleteData(id);
		if (car != null) {
			return new ResponseEntity<CarResponse>(new CarResponse("Data Deleted Successfully..", car, null),HttpStatus.OK);
		}
		
		return new ResponseEntity<CarResponse>(new CarResponse("Data Not Deleted", null, null),HttpStatus.BAD_REQUEST);
	}
	
	
	@PutMapping(path = "/update",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> updateData(@RequestBody CarPOJO pojo){
		CarPOJO car = service.updateData(pojo);
		
		if (car != null) {
			return new ResponseEntity<CarResponse>(new CarResponse("Data Update Successfully !", pojo, null),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<CarResponse>(new CarResponse("Data Not Update !", null, null),HttpStatus.BAD_REQUEST);
	}
	
	
	@GetMapping(path = "/search",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> searchSingleCar(@RequestParam int id) {
		CarPOJO car = service.searchSingle(id);
		
		if (car != null) {
			return new ResponseEntity<CarResponse>(new CarResponse("Data Found Successfully !", car, null),HttpStatus.FOUND);
		}
		
		return new ResponseEntity<CarResponse>(new CarResponse("Data Not Found", null, null),HttpStatus.BAD_REQUEST);
	}
}
