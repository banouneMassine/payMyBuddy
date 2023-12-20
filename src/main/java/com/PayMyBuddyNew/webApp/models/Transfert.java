package com.PayMyBuddyNew.webApp.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transferts")
public class Transfert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_transfert")
	private int idTransfert ; 
	
	@Column(name = "date_transfert")
	private LocalDateTime  dateTransfert;
	
	@Column(name = "montant_transfert")
	private float montantTransfert;
	
	@Column(name = "type_transfert")
	private String typeTransfert ;

	public int getIdTransfert() {
		return idTransfert;
	}

	public void setIdTransfert(int idTransfert) {
		this.idTransfert = idTransfert;
	}

	public LocalDateTime getDateTransfert() {
		return dateTransfert;
	}

	public void setDateTransfert(LocalDateTime dateTransfert) {
		this.dateTransfert = dateTransfert;
	}

	public float getMontantTransfert() {
		return montantTransfert;
	}

	public void setMontantTransfert(float montantTransfert) {
		this.montantTransfert = montantTransfert;
	}

	public String getTypeTransfert() {
		return typeTransfert;
	}

	public void setTypeTransfert(String typeTransfert) {
		this.typeTransfert = typeTransfert;
	} 
	
}
