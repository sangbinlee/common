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
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable);
		http.httpBasic(HttpBasicConfigurer::disable);
		http.cors(corsConfigurer -> corsConfigurer.configurationSource(corsConfigurationSource()));
//		http.cors(corsConfigurer -> corsConfigurer.configurationSource(corsConfigurer()));
		
		
		http.authorizeHttpRequests(authorize -> 
			authorize
				.requestMatchers("/favicon.ico").permitAll()
				.requestMatchers("/api/cookie").permitAll()
				.requestMatchers("/api/orders").permitAll()
//				.requestMatchers("/api/cart").permitAll()
				.requestMatchers("/api/cart/**").permitAll()
				.requestMatchers("/api/check").permitAll()
				.requestMatchers("/api/employee/**").permitAll()
				.requestMatchers("/api/item").permitAll()
				
				.requestMatchers("/api/logout").permitAll()
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
	
	
	
	
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//	    return new WebMvcConfigurer() {
//	        @Override
//	        public void addCorsMappings(CorsRegistry registry) {
//	            registry.addMapping("/**")
////	                .allowedOrigins("http://yourfrontend.com")
//	                .allowedOrigins("*")
//	                .allowedMethods("*")
//	                .allowCredentials(true);
//	        }
//	    };
//	}
	
	

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
