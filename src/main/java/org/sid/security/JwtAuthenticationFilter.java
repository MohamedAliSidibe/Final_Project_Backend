package org.sid.security;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.sid.entities.AppUser;

public class JwtAuthenticationFilter  extends UsernamePasswordAuthenticationFilter {
	
	
	private AuthenticationManager authenticationManager;
	
	public JwtAuthenticationFilter(AuthenticationManager authenticationManagerBean) {
		System.out.println("JwtAuthenticationFilter");
	   this.setFilterProcessesUrl("/login"); 
	   this.authenticationManager=authenticationManagerBean;
	}

	
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		
		try {
            AppUser user= new ObjectMapper().readValue(request.getInputStream(),AppUser.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword()));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
		
		
		
		
		
		
		
       /* System.out.println("attemptAuthentication");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		
		UsernamePasswordAuthenticationToken authenticationToken=new 
				UsernamePasswordAuthenticationToken(username,password);
		return authenticationManager.authenticate(authenticationToken);	*/
		
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("successfulAuthentication");
		System.out.println("ftttttttttttttaaaaaaaaaaaaaaagggggggoooooooo");
		//permet de retourner l'utilisateur authentifié getPrincipal()
		User user=(User) authResult.getPrincipal();

		Algorithm algo1=Algorithm.HMAC256("mySecret1234");
		String JwtAccessToken=JWT.create()
				.withSubject(user.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis()+5*60*1000))
				.withIssuer(request.getRequestURI().toString())
				.withClaim("roles",user.getAuthorities().stream().map(ga->ga.getAuthority()).collect(Collectors.toList()))
				.sign(algo1);
		
		
		/*
		 * String JwtRefrechToken=JWT.create() .withSubject(user.getUsername())
		 * .withExpiresAt(new Date(System.currentTimeMillis()+15*60*1000))
		 * .withIssuer(request.getRequestURI().toString()) .sign(algo1);
		 */
		
		response.setHeader("Authorization",JwtAccessToken);
		
		/*
		 * Map<String,String> idToken=new HashMap<>(); idToken.put("access-token",
		 * JwtRefrechToken);
		 * 
		 * idToken.put("refresh-token", JwtAccessToken);
		 * 
		 * response.setContentType("application/json");
		 */
				
				
	}
	
	
	

}
