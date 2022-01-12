package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/public").hasRole("NORMAL")
                .antMatchers(HttpMethod.GET, "/users/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/signin")
                .loginProcessingUrl("/dologin")
                .defaultSuccessUrl("/usres/");
                

	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		String username;
		String charSequence;
		auth.inMemoryAuthentication().withUser(username:"irfan").password(this.passwordEncoder().encode(charSequence:"mad")).roles("NORMAL");
		auth.inMemoryAuthentication().withUser(username:"roshni").password(this.passwordEncoder().encode(charSequence: "abc")).roles("NORMAL");
		
	}
	
	//ROLE - High Level Overview->NORMAL :READ
	//Authority - permission->READ
	//ADMIN- READ,WRITE,UPDATE
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		int strength;
		return new BCryptPasswordEncoder(strength: 10);
	}
}

