package com.fdm.bankApp.dao;

import java.util.List;

import org.hibernate.Session;

import com.fdm.bankApp.dao.entities.UserAccountEntity;
import com.fdm.bankApp.dao.entities.BankAccountEntity;

public interface UserAccountDao {
	
	UserAccountEntity save(UserAccountEntity userAccountEntity, Session session);
	UserAccountEntity findById(int id, Session session);
	UserAccountEntity update(UserAccountEntity userAccountEntity, Session session);
	UserAccountEntity delete(UserAccountEntity userAccountEntity, Session session);
	List<BankAccountEntity> findAllRequest(int id, Session session);
	UserAccountEntity findByEmail(String email, Session session);
	UserAccountEntity findByOtp(String otp, Session session);
	UserAccountEntity findByCnp(String cnp, Session session);
	UserAccountEntity findByStrada(String strada, Session session);
	UserAccountEntity findByOras(String oras, Session session);
	UserAccountEntity existName(String name, Session session);
	UserAccountEntity existCnp(String cnp, Session session);


	
}
