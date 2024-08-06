package com.clg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class Config {



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
    {

        
        // httpSecurity.authorizeHttpRequests(authorize->{
        //     authorize.requestMatchers("/admin/**").authenticated()
        //     .anyRequest().permitAll();
        // });

        // httpSecurity.formLogin(formLogin->{
		// 	formLogin.loginPage("/login")
		// 	.loginProcessingUrl("/do-login")
		// 	.successForwardUrl("/admin/adminPage")
		// 	.failureForwardUrl("/login?error=true")
        //     .usernameParameter("name")
        //     .passwordParameter("password");

        //     System.out.println("formlogin");
          

		// });

        // httpSecurity.csrf(AbstractHttpConfigurer::disable);

        // httpSecurity.logout(logout->{

        //     logout.logoutUrl("/do-logout")
        //     .logoutSuccessUrl("/login?logout=true");
        //    });
            



        return httpSecurity.build();
        
    }

   
    
}
