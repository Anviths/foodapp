package com.ty.dao.implemntation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.MenuDao;
import com.ty.dto.Menu;
@Component
public class MenuDaoImplementation implements MenuDao {

	 @Autowired
		private EntityManagerFactory entityManagerFactory;

	@Override
	public Menu createMenu(Menu menu) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(menu);
		entityTransaction.commit();
		return menu;
	}

	@Override
	public Menu findMenu(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager.find(Menu.class, id);

	}

	@Override
	public Menu upadteMenu(Menu menu) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(menu);
		entityTransaction.commit();
		return menu;
	}

	@Override
	public boolean deleteMenu(Menu menu) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		   
		if (menu != null) {
			entityTransaction.begin();
			entityManager.merge(menu);
			entityManager.remove(menu);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

}
