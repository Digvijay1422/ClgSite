package com.clg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.clg.services.Impl.SecurityCustomUserDeatilService;



@Configuration
public class Config {
    
	
	@Autowired
	private AuthFailureHandler failureHandler;
	
	private SecurityCustomUserDeatilService securityCustomUserDeatilService;

	public Config(SecurityCustomUserDeatilService securityCustomUserDeatilService){
		this.securityCustomUserDeatilService = securityCustomUserDeatilService;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(securityCustomUserDeatilService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		
		return daoAuthenticationProvider;
	}

	

	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
	{
		// Configuration
		
		httpSecurity.authorizeHttpRequests(authorize->{
			authorize.requestMatchers("/admin/**").authenticated();
			authorize.anyRequest().permitAll();
		});
		
		
		httpSecurity.formLogin(formLogin->{
			formLogin.loginPage("/login")
			.loginProcessingUrl("/authenticate")
			.successForwardUrl("/admin/adminPage")
			.passwordParameter("password")
			.usernameParameter("username")
			.failureForwardUrl("/login?error=true");
			formLogin.failureHandler(failureHandler);

		});

		
		httpSecurity.csrf(AbstractHttpConfigurer::disable);
		
		
		
		httpSecurity.logout(logout->{
			logout.logoutUrl("/do-logout")
			.logoutSuccessUrl("/login?logout=true");
		});
		

		return httpSecurity.build();
	}
    
}
