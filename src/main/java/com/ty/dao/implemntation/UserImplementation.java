package com.ty.dao.implemntation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ty.dao.UserDao;
import com.ty.dto.User;

@Component
@Scope(value = "prototype")
@Transactional
public class UserImplementation implements UserDao {
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public User createUser(User user) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityManager.clear();
		entityTransaction.begin();
		entityManager.persist(user);
		
		entityTransaction.commit();
		return user;
	}

	@Override
	public User findUser(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager.find(User.class, id);
	}

	@Override
	public User upadteUser(User user) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
		return user;
	}

	@Override
	public boolean deleteUser(User user) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(user);
		entityTransaction.commit();
		return true;
	}

}
