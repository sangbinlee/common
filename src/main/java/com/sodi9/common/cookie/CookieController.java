package com.sodi9.common.cookie;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/cookie")
public class CookieController {


	
	public static class Constants{
		public static final String token1 = "testToken";
		public static final String token2 = "testToken2";
	}
	
	
	
	
	@PostMapping
	@ResponseBody
	public String registerUser(HttpServletResponse response) {
		// For simplicity, we'll just set a cookie with the username
		Cookie cookie = new Cookie(Constants.token1, "1");
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24*365);// 365일
//		cookie.same
		response.addCookie(cookie);
//		response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
		
		
		
		
		
		

		String name = Constants.token2;
		String value = "2";
		ResponseCookie cookie2 = 
				ResponseCookie
				.from(name, value)
				
				.path("/")
//				.httpOnly(true)
//				.secure(true)
				

				.httpOnly(false)
				.secure(false)
				
				
				
//				.sameSite("None") // 이거 세팅 하면 쿠키가 application 텝에 안남음????????
//				.sameSite("Lax") // 해도 되고 안해도 쿠키 잘남음
				
//				.maxAge(Duration.ofHours(hour))
//				.maxAge(hour)
				.build();

		response.addHeader(HttpHeaders.SET_COOKIE, cookie2.toString());
		
		
		
		return "############## save cookie, key=testToken, value=testToken";
	}

	@GetMapping 
	@ResponseBody
	public String welcomeUser(
			@CookieValue(value = Constants.token1, defaultValue = "Guest") String testToken,
			@CookieValue(value = Constants.token2, defaultValue = "Guest2") String testToken2
			
			
			) {
		log.error("쿠키가 안됨");
		log.error("쿠키가 안됨");
		log.error("쿠키가 안됨");
		log.error("쿠키가 안됨");
		log.error("쿠키가 안됨");
		log.error("쿠키가 안됨");
		log.error("쿠키가 안됨");
		return "%%%%%%%%%%%%% save cookie, key=testToken, token1=" + testToken+ ", token1=" + testToken2;
	}
	
	
	
	
}
