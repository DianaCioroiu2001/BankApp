package com.fdm.bankApp.dao.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Transactions")
public class TransactionsEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "suma")
	private double suma;
	
	@Column(name = "zi")
	private int zi;
	
	@Column(name = "luna")
	private int luna;
	
	@Column(name = "an")
	private int an;
	
	@Column(name = "nume")
	private String nume;



	@Column(name = "iban")
	private String iban;

	
	@Column(name = "tip")
	private String tip;


	@Column(name = "ora")
	private int ora;

	@Column(name = "minutes")
	private int minutes;
	

	@ManyToOne()
	@JoinColumn(name = "user_id")
	private BankAccountEntity bankAccountEntity;

	public TransactionsEntity(int id, double suma, int zi, int luna, int an, String nume, 
			String iban, String tip, int ora, int minutes) {
		super();
		this.id = id;
		this.suma = suma;
		this.zi = zi;
		this.luna = luna;
		this.an = an;
		this.nume = nume;
		this.iban = iban;
		this.tip = tip;
		this.ora = ora;
		this.minutes = minutes;
	}


	public TransactionsEntity(double suma, int zi, int luna, int an, String nume, String iban,  String tip,
			int ora, int minutes, BankAccountEntity bankAccountEntity) {
		super();
		this.suma = suma;
		this.zi = zi;
		this.luna = luna;
		this.an = an;
		this.nume = nume;
		this.iban = iban;
		this.tip = tip;
		this.ora = ora;
		this.minutes = minutes;
		this.bankAccountEntity = bankAccountEntity;
	}


	public TransactionsEntity(double suma, int zi, int luna, int an, String nume, String iban, 
			String tip, int ora, int minutes) {
		super();
		this.suma = suma;
		this.zi = zi;
		this.luna = luna;
		this.an = an;
		this.nume = nume;
		this.iban = iban;
		this.tip = tip;
		this.ora = ora;
		this.minutes = minutes;
	}


	public TransactionsEntity() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getSuma() {
		return suma;
	}


	public void setSuma(double suma) {
		this.suma = suma;
	}


	public int getZi() {
		return zi;
	}


	public void setZi(int zi) {
		this.zi = zi;
	}


	public int getLuna() {
		return luna;
	}


	public void setLuna(int luna) {
		this.luna = luna;
	}


	public int getAn() {
		return an;
	}


	public void setAn(int an) {
		this.an = an;
	}


	public String getNume() {
		return nume;
	}


	public void setNume(String nume) {
		this.nume = nume;
	}





	public String getIban() {
		return iban;
	}


	public void setIban(String iban) {
		this.iban = iban;
	}



	public String getTip() {
		return tip;
	}


	public void setTip(String tip) {
		this.tip = tip;
	}


	public int getOra() {
		return ora;
	}


	public void setOra(int ora) {
		this.ora = ora;
	}


	public int getMinutes() {
		return minutes;
	}


	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}


	@Override
	public int hashCode() {
		return Objects.hash(an, iban, suma, id, luna, minutes, nume, ora, tip, zi);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionsEntity other = (TransactionsEntity) obj;
		return an == other.an && Objects.equals(iban, other.iban)
				&& Double.doubleToLongBits(suma) == Double.doubleToLongBits(other.suma) && id == other.id
				&& luna == other.luna && minutes == other.minutes && Objects.equals(nume, other.nume)
				&& ora == other.ora 
				&& Objects.equals(tip, other.tip) && zi == other.zi;
	}


	

	
	
}
