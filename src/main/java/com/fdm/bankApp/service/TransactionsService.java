package com.fdm.bankApp.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fdm.bankApp.dao.BankAccountDao;
import com.fdm.bankApp.dao.BankAccountDaoImpl;
import com.fdm.bankApp.dao.TransactionsDao;
import com.fdm.bankApp.dao.TransactionsDaoImpl;
import com.fdm.bankApp.dao.entities.TransactionsEntity;
import com.fdm.bankApp.dao.entities.UserAccountEntity;

public class TransactionsService {
	private static TransactionsService instance;
	private TransactionsDao transactionsDao;
	
	private TransactionsService() {
		this.transactionsDao =  new TransactionsDaoImpl();
	}
	public TransactionsEntity save(TransactionsEntity transactionsEntity) {
		
		return transactionsDao.save(transactionsEntity);
		
		}
	public TransactionsEntity delete(TransactionsEntity transactionsEntity) {
		Session session = SessionUtils.createSession();
		Transaction transaction = session.beginTransaction();
		TransactionsEntity t;
		try {
			t = transactionsDao.delete(transactionsEntity, session);
			transaction.commit();
		} finally {
			session.close();
		}		
		return t;
	
	}
	public static TransactionsService getInstance() {
		if(instance == null) {
			instance = new TransactionsService();
		}
		return instance;
	}
	public TransactionsEntity getTransactionsById (int id) {
		Session session = SessionUtils.createSession();
		TransactionsEntity transactionsEntity;
		try {
			transactionsEntity = transactionsDao.findById(id, session);
		} finally {
			session.close();
		}
		return transactionsEntity;
		
	}
}
