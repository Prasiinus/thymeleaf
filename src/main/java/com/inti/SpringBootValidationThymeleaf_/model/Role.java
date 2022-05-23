package com.inti.SpringBootValidationThymeleaf_.model;

import java.util.List;

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

public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private @NonNull String nomRole;
	
	@ManyToMany
	@JoinTable(name="Utilisateur_Role",
			joinColumns = @JoinColumn(name = "id_role"),
			inverseJoinColumns = @JoinColumn(name = "id_utilisateur"))
	List<Utilisateur> listeUtilisateur;

}
