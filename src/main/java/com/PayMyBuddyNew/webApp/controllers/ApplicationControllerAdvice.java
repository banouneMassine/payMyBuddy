package com.PayMyBuddyNew.webApp.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.PayMyBuddyNew.webApp.exceptions.UtilisateurPresentException;



@ControllerAdvice
public class ApplicationControllerAdvice {

	 private static final Logger logger =  LoggerFactory.getLogger(ApplicationControllerAdvice.class); 
		@ResponseStatus(HttpStatus.UNAUTHORIZED)
		@ExceptionHandler(value = UtilisateurPresentException.class)
		public String exceptionHandler(UtilisateurPresentException exception , Model model )
		{
			//logger.error("description");
			 
			model.addAttribute("utilisateur", exception.getUtilisatreur());
			model.addAttribute("errorMessage", exception.getMessage());
			return "register";
		}
}
