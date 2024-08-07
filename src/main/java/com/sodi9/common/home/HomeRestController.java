package com.sodi9.common.home;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sodi9.common.member.Member;
import com.sodi9.common.member.MemberRepository;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController // This means that this class is a @RestController
//@RequestMapping(path = "/api") // This means URL's start with /api (after Application path)
public class HomeRestController {
	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private HomeRepository homeRepository;

	@Autowired // This means to get the bean called MemberRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private MemberRepository memberRepository;

	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private JwtService jwtService;

	public void addCookie(HttpServletResponse res, String name, String value, int hour) {
		ResponseCookie cookie = 
				ResponseCookie
				.from(name, value)
				
//				.path("/")
//				.sameSite("None") // 이거 세팅 하면 쿠키가 application 텝에 안남음????????
				
				
				
//				.sameSite("Lax") // 해도 되고 안해도 쿠키 잘남음
//				.httpOnly(true)
//				.secure(true)
				
//				.httpOnly(false)
//				.secure(false)
//				.maxAge(Duration.ofHours(hour))
//				.maxAge(hour)
				.build();

		res.addHeader("Set-Cookie", cookie.toString());
//		res.setHeader(HttpHeaders.SET_COOKIE, cookie.toString());
	}
	
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

//	  @GetMapping(produces = "text/plain")
	@GetMapping("/cookie")
	public String demo(HttpServletResponse res) {

		// Building cookies
//		ResponseCookie cookie = ResponseCookie.from("myCookie333", "myCookieValue") // key & value
//				.httpOnly(true)
//		    	.secure(false)
//				// .domain("localhost") // host
//				// .path("/") // path
//				.maxAge(Duration.ofHours(1))
//				.sameSite("Lax") // sameSite
//				.build();
//		// Response to the client
//		res.setHeader(HttpHeaders.SET_COOKIE, cookie.toString());

		addCookie(res, "token",  "myCookixxxxxxxxxxeValue1", 365 * 24 * 60 * 60);// 365day
		return "ok";
	}

	@RequestMapping("/token")
	public Map<String, String> token(HttpSession session) {
		return Collections.singletonMap("token", session.getId());
	}

	@PostMapping("/auth/login")
	public ResponseEntity<Integer> login(
//			HttpSession session, 
			@RequestBody Map<String, String> params, HttpServletResponse res) {

		Member member = memberRepository.findByEmailAndPassword(params.get("email"), params.get("password"));
		if (member != null) {
			Integer id = member.getId();
			String token = jwtService.getToken("id", id);

//            Cookie cookie = new Cookie("token", token);
//            cookie.setSecure(true);
//            cookie.setHttpOnly(true);
//            cookie.setPath("/");
//            int maxAge = 1000 * 60 * 30;// 30분
//            int maxAge = 120;// 30분
//			cookie.setMaxAge(maxAge );
//			cookie.setMaxAge(60 * 60);  // 쿠키 유효 시간 : 1시간
			// expires in 7 days
//		    cookie.setMaxAge(7 * 24 * 60 * 60);
//            res.addCookie(cookie);

			addCookie(res, "token", token, 7 * 24 * 60 * 60);

//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Set-Cookie","key="+"value");

//            HttpCookie cookie2 = ResponseCookie.from("token", token)
//                    .path("/")
//                    .build();

//            ResponseEntity.status(HttpStatus.OK).headers(headers).build();

//            return ResponseEntity.ok()
//            .header(HttpHeaders.SET_COOKIE, cookie2.toString())
//            .body(id);
//            return new ResponseEntity<>(id, HttpStatus.OK);

//			return member.getId();
//            return new ResponseEntity<Integer>(id,headers, HttpStatus.OK);

			return ResponseEntity.ok().build();
		}

		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}


	@PostMapping("/auth/signup")
	public int signup(
//			HttpSession session, 
			@RequestBody Map<String, String> params) {

		Member member = memberRepository.findByEmailAndPassword(params.get("email"), params.get("password"));
		if (member != null) {
			return member.getId();
		}

		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//		return 0;
//		return Collections.singletonMap("token", session.getId());
	}

	@PostMapping("/api/logout")
	public ResponseEntity logout(HttpServletResponse res) {
		Cookie cookie = new Cookie("token", null);
//        cookie.setPath("/");
		cookie.setMaxAge(0);
		res.addCookie(cookie);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/api/check")
	public ResponseEntity check(@CookieValue(value = "token", required = false) String token) {
		Claims claims = jwtService.getClaims(token);

		if (claims != null) {
			int id = Integer.parseInt(claims.get("id").toString());
			return new ResponseEntity<>(id, HttpStatus.OK);
		}

		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
