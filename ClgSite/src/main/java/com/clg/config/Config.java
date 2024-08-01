package com.clg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class Config {



    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
    // {

        
    //     httpSecurity.authorizeHttpRequests(authorize->{
    //         authorize.requestMatchers("/admin/*").authenticated();
    //         authorize.anyRequest().permitAll();
    //     });

    //     httpSecurity.formLogin(formLogin->{
	// 		formLogin.loginPage("/login")
	// 		.loginProcessingUrl("/authenticate")
	// 		.successForwardUrl("/admin/addClg")
    //         .successForwardUrl("/admin/addStream")
	// 		.failureForwardUrl("/login?error=true");
			
			
	// 		// .usernameParameter("email")
	// 		// .passwordParameter("password");

    //         try {
    //             httpSecurity.csrf(AbstractHttpConfigurer::disable);
    //         } catch (Exception e) {
    //             // TODO Auto-generated catch block
    //             e.printStackTrace();
    //         }

    //         // httpSecurity.logout(logout->{
    //         //     logout.logoutUrl("/do-logout")
    //         //     .logoutSuccessUrl("/login?logout=true");
    //         // });
    //         try {
    //             httpSecurity.logout(logout->{
    //                 logout.logoutUrl("/logout")
    //                 .logoutSuccessUrl("/login?logout=true");
    //             });
    //         } catch (Exception e) {
    //             // TODO Auto-generated catch block
    //             e.printStackTrace();
    //         }
            

	// 	});



    //     return httpSecurity.build();
        
    // }
    
}
