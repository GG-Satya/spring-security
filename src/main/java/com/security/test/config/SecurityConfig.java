package com.security.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
  
	public void configure(HttpSecurity http) throws Exception{
		
		http
//		.csrf().disable()
		.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and() // TO send CSRF token with the Cookie
		.authorizeRequests()
		.antMatchers("/signin").permitAll()
		.antMatchers(HttpMethod.GET ,"/public/**").hasRole("NORMAL")
		.antMatchers("/user/**").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
//		.httpBasic(); // without Form login
		.formLogin()
		.loginPage("/signin")
		.loginProcessingUrl("/dologin")
		.defaultSuccessUrl("/user/");
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception{
		builder.inMemoryAuthentication().withUser("admin").password(this.encoder().encode("admin")).roles("ADMIN");
		builder.inMemoryAuthentication().withUser("gudu").password(this.encoder().encode("gudu")).roles("NORMAL");
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
