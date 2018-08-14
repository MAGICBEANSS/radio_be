package com.example.repository;

import java.sql.SQLDataException;
import java.sql.Timestamp;
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

import com.example.entity.ForgotPassword;
import com.example.entity.LoginResponse;
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

	public ResponseEntity<userDetails> saveUserDetails(userDetails userDetails) throws SQLDataException {
		
		Session session = this.getSessionFactory().getCurrentSession();
		System.out.println(userDetails);
	//	String token = UUID.randomUUID().toString();
	//	userDetails.setToken(token);
		Criteria criteria = session.createCriteria(userDetails.class);
		criteria.add(Restrictions.like("email", userDetails.getEmail(), MatchMode.EXACT));
		List<userDetails> users= (List<userDetails>) criteria.list();
		if(users.size() == 1) {
			return new ResponseEntity<userDetails>(new userDetails(),HttpStatus.CONFLICT);
		}
		else {
			
		session.persist(userDetails);
//		if(userDetails.getUsertype().equals("admin"))
//		{
//		admin_details adm = new admin_details();
//	//	adm.setFieldsfromuserdetails(userDetails);
//	//	adm.setUid("sdd");
//		System.out.println(adm);
//	//	adm = (admin_details) userDetails; 
//		adm.setUserId(userDetails.getUid());
//		session.saveOrUpdate(adm);
//		System.out.println(adm);
//		}
			
			System.out.println(userDetails);
			ResponseEntity<userDetails> rt =  new ResponseEntity<userDetails>(userDetails,HttpStatus.OK);
		return rt;
		}
	}

	public ResponseEntity<LoginResponse> checkLogin(userDetails userDetails) throws SQLDataException {
		Session session = this.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(userDetails.class);
		criteria.add(Restrictions.like("email", userDetails.getEmail(), MatchMode.EXACT));
		List<userDetails> users= (List<userDetails>) criteria.list();
		if(users.size() == 1) {
			if(users.get(0).getPassword().equals(userDetails.getPassword())) {
				if(!users.get(0).isActive())
				{
					return new ResponseEntity<LoginResponse>(new LoginResponse(),HttpStatus.LOCKED);
				}
				else
				{
				System.out.println("aaaaaaaaaaa "+users.get(0));
				LoginResponse lgn = new LoginResponse();
				String timestring =users.get(0).getUid()+users.get(0).getEmail()+"concat"+new Timestamp(System.currentTimeMillis()).toString();
				  UUID gfg = UUID.nameUUIDFromBytes(timestring.getBytes());
				//  gfg = UUID.
				lgn.setLoginkey(gfg.toString());
				lgn.setUid(users.get(0).getUid());
				lgn.setUsertype(users.get(0).getUsertype());
				  return new ResponseEntity<LoginResponse>(lgn,HttpStatus.OK);
			}}
			else
			{
				
				return new ResponseEntity<LoginResponse>(new LoginResponse(),HttpStatus.NOT_FOUND);
				
			}
		}
		else 
			return new ResponseEntity<LoginResponse>(new LoginResponse(),HttpStatus.FORBIDDEN);
	}

	public ResponseEntity<Boolean> forgotpassword(ForgotPassword requestobj) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(userDetails.class);
		criteria.add(Restrictions.like("email", requestobj.getEmail(), MatchMode.EXACT));
		List<userDetails> users = (List<userDetails>) criteria.list();
		if(users.size() == 1) {
			
			 users.get(0).setActive(false);
			 users.get(0).setFirstName("INACTIVATED");;
			 session.persist(users.get(0));
			 return new ResponseEntity<Boolean>(true,HttpStatus.OK);
			}
		else
		{
			return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
		}
			
		
		
	}

}
