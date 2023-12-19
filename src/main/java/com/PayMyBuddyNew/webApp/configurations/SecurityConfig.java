package com.PayMyBuddyNew.webApp.configurations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
    private UserDetailsService userDetailsService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
		.authorizeHttpRequests(authorize ->
				authorize
						.requestMatchers("/css/**").permitAll()
						.requestMatchers("/register/**").permitAll()
						.requestMatchers("/logoff").permitAll()
						.requestMatchers("/user/**").authenticated()
						.requestMatchers("/home").authenticated()
						.requestMatchers("/transaction").authenticated()
						.requestMatchers("/transfert").authenticated()
						.requestMatchers("/error").permitAll()
		).formLogin(
				form -> form
						.loginPage("/login")
						.usernameParameter("email")
				        .passwordParameter("mdp")
						.loginProcessingUrl("/login")
						.defaultSuccessUrl("/home", true)
						.failureUrl("/login?error=true")
						.permitAll()
		).logout(
				logout -> logout
						.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
						.logoutSuccessUrl("/logoff")
		);

      return http.build();
	}

	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	 @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth
	                .userDetailsService(userDetailsService)
	                .passwordEncoder(passwordEncoder());
	    }
}