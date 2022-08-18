package br.com.empregaelas.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.empregaelas.service.UserService;

public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

	@Autowired
	private JwtProvider jwtProvider;
	
	@Autowired
	private UserService userService;

	public JwtConfigurer(JwtProvider tokenProvider, UserService userService) {
		this.userService = userService;
		this.jwtProvider = tokenProvider;
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		JwtTokenFilter customFilter = new JwtTokenFilter(jwtProvider, userService);
		http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
	}
}


