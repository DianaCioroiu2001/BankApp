package com.fdm.bankApp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.fdm.bankApp.dao.entities.BankAccountEntity;
import com.fdm.bankApp.service.UserAccountService;


public class BankAccountDaoImpl implements BankAccountDao {

	@Override
	public BankAccountEntity save(BankAccountEntity bankAccountEntity) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		int id = (int) session.save(bankAccountEntity);
		tx.commit();
		BankAccountEntity savedVacationRequestEntity = session.get(BankAccountEntity.class, id);
		session.close();
		sessionFactory.close();
		return bankAccountEntity;
	}
	public BankAccountEntity findByUserId(int id, Session session) {
		Query query = session.createQuery(" from UserAccountEntity where user_id= :id");
        query.setParameter("user_id", id);
        BankAccountEntity bankAccountEntity = (BankAccountEntity) query.uniqueResult();
		return bankAccountEntity;
	}
	public BankAccountEntity updateBank(BankAccountEntity bankAccountEntity, Session session) {
		 session.update(bankAccountEntity);
	        return bankAccountEntity;
	}
	public BankAccountEntity findByIban(String iban, Session session) {
		Query query = session.createQuery("from BankAccountEntity where iban= :iban");
        query.setParameter("iban", iban);
        BankAccountEntity bankAccountEntity = (BankAccountEntity) query.uniqueResult();
		return bankAccountEntity;
	}
	@Override
	public BankAccountEntity deleteBank(BankAccountEntity bankAccountEntity, Session session) {
		 session.delete(bankAccountEntity);
	        return bankAccountEntity;
	}
	@Override
	public BankAccountEntity update(BankAccountEntity bankAccountEntity, String otp) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
	    session.update(bankAccountEntity);
	    int id = UserAccountService.getInstance().getUser(otp).getId();
		tx.commit();
		BankAccountEntity savedBankAccountEntity = session.get(BankAccountEntity.class, id);
		session.close();
		sessionFactory.close();
		return bankAccountEntity;
	}
	public BankAccountEntity update(BankAccountEntity bankAccountEntity, Session session) {
		 session.update(bankAccountEntity);
	        return bankAccountEntity;
	}

	@Override
	public BankAccountEntity findById(int id) {
		Configuration configuration = new Configuration().configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        BankAccountEntity vacationRequestEntity = session.get(BankAccountEntity.class, id);
        
        tx.commit();


        session.close();

        sessionFactory.close();
        
        return vacationRequestEntity;
	}

}
