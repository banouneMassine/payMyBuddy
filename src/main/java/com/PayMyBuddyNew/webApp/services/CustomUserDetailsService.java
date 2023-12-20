package com.PayMyBuddyNew.webApp.services;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.PayMyBuddyNew.webApp.controllers.ApplicationControllerAdvice;
import com.PayMyBuddyNew.webApp.models.Role;
import com.PayMyBuddyNew.webApp.models.Utilisateur;
import com.PayMyBuddyNew.webApp.repository.UtilisateurRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	 private static final Logger logger =  LoggerFactory.getLogger(ApplicationControllerAdvice.class);
	@Autowired
	private UtilisateurRepository utilisateurRepository ;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		
		Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmail(email);
	
		 if (utilisateur.isPresent()) {
			
	            return new org.springframework.security.core.userdetails.User(utilisateur.get().getEmail(),
	            		utilisateur.get().getMdp(),
	                    mapRolesToAuthorities(utilisateur.get().getRoles()));
	        }else{
	        	logger.error("Invalid username or password.");
	            throw new UsernameNotFoundException("Invalid username or password.");
	        }
		
	}
	
	 private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
	        Collection < ? extends GrantedAuthority> mapRoles = roles.stream()
	                .map(role -> new SimpleGrantedAuthority(role.getName()))
	                .collect(Collectors.toList());
	        return mapRoles;
	    }

}
