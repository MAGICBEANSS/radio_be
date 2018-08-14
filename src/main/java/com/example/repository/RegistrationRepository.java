package com.example.repository;

import java.sql.SQLDataException;
import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.userDetails;

@Transactional
@Repository("RegistrationDAO")
public class RegistrationRepository  implements RegistrationDAO{
	
	@Autowired
	SessionFactory sessionFactory; 

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public userDetails saveUserDetails(userDetails userDetails) throws SQLDataException {
		
		Session session = this.getSessionFactory().getCurrentSession();
		System.out.println(userDetails);
		String token = UUID.randomUUID().toString();
		userDetails.setToken(token);
		Criteria criteria = session.createCriteria(userDetails.class);
		criteria.add(Restrictions.like("email", userDetails.getEmail(), MatchMode.EXACT));
		List<userDetails> users= (List<userDetails>) criteria.list();
		if(users.size() == 1) {
			return null;
		}
		else {
			session.persist(userDetails);
			return userDetails;
		}
	}

	public ResponseEntity<String> checkLogin(userDetails userDetails) throws SQLDataException {
		Session session = this.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(userDetails.class);
		criteria.add(Restrictions.like("email", userDetails.getEmail(), MatchMode.EXACT));
		List<userDetails> users= (List<userDetails>) criteria.list();
		if(users.size() == 1) {
			if(users.get(0).getPassword().equals(userDetails.getPassword())) {
				return new ResponseEntity<String>(users.get(0).getIsAdmin(),HttpStatus.OK);
			}
			else
				return new ResponseEntity<String>("Abc",HttpStatus.NOT_FOUND);
		}
		else 
			return new ResponseEntity<String>("Demo",HttpStatus.FORBIDDEN);
	}

}
