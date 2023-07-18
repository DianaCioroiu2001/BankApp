package com.fdm.bankApp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.fdm.bankApp.dao.entities.BankAccountEntity;
import com.fdm.bankApp.dao.entities.TransactionsEntity;
import com.fdm.bankApp.dao.entities.UserAccountEntity;

public class TransactionsDaoImpl implements TransactionsDao{

	public TransactionsEntity save(TransactionsEntity transactionsEntity) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		int id = (int) session.save(transactionsEntity);
		tx.commit();
		TransactionsEntity savedtransactionsEntity = session.get(TransactionsEntity.class, id);
		session.close();
		sessionFactory.close();
		return transactionsEntity;
	}

	public TransactionsEntity update(TransactionsEntity transactionsEntity, Session session) {
		 session.update(transactionsEntity);
	        return transactionsEntity;
	}

	public TransactionsEntity delete(TransactionsEntity transactionsEntity, Session session) {
		 session.delete(transactionsEntity);
	        return transactionsEntity;
	}
	
	public TransactionsEntity findById(int id, Session session) {
		return session.get(TransactionsEntity.class, id);
	}

}
