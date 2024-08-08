package com.sodi9.common.cart;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sodi9.common.item.Item;
import com.sodi9.common.item.ItemRepository;
import com.sodi9.common.service.JwtService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController // This means that this class is a Controller
@RequestMapping(path = "/api/cart") // This means URL's start with /api (after Application path)
public class CartRestController {
	@Autowired
	JwtService jwtService;

	@Autowired
	CartRepository cartRepository;

	@Autowired
	ItemRepository itemRepository;

	@GetMapping
	public ResponseEntity getCartItems(@CookieValue(value = "token", required = false) String token) {

		if (!jwtService.isValid(token)) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}

		int memberId = jwtService.getId(token);
		List<Cart> carts = cartRepository.findByMemberId(memberId);
		List<Integer> itemIds = carts.stream().map(Cart::getItemId).toList();
		List<Item> items = itemRepository.findByIdIn(itemIds);

		return new ResponseEntity<>(items, HttpStatus.OK);
	}

	
	
	private String getCookieValue(HttpServletRequest req, String cookieName) {
	    return Arrays.stream(req.getCookies())
	            .filter(c -> c.getName().equals(cookieName))
	            .findFirst()
	            .map(Cookie::getValue)
	            .orElse(null);
	}
	
	
	@PostMapping("{itemId}")
	public ResponseEntity pushCartItem(
			@PathVariable("itemId") int itemId,
			@CookieValue(value = "token", required = false) String token,
			@CookieValue(value = "JSESSIONID", required = false) String cookie,
			HttpServletRequest request) {

		log.info("itemId={}", itemId);
		log.info("cookie={}", cookie);
//		log.info("token cookie={}", getCookieValue(request, "token"));
		
		
		Cookie cookies[] = request.getCookies();
		Cookie cook;
		String uname = "", pass = "";
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cook = cookies[i];
				if (cook.getName().equalsIgnoreCase("loginPayrollUserName"))
					uname = cook.getValue();
				if (cook.getName().equalsIgnoreCase("loginPayrollPassword"))
					pass = cook.getValue();
			}
		}

		

		log.info("uname={}, pass={}", uname, pass);
		
		
		if (!jwtService.isValid(token)) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}

		int memberId = jwtService.getId(token);
		Cart cart = cartRepository.findByMemberIdAndItemId(memberId, itemId);

		if (cart == null) {
			Cart newCart = new Cart();
			newCart.setMemberId(memberId);
			newCart.setItemId(itemId);
			cartRepository.save(newCart);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/api/cart/items/{itemId}")
	public ResponseEntity removeCartItem(
			@PathVariable("itemId") int itemId,
			@CookieValue(value = "token", required = false) String token) {

		if (!jwtService.isValid(token)) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}

		int memberId = jwtService.getId(token);
		Cart cart = cartRepository.findByMemberIdAndItemId(memberId, itemId);

		cartRepository.delete(cart);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
