package com.inti.SpringBootValidationThymeleaf_.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor @AllArgsConstructor
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message="saisir un nom non vide !")
	@Size(min = 3, max = 100, message="saisir au moins 3 caractères")
	@Column(length = 50)
	private String nom;
	private String prenom;
	@Column(unique = true)
	private String username;
	@Email
	private String email;
	private String mdp;
	@Pattern(regexp = "^0[1-9]{1}[\\.[0-9]{2}\\.[0-9]{2}]{2}$", message = "saisir telephone au format xx.xx.xx.xx")
	private String telephone;
	
	@ManyToMany
	@JoinTable(name="Utilisateur_Role",
			joinColumns = @JoinColumn(name = "id_utilisateur"),
			inverseJoinColumns = @JoinColumn(name = "id_role"))
	List<Role> listeRole;

	public Utilisateur(String nom, String prenom, String username, String email, String mdp,
			String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.email = email;
		this.mdp = mdp;
		this.telephone = telephone;
	}
	
	
}
