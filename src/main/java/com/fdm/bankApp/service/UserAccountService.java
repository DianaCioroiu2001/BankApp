package com.fdm.bankApp.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fdm.bankApp.dao.UserAccountDao;
import com.fdm.bankApp.dao.UserAccountDaoImpl;
import com.fdm.bankApp.dao.entities.UserAccountEntity;
import com.fdm.bankApp.dao.entities.BankAccountEntity;

public class UserAccountService {
	
	private static UserAccountService instance;
	private UserAccountDao userAccountDao;
	
	private OTPService otpService;
	private UserAccountService userAccountService;

	
	
	
	private UserAccountService() {
		this.userAccountDao =  new UserAccountDaoImpl();
		this.otpService = OTPService.getInstance();
	}

	public static UserAccountService getInstance() {
		if(instance == null) {
			instance = new UserAccountService();
		}
		return instance;
	}

	public UserAccountEntity save(UserAccountEntity userAccountEntity) {
		Session session = SessionUtils.createSession();
		Transaction transaction = session.beginTransaction();
		UserAccountEntity uae;
		try {
			uae = userAccountDao.save(userAccountEntity, session);
			transaction.commit();
		} finally {
			session.close();
		}		
		return uae;
	
	}
	
	public UserAccountEntity existName(String name) {
		Session session = SessionUtils.createSession();
		Transaction transaction = session.beginTransaction();
		UserAccountEntity uae;
		try {
			uae = userAccountDao.existName(name, session);
			transaction.commit();
		} finally {
			session.close();
		}		
		return uae;
	
	}
	public UserAccountEntity existCnp(String cnp) {
		Session session = SessionUtils.createSession();
		Transaction transaction = session.beginTransaction();
		UserAccountEntity uae;
		try {
			uae = userAccountDao.existCnp(cnp, session);
			transaction.commit();
		} finally {
			session.close();
		}		
		return uae;
	
	}
	
	
	public UserAccountEntity update(UserAccountEntity userAccountEntity) {
		Session session = SessionUtils.createSession();
		Transaction transaction = session.beginTransaction();
		UserAccountEntity uae;
		try {
			uae = userAccountDao.update(userAccountEntity, session);
			transaction.commit();
		} finally {
			session.close();
		}		
		return uae;
	
	}
	
	public UserAccountEntity delete(UserAccountEntity userAccountEntity) {
		Session session = SessionUtils.createSession();
		Transaction transaction = session.beginTransaction();
		UserAccountEntity uae;
		try {
			uae = userAccountDao.delete(userAccountEntity, session);
			transaction.commit();
		} finally {
			session.close();
		}		
		return uae;
	
	}
	
