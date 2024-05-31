package com.ty.dao.implemntation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.ItemDao;
import com.ty.dto.Item;
@Component
public class ItemDaoImplentation implements ItemDao {

	 @Autowired
		private EntityManagerFactory entityManagerFactory;

	@Override
	public Item createItem(Item item) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.persist(item);
		
		return item;
	}

	@Override
	public Item findItem(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager.find(Item.class, id);
	}

	@Override
	public Item upadteItem(Item item) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(item);
		entityTransaction.commit();
		return item;
	}

	@Override
	public boolean deleteItem(Item item) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		if (item != null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(item);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

}
