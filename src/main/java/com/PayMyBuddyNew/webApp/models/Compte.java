package com.PayMyBuddyNew.webApp.models;


import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comptes")
public class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_compte")
	private int idCompte ;
	
	@Column(name = "solde")
	private float solde;
	
	@OneToMany(
			   cascade = CascadeType.ALL, 
			   orphanRemoval = true, 
			   fetch = FetchType.EAGER)
	@JoinColumn(name = "_id_compte_emetteur")
	List<Transaction> listTransactionsEmeteur = new ArrayList<Transaction>(); 
	
	@OneToMany(
			   cascade = CascadeType.ALL, 
			   orphanRemoval = true, 
			   fetch = FetchType.EAGER)
	@JoinColumn(name = "_id_compte_recepteur")
	List<Transaction> listTransactionsRecepteur = new ArrayList<Transaction>(); 
	
	@OneToMany(
			   cascade = CascadeType.ALL, 
			   orphanRemoval = true, 
			   fetch = FetchType.EAGER)
	@JoinColumn(name = "_id_compte")
	List<Transfert> listTransferts = new ArrayList<Transfert>(); 
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_compte", referencedColumnName = "id_utilisateur")
	Utilisateur utilisateur ; 
	
	public int getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}
	
	public List<Transaction> getListTransactionsEmeteur() {
		return listTransactionsEmeteur;
	}

	public void setListTransactionsEmeteur(List<Transaction> listTransactionsEmeteur) {
		this.listTransactionsEmeteur = listTransactionsEmeteur;
	}

	public List<Transaction> getListTransactionsRecepteur() {
		return listTransactionsRecepteur;
	}

	public void setListTransactionsRecepteur(List<Transaction> listTransactionsRecepteur) {
		this.listTransactionsRecepteur = listTransactionsRecepteur;
	}

	public List<Transfert> getListTransferts() {
		return listTransferts;
	}

	public void setListTransferts(List<Transfert> listTransferts) {
		this.listTransferts = listTransferts;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}
