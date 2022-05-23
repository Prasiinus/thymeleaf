package com.inti.SpringBootValidationThymeleaf_.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter
{
	
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
	
		http
		.csrf()
		.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.and()
			.authorizeRequests()
			.antMatchers("/creerUtilisateur", "/saveUser").permitAll()
//			.antMatchers("/admin/**").hasRole("ADMIN")
//			.antMatchers("/helloUser").hasRole("USER")
			.anyRequest().authenticated()
			.and()
			.formLogin();
//			.loginPage("/login")
//			.failureUrl("/login?error=true")
//			.defaultSuccessUrl("/hello");
//			.and()
//			.csrf().disable();
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
		
		auth.inMemoryAuthentication()
		.withUser("test").password(passwordEncoder().encode("test")).roles("USER")
		.and()
		.withUser("admin1").password(passwordEncoder().encode("admin1")).roles("ADMIN", "MANAGER");
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
}
