package com.PayMyBuddyNew.webApp.services;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.PayMyBuddyNew.webApp.models.Utilisateur;
import com.PayMyBuddyNew.webApp.dto.UtilisateurDto;
import com.PayMyBuddyNew.webApp.exceptions.UtilisateurPresentException;
import com.PayMyBuddyNew.webApp.models.Compte;
import com.PayMyBuddyNew.webApp.models.Role;
import com.PayMyBuddyNew.webApp.repository.UtilisateurRepository;
import com.PayMyBuddyNew.webApp.repository.RoleRopository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class UtilisateurService {
	
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@Autowired
	RoleRopository roleRepository;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	 private static final Logger logger =  LoggerFactory.getLogger(UtilisateurService.class);
	
	public Optional<Utilisateur> findUtilisateurByEmail(String email)
	{
		return utilisateurRepository.findByEmail(email);
	}
	
	public List<UtilisateurDto> findAllUtilisateurs()
	{
		List<UtilisateurDto> listDesUtilisateursDto = new ArrayList<>();
		
		for(Utilisateur  user :  utilisateurRepository.findAll() )
		{
			listDesUtilisateursDto.add(this.convertToDto(user));
		}
		
		return listDesUtilisateursDto ;  
	}
	
	public UtilisateurDto  inscription(Utilisateur utilisateur) throws UtilisateurPresentException
	{
		
		Optional<Utilisateur> existUtilisateur = this.findUtilisateurByEmail(utilisateur.getEmail());
		if(existUtilisateur.isPresent())
		{
			logger.error("Ce compte existe déja!");
			throw new UtilisateurPresentException("Cette utilisateur existe déja!" ,existUtilisateur  );
		}
	

		String mdpCrypte = passwordEncoder.encode(utilisateur.getMdp());
		utilisateur.setMdp(mdpCrypte);
		
		Compte compte = new Compte();
		compte.setSolde(0);
		utilisateur.setCompte(compte);
		
		 Role role = roleRepository.findByName("ROLE_ADMIN");
	     if(role == null){
	           role = checkRoleExist();
	        }
	     utilisateur.setRoles(Arrays.asList(role));
	
		return this.convertToDto(utilisateurRepository.save(utilisateur));
	}
	
	
	
	/*
	 * convertir un utilisateur a un itilisateur DTO 
	 */
	public UtilisateurDto convertToDto( Utilisateur utilisateur)
	{
		UtilisateurDto  utilisateurDto = new UtilisateurDto();
		
		utilisateurDto.setIdUtilisateur(utilisateur.getIdUtilisateur());
		utilisateurDto.setEmail(utilisateur.getEmail());
		utilisateurDto.setNom(utilisateur.getNom());
		utilisateurDto.setPrenom(utilisateur.getPrenom());

		return utilisateurDto;
	}
	
	 private Role checkRoleExist(){
	        Role role = new Role();
	        role.setName("ROLE_ADMIN");
	        return roleRepository.save(role);
	    }

}
