package com.PayMyBuddyNew.webApp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.PayMyBuddyNew.webApp.models.Utilisateur;
import com.PayMyBuddyNew.webApp.services.UtilisateurService;

@Controller
public class UtilisateurController {
	
	@Autowired 
	UtilisateurService utilisateurService ;
	
	@GetMapping("/register")
	public String getRegisterPage( Model model)
	{
		Utilisateur utilisateur = new Utilisateur();
	    model.addAttribute("utilisateur", utilisateur);
		return "register";
	}
	
	@PostMapping("/register/save")
	public String Inscription( @ModelAttribute("utilisateur") Utilisateur utilisateur) throws RuntimeException
	{
		utilisateurService.inscription(utilisateur);
		
		return "redirect:/login";
	}
	
	
	
	@GetMapping("/login")
	public String getLogingPage()  throws UsernameNotFoundException
	{
		return "login";
	}
	
	@GetMapping("/home")
    public String home(Model model, Authentication authentication) {
		
		UserDetails  userDetails = (UserDetails) authentication.getPrincipal();
		String username = userDetails.getUsername();
		Optional<Utilisateur> utilisateur = utilisateurService.findUtilisateurByEmail(username);

		model.addAttribute("nom", utilisateur.get().getNom().toUpperCase());
        model.addAttribute("prenom", utilisateur.get().getPrenom());
        return "home"; 
    }
	
	
	
	
}
