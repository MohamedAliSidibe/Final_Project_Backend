package org.sid.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  response.addHeader("Access-Control-Allow-Origin", "*");
		  response.addHeader("Access-Control-Allow-Headers",
		  "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers,authorization"
		  ); response.addHeader("Access-Control-Expose-Headers",
		  "Access-Control-Allow-Origin, Access-Control-Allow-Credentials, authorization"
		  ); response.addHeader("Access-Control-Allow-Methods",
		  "GET,POST,OPTIONS,DELETE,PUT");
		  
		  if(request.getMethod().equals("OPTIONS")){
	            response.setStatus(HttpServletResponse.SC_OK);
	        }
		  
		  
		
			 
		  
			
			  else if(request.getRequestURI().equals("/users")) {
			  System.out.println("lllllllllllllllllll"); filterChain.doFilter(request,
			  response); return; } 
			  
			
			 
			
			  else if(request.getRequestURI().equals("/login")) {
			  filterChain.doFilter(request, response); 
			  return; 
			  }
			 
			
			  else if(request.getRequestURI().equals("/produit")) {
			  System.out.println("ddddddddddddddddd"); filterChain.doFilter(request,
			  response); return; }
		  
			  else if(request.getRequestURI().equals("/produit/{category}")) {
				  System.out.println("ddddddddddddddddd"); filterChain.doFilter(request,
				  response); return; }
	      
			  else if(request.getRequestURI().equals("/category")) {
				  System.out.println("ddddddddddddddddd"); filterChain.doFilter(request,
				  response); return; }
		  
			  else if (request.getRequestURI().matches("^/produit/(.*)$")) {
				    String category = request.getRequestURI().replaceAll("^/produit/", "");
				    System.out.println("Category : " + category);
				    filterChain.doFilter(request, response);
				    return;
				}
			  else if (request.getRequestURI().matches("^/delete/(.*)$")) {
				    String delete = request.getRequestURI().replaceAll("^/delete/", "");
				    System.out.println("delete : " +delete);
				    filterChain.doFilter(request, response);
				    return;
				}
			  else if (request.getRequestURI().matches("^/view_product/(.*)$")) {
				    String view = request.getRequestURI().replaceAll("^/view_product/", "");
				    System.out.println("view : " +view);
				    filterChain.doFilter(request, response);
				    return;
				}
			  else if (request.getRequestURI().matches("^/edit_product/(.*)$")) {
				    String edit = request.getRequestURI().replaceAll("^/edit_product/", "");
				    System.out.println("edit : " +edit);
				    filterChain.doFilter(request, response);
				    return;
				}
	        else {
		 
		String authorizationToken=request.getHeader("Authorization");
		System.out.println(authorizationToken);
		if(authorizationToken!=null && authorizationToken.startsWith("Bearer ")) {
			
			try {
			String Jwt=authorizationToken.substring(7);
			Algorithm algorithm=Algorithm.HMAC256("mySecret1234");
			JWTVerifier jWTverifier=JWT.require(algorithm).build();
			DecodedJWT decodeJWT=jWTverifier.verify(Jwt);
			String username=decodeJWT.getSubject();
			String [] roles=decodeJWT.getClaim("roles").asArray(String.class);
			Collection <GrantedAuthority> authorities=new ArrayList<>();
			 for (String r:roles) {
				 authorities.add(new SimpleGrantedAuthority(r));
			 }
			 
			 UsernamePasswordAuthenticationToken authenticationToken=
					 new UsernamePasswordAuthenticationToken(username,null,authorities);
			 
			 SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			 filterChain.doFilter(request, response);
				
			}
			catch(Exception e) {
				response.setHeader("error-message", e.getMessage());
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
				
				
			}
			
			
			
			
			
		}
	        }
	
		
	}

}
