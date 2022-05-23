package com.inti.SpringBootValidationThymeleaf_.controller;

import javax.validation.Valid;

import com.inti.SpringBootValidationThymeleaf_.model.Utilisateur;
import com.inti.SpringBootValidationThymeleaf_.repository.UtilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController 
{

		
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@GetMapping("/hello")
	public String hello()
	{
		return "hello";
	}
	
	@GetMapping("/creerUtilisateur")
	public String creerUtilisateur(Utilisateur utilisateur)
	{
		return "creerUtilisateur";
	}
	
	@PostMapping("/creerUtilisateur")
	public String saveUser(@Valid Utilisateur utilisateur, BindingResult br)
	{
		for (FieldError fe : br.getFieldErrors()) 
		{
			System.out.println(fe);
		}
		
		if (br.hasErrors())
		{
			return  "redirect:/listeUtilisateur";
		}
		
//		String nom = utilisateur.getNom();
	//	if(nom.length())
		log.info("user :" +utilisateur);
		
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		String mdpCrypt = b.encode(utilisateur.getMdp());
		utilisateur.setMdp(mdpCrypt);
		utilisateurRepository.save(utilisateur);
		return"redirect:/listeUtilisateur";
	}
	
	@GetMapping("/listeUtilisateur")
	public String listeUtilisateur()
	{
		return "listeUtilisateur";
	}
}
