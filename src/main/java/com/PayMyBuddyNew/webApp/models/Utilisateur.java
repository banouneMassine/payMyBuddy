package com.PayMyBuddyNew.webApp.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name ="utilisateurs")
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utilisateur")
	private int idUtilisateur;
	
	@Column(name = "email")
	private String email; 
	
	
	@Column(name = "mdp")
	private String mdp; 
	
	@Column(name= "nom")
	private String nom ;
	
	@Column(name= "prenom")
	private String prenom ;


    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="utilisateurs_roles",
            joinColumns={@JoinColumn(name="_id_utilisateur", referencedColumnName="id_utilisateur")},
            inverseJoinColumns={@JoinColumn(name="_id_role", referencedColumnName="id_role")})
    private List<Role> roles = new ArrayList<>();


	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "utilisateur", fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
    private Compte compte;
	
	@ManyToMany
	@JoinTable(
	    name = "amis",
	    joinColumns = @JoinColumn(name = "id_utilisateur"),
	    inverseJoinColumns = @JoinColumn(name = "id_ami")
	)
	private List<Utilisateur> amis = new ArrayList<>();
	

	
	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public List<Utilisateur> getAmis() {
		return amis;
	}

	public void setAmis(List<Utilisateur> amis) {
		this.amis = amis;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	
	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", email=" + email + ", mdp=" + mdp + ", nom=" + nom
				+ ", prenom=" + prenom + ", roles=" + roles + ", compte=" + compte + ", amis=" + amis + "]";
	}

}
