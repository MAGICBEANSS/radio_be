package com.example.repository;

import java.sql.SQLDataException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.admin_details;
@Transactional
@Repository("AdminDAO")
public class AdminRepoImpl implements AdminRepo {

@Autowired
SessionFactory sessionFactory; 

public SessionFactory getSessionFactory() {
	return sessionFactory;
}

public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}

	
	public ResponseEntity<String> saveadminDetails(admin_details admin_details) throws SQLDataException {
		Session session = this.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(admin_details.class);
		criteria.add(Restrictions.like("adminid", admin_details.getAdminid(), MatchMode.EXACT));
		List<admin_details> admlist = (List<admin_details>)criteria.list();
		if(admlist.size() != 1)
		{
			return new ResponseEntity<String>("",HttpStatus.BAD_REQUEST);
		}
		else
		{
			admlist.get(0).setPlaylist(admin_details.getPlaylist());
			session.update(admlist.get(0));
			return new ResponseEntity<String>(admin_details.getPlaylist(),HttpStatus.OK);
		}
	}

}
