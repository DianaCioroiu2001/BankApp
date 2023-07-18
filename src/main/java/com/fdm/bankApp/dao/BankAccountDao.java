package com.fdm.bankApp.dao;

import org.hibernate.Session;

import com.fdm.bankApp.dao.entities.BankAccountEntity;
import com.fdm.bankApp.dao.entities.UserAccountEntity;

public interface BankAccountDao {
	BankAccountEntity save(BankAccountEntity bankAccountEntity);
	BankAccountEntity update(BankAccountEntity bankAccountEntity, String otp);
	public BankAccountEntity update(BankAccountEntity bankAccountEntity, Session session) ;
	BankAccountEntity findById(int id);
	BankAccountEntity updateBank(BankAccountEntity bankAccountEntity, Session session);
	BankAccountEntity deleteBank(BankAccountEntity bankAccountEntity, Session session);
	 BankAccountEntity findByUserId(int id, Session session);
	 BankAccountEntity findByIban(String iban, Session session);

}
