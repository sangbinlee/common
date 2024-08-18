package com.sodi9.common.cookie;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/cookie")
public class CookieController {


	
	public static class Constants{
		public static final String token = "token";
		public static final String token1 = "testToken";
		public static final String token2 = "testToken2";
	}
	
	
	
	
	@PostMapping
	public String registerUser(HttpServletResponse response) {
		// For simplicity, we'll just set a cookie with the username
		Cookie cookie = new Cookie(Constants.token1, "33333333333331");
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24*365);// 365일
//		cookie.same
		response.addCookie(cookie);
//		response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
		
		
		
		
		
		

		String name = Constants.token2;
		String value = "222222222222";
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
	public String get(
			@CookieValue(value = Constants.token, defaultValue = "Guest") String token,
			@CookieValue(value = Constants.token1, defaultValue = "Guest") String testToken,
			@CookieValue(value = Constants.token2, defaultValue = "Guest2") String testToken2,
			HttpServletRequest req, HttpServletResponse response
			
			) {

		log.error("쿠키 token={} ", token);
		log.error("쿠키 testToken={}, testToken2={}", testToken, testToken2);
		
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				log.error(c.getName()); // 쿠키 이름 가져오기
				log.error(c.getValue()); // 쿠키 값 가져오기
			}
		}
		
		return "%%%%%%%%%%%%% save cookie, key=testToken, token1=" + testToken+ ", token1=" + testToken2;
	}
	

//    @Transactional
	@DeleteMapping 
	public String delete(
			@CookieValue(value = Constants.token1, defaultValue = "Guest") String testToken,
			@CookieValue(value = Constants.token2, defaultValue = "Guest2") String testToken2,
			HttpServletRequest req, HttpServletResponse response
			
			) {
		log.error("쿠키 testToken={}, testToken2={}", testToken, testToken2);
		log.error("쿠키 testToken={}, testToken2={}", testToken, testToken2);
		log.error("쿠키 testToken={}, testToken2={}", testToken, testToken2);
		log.error("쿠키 testToken={}, testToken2={}", testToken, testToken2);
		log.error("쿠키 testToken={}, testToken2={}", testToken, testToken2);
		log.error("쿠키 testToken={}, testToken2={}", testToken, testToken2);
		log.error("쿠키 testToken={}, testToken2={}", testToken, testToken2);
		log.error("쿠키 testToken={}, testToken2={}", testToken, testToken2);
		
		Cookie[] cookies = req.getCookies();
		  
		  for(Cookie c : cookies) {
			  log.error(c.getName());  // 쿠키 이름 가져오기
			  log.error(c.getValue());  // 쿠키 값 가져오기
		  }
		

		Cookie cookie = new Cookie(Constants.token1, null);  // 쿠키 값을 null로 설정
		cookie.setPath("/");
		cookie.setMaxAge(0);  // 남은 만료시간을 0으로 설정
		response.addCookie(cookie);
		
		cookie = new Cookie(Constants.token2, null);  // 쿠키 값을 null로 설정
		cookie.setPath("/");
		cookie.setMaxAge(0);  // 남은 만료시간을 0으로 설정
		response.addCookie(cookie);
		
		
		
		
		return "%%%%%%%%%%%%% save cookie, key=testToken, token1=" + testToken+ ", token1=" + testToken2;
	}
	
	
}
