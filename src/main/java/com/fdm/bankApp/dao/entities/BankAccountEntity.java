package com.fdm.bankApp.dao.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bankAccount")
public class BankAccountEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "iban")
	private String iban;
	
	@Column(name = "moneda")
	private String moneda;
	
	@Column(name = "suma")
	private double suma;

	
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private UserAccountEntity userAccountEntity;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "bankAccountEntity")
	private List<TransactionsEntity> transactionsEntity;
	
	public BankAccountEntity(int id, String iban, String moneda, double suma, UserAccountEntity userAccountEntity) {
		super();
		this.id = id;
		this.iban = iban;
		this.moneda = moneda;
		this.suma = suma;
		this.userAccountEntity = userAccountEntity;
	}
	
	

	public BankAccountEntity(String iban, String moneda, double suma, UserAccountEntity userAccountEntity) {
		super();
		this.iban = iban;
		this.moneda = moneda;
		this.suma = suma;
		this.userAccountEntity = userAccountEntity;
	}



	public BankAccountEntity() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public double getSuma() {
		return suma;
	}

	public void setSuma(double suma) {
		this.suma = suma;
	}

	public UserAccountEntity getUserAccountEntity() {
		return userAccountEntity;
	}

	public void setUserAccountEntity(UserAccountEntity userAccountEntity) {
		this.userAccountEntity = userAccountEntity;
	}
	
	

	public List<TransactionsEntity> getTransactionsEntity() {
		return transactionsEntity;
	}



	public void setTransactionsEntity(List<TransactionsEntity> transactionsEntity) {
		this.transactionsEntity = transactionsEntity;
	}



	@Override
	public int hashCode() {
		return Objects.hash(iban, id, moneda, suma, userAccountEntity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccountEntity other = (BankAccountEntity) obj;
		return Objects.equals(iban, other.iban) && id == other.id && Objects.equals(moneda, other.moneda)
				&& Double.doubleToLongBits(suma) == Double.doubleToLongBits(other.suma)
				&& Objects.equals(userAccountEntity, other.userAccountEntity);
	}

	
}
