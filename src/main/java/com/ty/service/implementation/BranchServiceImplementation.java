package com.ty.service.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.BranchDao;
import com.ty.dto.Branch;
import com.ty.dto.User;
import com.ty.service.BranchService;
@Component
public class BranchServiceImplementation implements BranchService {
	@Autowired
	private BranchDao branchDao;
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	@Override
	public boolean createBranchService(Branch branch) {
		if(branch!=null) {
			branchDao.createBranch(branch);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateBranchService(Branch branch) {
		if(branch!=null) {
			branchDao.upadteBranch(branch);
			return true;
		}
		return false;
		
	}

	@Override
	public boolean deleteBranchService(Branch branch) {
		if(branch!=null) {
			branchDao.deleteBranch(branch);
			return true;
		}
		return false;
		
	}

	@Override
	public Branch getBranchServiceById(int id) {
		return branchDao.findBranch(id);
	}

	@Override
	public User getBranchMangerServiceByBranchId(int id) {
		
		return branchDao.findBranch(id).getUser();
	}

	@Override
	public Branch getBranchByBranchName(String branchName) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select b from Branch b where name=?1");
		query.setParameter(1, branchName);
		try {
			return (Branch)query.getSingleResult();
		}
		catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Branch> getAllBranches() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select b from Branch b  ");
		return query.getResultList();
	}

}
