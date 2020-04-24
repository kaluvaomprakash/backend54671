package com.luv2code.springdemo.dao;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


public class token_creation_validation {
//	public static void main(String[] args) {
//		//System.out.println(new hackersDaoimp().hackerLoginCheck("9848966970", "54671"));
//	}
	private static byte[] secret = Base64.getDecoder().decode("cHJha2FzaEA1NDY3MXByYWthc2hANTQ2NzFwcmFrYXNoQDU0NjcxcHJha2FzaEA1NDY3MQ==");
	
	
	public String creation(String mobilenumber,int hackerId) {
		
		//GETTING CURRENT TIME
		Instant now = Instant.now();
		
           String jwt=	Jwts.builder()
		  .setSubject("jwt").
		  setAudience("kaluva").
		  setIssuedAt(Date.from(now)).
		  claim("mobileNumber", mobilenumber).
		  claim("id",hackerId)
		//setting expire time for one day of token
		.setExpiration(Date.from(now.plus(1,ChronoUnit.DAYS)))
		.signWith(Keys.hmacShaKeyFor(secret))		
		.compact();
      // System.out.println(jwt);		
		return jwt;
	}
	
	
	public int validate_token(String token) {
	   Jws<Claims> tokenParse =  (Jws<Claims>) Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
	   System.out.println("in token validate "+tokenParse.getBody().get("id")+" "+token);
   	    return (int) tokenParse.getBody().get("id");
	}
}
