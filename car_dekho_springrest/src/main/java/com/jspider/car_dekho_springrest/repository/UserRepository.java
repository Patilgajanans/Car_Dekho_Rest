package com.jspider.car_dekho_springrest.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.jspider.car_dekho_springrest.pojo.UserPOJO;

@Repository
public class UserRepository {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
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

	public UserPOJO createAccount(UserPOJO user) {
		openConnection();
		transaction.begin();
		
		manager.persist(user);
		
		transaction.commit();
		closeConnection();
		return user;
	}

	public UserPOJO login(UserPOJO user) {
		openConnection();
		transaction.begin();
		
		UserPOJO pojo = manager.find(UserPOJO.class, (user.getUsername()));
		
		if (pojo != null) {
			if ((pojo.getPassword()).equals(user.getPassword())) {
				transaction.commit();
				closeConnection();
				return pojo;
			}
		}
		transaction.commit();
		closeConnection();
		return null;
	}

}
