//package com.laptrinhspringboot.vn.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.laptrinhspringboot.vn.rest.CustomAccessDeniedHandler;
//import com.laptrinhspringboot.vn.rest.JwtAuthenticationTokenFilter;
//import com.laptrinhspringboot.vn.rest.RestAuthenticationEntryPoint;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Bean
//	public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() throws Exception {
//		JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter();
//		jwtAuthenticationTokenFilter.setAuthenticationManager(authenticationManager());
//		return jwtAuthenticationTokenFilter;
//	}
//
//	@Bean
//	public RestAuthenticationEntryPoint restServicesEntryPoint() {
//		return new RestAuthenticationEntryPoint();
//	}
//
//	@Bean
//	public CustomAccessDeniedHandler customAccessDeniedHandler() {
//		return new CustomAccessDeniedHandler();
//	}
//
//	@Bean
//	@Override
//	protected AuthenticationManager authenticationManager() throws Exception {
//		return super.authenticationManager();
//	}
//
//	protected void configure(HttpSecurity http) throws Exception {
//		// Disable crsf cho đường dẫn /rest/**
//		http.csrf().ignoringAntMatchers("/congthongtin/**");
//
//		http.authorizeRequests().antMatchers("/congthongtin/login**").permitAll();
//
//		http.antMatcher("/congthongtin/**").httpBasic().authenticationEntryPoint(restServicesEntryPoint()).and()
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
//				.antMatchers(HttpMethod.GET, "/congthongtin/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
//				.antMatchers(HttpMethod.POST, "/congthongtin/**").access("hasRole('ROLE_ADMIN')")
//				.antMatchers(HttpMethod.DELETE, "/congthongtin/**").access("hasRole('ROLE_ADMIN')").and()
//				.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
//				.exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
//	}
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//}
