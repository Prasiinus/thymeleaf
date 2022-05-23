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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor @RequiredArgsConstructor @AllArgsConstructor
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private @NonNull String nom;
	private String prenom;
	@Column(unique = true)
	private String username;
	private String email;
	private String mdp;
	private String telephone;
	
	@ManyToMany
	@JoinTable(name="Utilisateur_Role",
			joinColumns = @JoinColumn(name = "id_utilisateur"),
			inverseJoinColumns = @JoinColumn(name = "id_role"))
	List<Role> listeRole;
}
