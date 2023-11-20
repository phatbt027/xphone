package com.phatbt027.XPhone.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Bean
	UserDetailsService userDetailsService() {
		
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//
//		return authenticationConfiguration.getAuthenticationManager();
//	}
//
	@Bean
	AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {

		DaoAuthenticationProvider authenProvider = new DaoAuthenticationProvider();
		authenProvider.setPasswordEncoder(passwordEncoder());
		authenProvider.setUserDetailsService(userDetailsService);

		return new ProviderManager(authenProvider);
	}
	
//	@Bean
//	WebSecurityCustomizer webSecurityCustomizer() {
//		return (web) -> web.ignoring().requestMatchers(
//				""
//				);
//	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
			.csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests((auth) -> auth
					.requestMatchers("/css/**").permitAll()
					.requestMatchers("/js/**").permitAll()
					.anyRequest().authenticated())
			.formLogin((formLogin) -> 
				formLogin.loginPage("/login")
				.defaultSuccessUrl("/index")
				.failureUrl("/login.html?error=true")
				.permitAll()
			)
			.httpBasic(Customizer.withDefaults());
			return http.build();
	}
}
