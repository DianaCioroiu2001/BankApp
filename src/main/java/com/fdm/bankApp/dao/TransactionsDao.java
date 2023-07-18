package com.fdm.bankApp.dao;

import org.hibernate.Session;

import com.fdm.bankApp.dao.entities.TransactionsEntity;
import com.fdm.bankApp.dao.entities.UserAccountEntity;

public interface TransactionsDao {
     TransactionsEntity save(TransactionsEntity transactionsEntity) ;
	TransactionsEntity update(TransactionsEntity transactionsEntity, Session session);
	TransactionsEntity delete(TransactionsEntity transactionsEntity, Session session);
	TransactionsEntity findById(int id, Session session);
}

