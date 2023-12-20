package com.PayMyBuddyNew.webApp.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_transaction")
	private int idTransaction; 
	
	@Column(name = "date_transaction")
	private LocalDateTime  dateTransaction;
	
	@Column(name = "montant_transaction")
	private float  montantTransaction;

	public float getMontantTransaction() {
		return montantTransaction;
	}

	public void setMontantTransaction(float montantTransaction) {
		this.montantTransaction = montantTransaction;
	}

	public int getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(int idTransaction) {
		this.idTransaction = idTransaction;
	}

	public LocalDateTime getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(LocalDateTime dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	
}
