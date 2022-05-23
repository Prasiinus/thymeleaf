package com.inti.SpringBootValidationThymeleaf_.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController 
{

	@GetMapping("hello")
	public String hello()
	{
		return "hello";
	}
}
