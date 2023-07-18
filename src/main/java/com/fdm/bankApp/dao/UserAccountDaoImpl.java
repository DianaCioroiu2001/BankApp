package com.fdm.bankApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.fdm.bankApp.dao.entities.BankAccountEntity;
import com.fdm.bankApp.dao.entities.UserAccountEntity;


public class UserAccountDaoImpl implements UserAccountDao {

	@Override
	public UserAccountEntity save(UserAccountEntity userAccountEntity, Session session) {
		session.save(userAccountEntity);
        session.refresh(userAccountEntity);
        return userAccountEntity;   
	}

	@Override
	public UserAccountEntity findById(int id, Session session) {
		return session.get(UserAccountEntity.class, id);
	}

	@Override
	public UserAccountEntity update(UserAccountEntity userAccountEntity, Session session) {
		 session.update(userAccountEntity);
	        return userAccountEntity;
	}

	@Override
	public UserAccountEntity delete(UserAccountEntity userAccountEntity, Session session) {
		 session.delete(userAccountEntity);
	        return userAccountEntity;
	}


	@Override
	public UserAccountEntity findByEmail(String email, Session session) {
		Query query = session.createQuery(" from UserAccountEntity where email= :email");
        query.setParameter("email", email);
        UserAccountEntity userAccountEntity = (UserAccountEntity) query.uniqueResult();
		return userAccountEntity;
	}

	@Override
	public UserAccountEntity findByOtp(String otp, Session session) {
		Query query = session.createQuery("from UserAccountEntity where otp= :otp");
        query.setParameter("otp", otp);
        UserAccountEntity userAccountEntity = (UserAccountEntity) query.uniqueResult();
		return userAccountEntity;
	}
	
	public UserAccountEntity existName(String nume, Session session) {
		Query query = session.createQuery("from UserAccountEntity where nume= :nume");
        query.setParameter("nume", nume);
        UserAccountEntity userAccountEntity = (UserAccountEntity) query.uniqueResult();
		return userAccountEntity;
	}
	public UserAccountEntity existCnp(String cnp, Session session) {
		Query query = session.createQuery("from UserAccountEntity where cnp= :cnp");
        query.setParameter("cnp", cnp);
        UserAccountEntity userAccountEntity = (UserAccountEntity) query.uniqueResult();
		return userAccountEntity;
	}

	@Override
	public List<BankAccountEntity> findAllRequest(int id, Session session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserAccountEntity findByCnp(String cnp, Session session) {
		Query query = session.createQuery("from UserAccountEntity where cnp= :cnp");
        query.setParameter("cnp", cnp);
        UserAccountEntity userAccountEntity = (UserAccountEntity) query.uniqueResult();
		return userAccountEntity;
	}

	@Override
	public UserAccountEntity findByStrada(String strada, Session session) {
		Query query = session.createQuery("from UserAccountEntity where strada= :strada");
        query.setParameter("strada", strada);
        UserAccountEntity userAccountEntity = (UserAccountEntity) query.uniqueResult();
		return userAccountEntity;
	}

	@Override
	public UserAccountEntity findByOras(String oras, Session session) {
		Query query = session.createQuery("from UserAccountEntity where oras= :oras");
        query.setParameter("oras", oras);
        UserAccountEntity userAccountEntity = (UserAccountEntity) query.uniqueResult();
		return userAccountEntity;
	}



	
}
