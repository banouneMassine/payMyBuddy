package com.PayMyBuddyNew.webApp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.PayMyBuddyNew.webApp.models.Utilisateur;



@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur , Integer> {
	public Optional<Utilisateur> findByEmail(String email);
}
