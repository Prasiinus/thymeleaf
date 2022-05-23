package com.inti.SpringBootValidationThymeleaf_.repository;

import com.inti.SpringBootValidationThymeleaf_.model.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<User, Integer>{

}
