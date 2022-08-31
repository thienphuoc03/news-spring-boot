package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.security.CustomAccessDeniedHandler;
import com.example.security.JwtAuthenticationEntryPoint;
import com.example.security.JwtAuthenticationFilter;
import com.example.service.impl.CustomUserDetailsService;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private JwtAuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
	private JwtAuthenticationFilter authenticationFilter;

	@Autowired
	private CustomAccessDeniedHandler accessDeniedHandler;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		// Password encoder mã hóa mật khẩu người dùng
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder;
	}

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		// login api
		http.authorizeRequests().antMatchers("/api/login").permitAll();

		// user api
//		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/news*").hasRole("ADMIN");
//		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/news*").hasRole("ADMIN");
//		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/news*").hasRole("ADMIN");
//		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/news*").hasRole("ADMIN");
//
//		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/categories*").hasRole("ADMIN");
//		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/categories*").hasRole("ADMIN");
//		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/categories*").hasRole("ADMIN");
//		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/categories*").hasRole("ADMIN");
//
//		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/users*").hasAnyRole("ADMIN", "USER");
//		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/users*").hasRole("ADMIN");
//		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/users*").hasRole("ADMIN");
//		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/users*").hasRole("ADMIN");

		http.authorizeRequests().anyRequest().authenticated();

		http.exceptionHandling().accessDeniedHandler(accessDeniedHandler)
				.authenticationEntryPoint(authenticationEntryPoint);

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
