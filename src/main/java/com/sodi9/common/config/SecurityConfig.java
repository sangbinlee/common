package com.sodi9.common.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable);
		http.httpBasic(HttpBasicConfigurer::disable);
		http.cors(corsConfigurer -> corsConfigurer.configurationSource(corsConfigurationSource()));
		
		
		http.authorizeHttpRequests(authorize -> 
			authorize
				.requestMatchers("/api/check").permitAll()
				.requestMatchers("/api/employees").permitAll()
				.requestMatchers("/api/item").permitAll()
				.requestMatchers("/auth/login").permitAll()
				.requestMatchers("/member/join").permitAll()
				.requestMatchers("/").permitAll()
				.requestMatchers("/cookie").permitAll()
				.requestMatchers("/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-ui.html").permitAll()
				
				.anyRequest().authenticated());
		return http.build();
	}
	
	
	
	
	
	
	

	// ⭐️ CORS 설정
    CorsConfigurationSource corsConfigurationSource() {
        return request -> {
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowedHeaders(Collections.singletonList("*"));
            config.setAllowedMethods(Collections.singletonList("*"));
            config.setAllowedOriginPatterns(Collections.singletonList(
//            		"http://localhost:5173" 
//            		"http://localhost:3000"
            		"*"
            		)); // ⭐️ 허용할 origin
            config.setAllowCredentials(true);
            return config;
        };
    }
}
