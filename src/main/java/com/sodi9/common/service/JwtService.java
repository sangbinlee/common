package com.sodi9.common.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Service("jwtService")
@Slf4j
public class JwtService {

	
	private String secretKey = "abbci2ioadijai17a662813918ausudahd178316738687687ad6g";// 

	public static void main(String[] args) {

		String secretKey = "abbci2ioadij@@@ai17a662###8139!!!18ausudahd178316738687687@@ad6g";
		System.out.println("key=" + Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey)));
	}

	private SecretKey getSecretKey() {
		log.info("22222 secretKey={}", secretKey);
//		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
//		byte[] secretByteKey = DatatypeConverter.parseBase64Binary(secretKey);
//		Key signKey = new SecretKeySpec(secretByteKey, SignatureAlgorithm.HS256.getJcaName());
//		SecretKey key = Jwts.SIG.HS256.key().build();

		SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
		return key;

//		String secretString = Encoders.BASE64.encode(key.getEncoded());

	}

	public String getToken(String key, Object value) {

		Date nowDate = new Date();
		Date expTime = new Date();
		expTime.setTime(expTime.getTime() + 1000 * 60 * 30);// 30분

		Map<String, Object> headerMap = new HashMap<>();
		headerMap.put("typ", "JWT");
		headerMap.put("alg", "HS256");

		Map<String, Object> map = new HashMap<>();
		map.put(key, value);

//		JwtBuilder builder = Jwts.builder()
//				.subject("subject")
//				.claims(map)
//				.issuedAt(nowDate)
//				.expiration(expTime)
//				.signWith(getSecretKey());
//		return builder.compact();
		String jws = Jwts.builder()
				.subject("subject")
				.claims(map)
				.issuedAt(nowDate)
				.expiration(expTime)
				.signWith(getSecretKey()).compact();
		log.info("########### jws={}", jws);
		return jws;
	}

	public Claims getClaims(String token) {
		if (token != null && !"".equals(token)) {
			try {
				return Jwts.parser().verifyWith(getSecretKey()).build().parseSignedClaims(token).getPayload();
			} catch (ExpiredJwtException e) {
				// 만료됨
			} catch (JwtException e) {
				// 유효하지 않음
			}
		}

		return null;
	}

	public boolean isValid(String token) {
		return this.getClaims(token) != null;
	}

	public int getId(String token) {
		Claims claims = this.getClaims(token);

		if (claims != null) {
			return Integer.parseInt(claims.get("id").toString());
		}

		return 0;
	}
}
