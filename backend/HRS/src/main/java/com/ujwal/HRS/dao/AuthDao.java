package com.ujwal.HRS.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.ujwal.HRS.entity.User;

@Repository
@Transactional
@Scope
public class AuthDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public User getAuthentication(String userName, String password){
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	        CriteriaQuery<User> cq = cb.createQuery(User.class);
	 
	        Root<User> user = cq.from(User.class);
	        Predicate authorNamePredicate = cb.like(user.get("emailId"), userName);
	        Predicate titlePredicate = cb.like(user.get("password"), password);
	        cq.where(authorNamePredicate, titlePredicate);
	 
	        TypedQuery<User> query = entityManager.createQuery(cq);
	        return (User) query.getSingleResult();
	}
		
}
