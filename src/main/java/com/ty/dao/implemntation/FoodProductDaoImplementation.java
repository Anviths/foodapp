package com.ty.dao.implemntation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.FoodProductDao;
import com.ty.dto.FoodProduct;
@Component
public class FoodProductDaoImplementation implements FoodProductDao{
	 @Autowired
		private EntityManagerFactory entityManagerFactory;
	
	@Override
	public FoodProduct createFoodProduct(FoodProduct foodProduct) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(foodProduct);
		entityTransaction.commit();
		return foodProduct;
	}

	@Override
	public FoodProduct findFoodProduct(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		// TODO Auto-generated method stub
		return entityManager.find(FoodProduct.class, id);
	}

	@Override
	public FoodProduct upadteFoodProduct(FoodProduct foodProduct) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.clear();
		entityManager.merge(foodProduct);
		entityTransaction.commit();
		return foodProduct;
	}

	@Override
	public boolean deleteFoodProduct(FoodProduct foodProduct) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		if(foodProduct!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(foodProduct);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

}
