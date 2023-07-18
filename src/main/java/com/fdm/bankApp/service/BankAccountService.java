package com.fdm.bankApp.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.fdm.bankApp.dao.UserAccountDao;
import com.fdm.bankApp.dao.UserAccountDaoImpl;
import com.fdm.bankApp.dao.BankAccountDao;
import com.fdm.bankApp.dao.BankAccountDaoImpl;
import com.fdm.bankApp.dao.entities.UserAccountEntity;
import com.fdm.bankApp.dao.entities.BankAccountEntity;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class BankAccountService {
	private static BankAccountService instance;
	private BankAccountDao bankAccountDao;
	

	private BankAccountService() {
		this.bankAccountDao =  new BankAccountDaoImpl();
	}

	public static BankAccountService getInstance() {
		if(instance == null) {
			instance = new BankAccountService();
		}
		return instance;
	}
	
	public BankAccountEntity getBankAccountById (int id) {
		Session session = SessionUtils.createSession();
		BankAccountEntity bankAccountEntity;
		try {
			bankAccountEntity = bankAccountDao.findByUserId(id, session);
		} finally {
			session.close();
		}
		return bankAccountEntity;
		
	}


	public BankAccountEntity save(BankAccountEntity bankAccountEntity) {
	
	return bankAccountDao.save(bankAccountEntity);
	
	}
	public BankAccountEntity update(BankAccountEntity bankAccountEntity, String otp) {
		
		return bankAccountDao.update(bankAccountEntity, otp);
		
		}
	public BankAccountEntity update(BankAccountEntity bankAccountEntity) {
		Session session = SessionUtils.createSession();
		Transaction transaction = session.beginTransaction();
		BankAccountEntity bae;
		try {
			bae = bankAccountDao.update(bankAccountEntity, session);
			transaction.commit();
		} finally {
			session.close();
		}		
		return bae;
	
	}
	public BankAccountEntity getBankAccount(int id) {
		return bankAccountDao.findById(id);
	}
	 
	
public String getIban() {
	String alfabet = "abcdefghijklmnopqrstuvwxyz";
	Random random = new Random();
	Set<String> generatedStrings = new HashSet<>();
	String randomString = "";
	while (generatedStrings.size() < Math.pow(alfabet.length(), 4)) {
		randomString = "";
		for (int i = 0; i < 4; i++) {
			int index = random.nextInt(alfabet.length());
		    char randomChar = alfabet.charAt(index);
		    randomString += randomChar;
		}
		if (!generatedStrings.contains(randomString)) {
		    generatedStrings.add(randomString);
		    break;
		}
	}
		int randomNumber = random.nextInt(90) + 10;
		long randomNumber2 = (long) (random.nextDouble() * 9000000000000000L) + 1000000000000000L;
		String iban = "RO"+ randomNumber + randomString + randomNumber2;
		return iban;
	}
public BankAccountEntity getUserByIbanBank (String iban) {
	Session session = SessionUtils.createSession();
	BankAccountEntity bankAccountEntity;
	try {
		bankAccountEntity = bankAccountDao.findByIban(iban, session);
	} finally {
		session.close();
	}
	return bankAccountEntity;
	
}
public BankAccountEntity delete(BankAccountEntity bankAccountEntity) {
	Session session = SessionUtils.createSession();
	Transaction transaction = session.beginTransaction();
	BankAccountEntity uae;
	try {
		uae =bankAccountDao.deleteBank(bankAccountEntity, session);
		transaction.commit();
	} finally {
		session.close();
	}		
	return uae;

}
}

	
	
	

