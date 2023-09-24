package com.jspider.car_dekho_springrest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspider.car_dekho_springrest.pojo.CarPOJO;

@Repository
public class CarRepository {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("Car");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
	public CarPOJO addStudent(CarPOJO pojo) {
		openConnection();
		transaction.begin();
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
	}

	public List<CarPOJO> displayAll() {
		openConnection();
		transaction.begin();
		String jpql = "from CarPOJO";
		query = manager.createQuery(jpql);
		List<CarPOJO> cars = query.getResultList();
		transaction.commit();
		closeConnection();
		return cars;
	}

	public CarPOJO deleteData(int id) {
		openConnection();
		transaction.begin();
		
		CarPOJO car = manager.find(CarPOJO.class, id);
		if (car != null) {
			manager.remove(car);
			transaction.commit();
			closeConnection();
			return car;
		}
		
		transaction.commit();
		closeConnection();
		return car;
	}

	public CarPOJO updateData(CarPOJO pojo) {

		openConnection();
		transaction.begin();
		
		CarPOJO car = manager.find(CarPOJO.class, pojo.getId());
		
		if (car != null) {
			car.setModelName(pojo.getModelName());
			car.setBrandName(pojo.getBrandName());
			car.setFuelType(pojo.getFuelType());
			car.setPrice(pojo.getPrice());
			manager.persist(car);
			transaction.commit();
			closeConnection();
			return car;
		}
		
		transaction.commit();
		closeConnection();
		return null;
	}

	public CarPOJO searchSingle(int id) {
		openConnection();
		transaction.begin();
		
		CarPOJO pojo = manager.find(CarPOJO.class, id);
		
		transaction.commit();
		closeConnection();
		return pojo;
	}

}
