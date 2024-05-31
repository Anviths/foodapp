package com.ty.dao.implemntation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.FoodOrderDao;
import com.ty.dto.FoodOrder;
@Component
@Transactional
public class FoodOrderDaoImplementation implements FoodOrderDao {

	 @Autowired
		private EntityManagerFactory entityManagerFactory;

	@Override
	public FoodOrder createFoodOrder(FoodOrder foodOrder) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(foodOrder);
		entityTransaction.commit();
		return foodOrder;
	}

	@Override
	public FoodOrder findFoodOrder(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager.find(FoodOrder.class, id);

	}

	@Override
	public FoodOrder upadteFoodOrder(FoodOrder foodOrder) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityManager.clear();
		entityTransaction.begin();
		entityManager.merge(foodOrder);
		entityTransaction.commit();
		return foodOrder;
	}

	@Override
	public boolean deleteFoodOrder(FoodOrder foodOrder) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		if (foodOrder != null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(foodOrder);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

}
