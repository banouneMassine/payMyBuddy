package com.PayMyBuddyNew.webApp.exceptions;

import java.util.Optional;

import com.PayMyBuddyNew.webApp.models.Utilisateur;

public class UtilisateurPresentException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Optional<Utilisateur>  utilisatreur ; 
	public  UtilisateurPresentException(String message , Optional<Utilisateur>  user )
	{
		super(message);
		this.utilisatreur =  user ; 
		
	}
	public Optional<Utilisateur>  getUtilisatreur() {
		return utilisatreur;
	}


}