	public String generateOTP(String email) {
		
		Session session = SessionUtils.createSession();
		Transaction transaction = session.beginTransaction();
		String OTP;
		try {
			OTP = otpService.generateOTP();
			UserAccountEntity uae = userAccountDao.findByEmail(email, session);
			uae.setOTP(OTP);
			userAccountDao.update(uae, session);
			transaction.commit();
		} finally {
			session.close();
		}
		return OTP;
	}

public UserAccountEntity getUserAccount (String email) {
	Session session = SessionUtils.createSession();
	UserAccountEntity userAccountEntity;
	try {
		userAccountEntity = userAccountDao.findByEmail(email, session);
	} finally {
		session.close();
	}
	return userAccountEntity;
	
}
public UserAccountEntity getUser (String otp) {
	Session session = SessionUtils.createSession();
	UserAccountEntity userAccountEntity;
	try {
		userAccountEntity = userAccountDao.findByOtp(otp, session);
	} finally {
		session.close();
	}
	return userAccountEntity;
	
}

public UserAccountEntity getUserById (int id) {
	Session session = SessionUtils.createSession();
	UserAccountEntity userAccountEntity;
	try {
		userAccountEntity = userAccountDao.findById(id, session);
	} finally {
		session.close();
	}
	return userAccountEntity;
	
}
public UserAccountEntity getUserByCnp (String cnp) {
	Session session = SessionUtils.createSession();
	UserAccountEntity userAccountEntity;
	try {
		userAccountEntity = userAccountDao.findByCnp(cnp, session);
	} finally {
		session.close();
	}
	return userAccountEntity;
	
}
public UserAccountEntity getUserByOras (String oras) {
	Session session = SessionUtils.createSession();
	UserAccountEntity userAccountEntity;
	try {
		userAccountEntity = userAccountDao.findByOras(oras, session);
	} finally {
		session.close();
	}
	return userAccountEntity;
	
}
public UserAccountEntity getUserByStrada(String strada) {
	Session session = SessionUtils.createSession();
	UserAccountEntity userAccountEntity;
	try {
		userAccountEntity = userAccountDao.findByCnp(strada, session);
	} finally {
		session.close();
	}
	return userAccountEntity;
	
}
public boolean verifyCredentials(String email, String password) {
	UserAccountEntity userAccountEntity = UserAccountService.getInstance().getUserAccount(email);
	boolean isCorrect = false;
	if (userAccountEntity != null) {			
		if (email.equals(userAccountEntity.getEmail()) && 
			password.equals(userAccountEntity.getParola())
			) {
			isCorrect = true;
		}
	} 
	return isCorrect;
}
public boolean verifyCredentials(String email, String password, String otp) {
	UserAccountEntity userAccountEntity = UserAccountService.getInstance().getUserAccount(email);
	boolean isCorrect = false;
	if (userAccountEntity != null) {			
		if (email.equals(userAccountEntity.getEmail()) && 
			password.equals(userAccountEntity.getParola())
			&& 
			otp.equals(userAccountEntity.getOTP())) {
			isCorrect = true;
		}
	} 
	return isCorrect;
}
public boolean verifyCredentialsId(String otp, int id) {
	UserAccountEntity userAccountEntity = UserAccountService.getInstance().getUser(otp);
	UserAccountEntity userId  =  UserAccountService.getInstance().getUserById(id);
	boolean isCorrect = false;
	if (userAccountEntity != null && userAccountEntity.getOTP().equals(userId.getOTP())) {			
		if (otp.equals(userAccountEntity.getOTP())) {
			isCorrect = true;
		}
	} 
	return isCorrect;
}




public Boolean verifyEmail(String email) throws IOException { 
	
	if(email.length()<10)
		return false;
	if( email.substring(email.length() - 10).equals("@gmail.com") || email.substring(email.length() - 10).equals("@yahoo.com")) {
		System.out.println(email.length() - 10);
		return true;
	}
return false;
}

public Boolean verifyNume(String nume) {
	return nume != null && nume.matches("[a-zA-Z]+");
}

public Boolean verifyNumeTitular(String nume) {
	if(UserAccountService.getInstance().existName(nume) == null)
		return true;
	else
	return false;
}
public Boolean verifyExistCnp(String nume) {
	if(UserAccountService.getInstance().existCnp(nume) == null)
		return true;
	else
	return false;
}
public Boolean verifyPhoneNumber(String telefon) {
	return telefon != null && telefon.matches("[0-9]+") && telefon.length() == 10 &&  (telefon.substring(0,3).equals("072")||telefon.substring(0,3).equals("073")||telefon.substring(0,3).equals("074")||telefon.substring(0,3).equals("075")||telefon.substring(0,3).equals("076")||telefon.substring(0,3).equals("077")||telefon.substring(0,3).equals("078")||telefon.substring(0,3).equals("079")); 
}
public Boolean verifySuma(String suma) {
	try {
        Double.parseDouble(suma);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}
public Boolean verifyStartData(LocalDate startData) {
	LocalDate now = LocalDate.now();
	return startData.isBefore(now);
}
public Boolean verifyEndData(LocalDate endData) {
	LocalDate now = LocalDate.now();
	return endData.isAfter(now);
}
public Boolean verifySeries(String seria) {
	if(seria.equalsIgnoreCase("XR") || seria.equalsIgnoreCase("TR") || seria.equalsIgnoreCase("AB") || seria.equalsIgnoreCase("GD"))
		return true;
	return false;
}
public Boolean verifyNumberSeries(String number) {
	if(number.length() == 6 &&  number != null && number.matches("[0-9]+"))
		return true;
	return false;
}
public Boolean verifyDataCreareCont(int an, int luna, int zi) {
	 LocalDate dataCreareCont = LocalDate.of(an, luna, zi);
	 LocalDate dataNow = LocalDate.now();
	 if(!dataCreareCont.isAfter(dataNow)) {
		 return false;
	 }
	 return true;
}

public Boolean verifyPassword(String password) {
	Boolean message = false;
	if(password.contains("0") || password.contains("1") || password.contains("2") || password.contains("3") || password.contains("4") || password.contains("5") || password.contains("6") || password.contains("7") || password.contains("8") || password.contains("9")) {
	message = true;
	}
	for(int i=0; i < password.length(); i++) {
		if(Character.isUpperCase(password.charAt(i)))
			message = true;
	}
	return message;
}

public Boolean verifyCnp(String cnp) {
	if(cnp.length() == 13)
		return true;
return false;
}
		  
	
	}