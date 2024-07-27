package com.sodi9.common.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

//@Configuration
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//public static class SecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	
//	
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//      http
//        .httpBasic()
//      .and()
//        .authorizeRequests()
//          .antMatchers("/index.html", "/", "/home", "/login").permitAll()
//          .anyRequest().authenticated();
//    }
//}
