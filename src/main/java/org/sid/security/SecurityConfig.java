package org.sid.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.sid.services.AccountService;
import org.sid.entities.AppUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
















/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
*/











@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AccountService accountService;
	
	
	
	  @Override
	    public void configure(AuthenticationManagerBuilder auth) throws Exception {
	     //  auth.userDetailsService(userDetailsService());
		  System.out.println("SecurityConfig .configure(AuthenticationManagerBuilder auth");
			auth.userDetailsService(new UserDetailsService() {

				@Override
				public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
					// TODO Auto-generated method stub
					 AppUser appUser=accountService.loadUserByUsername(username);
				      List<GrantedAuthority> authorites=new ArrayList<>();
				      
					appUser.getAppRoles().forEach(r->{
						authorites.add(new SimpleGrantedAuthority(r.getName()));
					});
						
					return new User(appUser.getName(),appUser.getPassword(),authorites);
				}
			});
	    }
	  
	  @Override
		protected void configure(HttpSecurity http) throws Exception {
			// TODO Auto-generated method stub
			/*
			 * http.csrf().disable(); http.authorizeRequests().anyRequest().permitAll();
			 * http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.
			 * STATELESS); http.headers().frameOptions().disable();
			 * //http.authorizeRequests().antMatchers("/produit/**").permitAll(); //
			 * http.authorizeRequests().antMatchers(HttpMethod.GET,"/produit/**").permitAll(
			 * );
			 * 
			 * 
			 * http.addFilter(new JwtAuthenticationFilter(authenticationManagerBean()));
			 * 
			 * 
			 * http.addFilterBefore(new
			 * JwtAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
			 */
		  
		  
			/*
			 * http .authorizeRequests() .antMatchers("/produit/**").permitAll() // autorise
			 * l'accès à l'URL commençant par "/public"
			 * .antMatchers("/admin/**").hasRole("ADMIN") // autorise l'accès à l'URL
			 * commençant par "/admin" uniquement aux utilisateurs ayant le rôle "ADMIN"
			 * .anyRequest().authenticated() // autorise l'accès à toutes les autres URL
			 * uniquement aux utilisateurs authentifiés .and() .formLogin()
			 * .loginPage("/login").permitAll() // autorise l'accès à la page de connexion
			 * "/login" .and() .logout() .permitAll();
			 * 
			 * 
			 * http.addFilter(new JwtAuthenticationFilter(authenticationManagerBean()));
			 * 
			 * 
			 * http.addFilterBefore(new
			 * JwtAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
			 */
		  
		  
			    http.csrf().disable()
		        .authorizeRequests()
		            .antMatchers("/produit/**","/users/**").permitAll()
		            .anyRequest().authenticated()
		        .and()
		        .addFilter(new JwtAuthenticationFilter(authenticationManagerBean()))
		        .addFilterBefore(new
		   			 JwtAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class)
		        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		  
		  
		  
			/*
			 * http.csrf().disable();
			 * http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.
			 * STATELESS); http.headers().frameOptions().disable(); //ce recourse nécessaite
			 * pas une authentification
			 * http.authorizeRequests().antMatchers("/produit/**").permitAll(); //toutes les
			 * méthodes nécessaite une authentification
			 * //http.authorizeRequests().anyRequest().authenticated(); //afficher a
			 * l'utilisateur un formulaire quand il n'a pas le droit d'acceder a une
			 * ressource http.formLogin(); http.addFilter(new
			 * JwtAuthenticationFilter(authenticationManagerBean()));
			 * http.addFilterBefore(new
			 * JwtAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
			 */
				/*
				 * http.authorizeRequests().antMatchers("/login/**").permitAll();
				 * http.authorizeRequests().antMatchers("/users/**").permitAll();
				 */
			 
		    System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
			/*
			 * http.csrf().disable().sessionManagement().sessionCreationPolicy(
			 * SessionCreationPolicy.STATELESS); http.authorizeRequests()
			 * .antMatchers("/login","/produit/**","/client","/categories/**",
			 * "/client/verify","/paniers/**","/culasses/**","/lignePanierCommandes/**",
			 * "/clients/**") .permitAll() .anyRequest() .authenticated() .and()
			 * .formLogin() .loginPage("/login") .permitAll() .and() .logout() .permitAll();
			 */






		    
		    
		    
		    
		    
		    
		    
		    
		    
			
			/*
			 * http.csrf().disable().sessionManagement().sessionCreationPolicy(
			 * SessionCreationPolicy.STATELESS)
			 * .and().authorizeRequests().antMatchers("/login","/produit/**","/client",
			 * "/categories/**","/client/verify","/paniers/**","/culasses/**",
			 * "/lignePanierCommandes/**","/clients/**").permitAll().anyRequest().
			 * authenticated().and() .addFilter(new
			 * JwtAuthenticationFilter(authenticationManager())) .addFilterBefore(new
			 * JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
			 */
			 // http.authorizeRequests().anyRequest().authenticated();
			 
			/*
			 * http.csrf().disable().sessionManagement().sessionCreationPolicy(
			 * SessionCreationPolicy.STATELESS)
			 * .and().authorizeRequests().antMatchers("/login","/produit","/client",
			 * "/categories/**","/client/verify","/paniers/**","/culasses/**",
			 * "/lignePanierCommandes/**","/clients/**").permitAll().anyRequest().
			 * authenticated().and() .addFilter(new
			 * JwtAuthenticationFilter(authenticationManager())) .addFilterBefore(new
			 * JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
			 */
			 
		
			System.out.println("SecurityConfig .configure(HttpSecurity http)");
			
			// TODO Auto-generated method stub
			
	
			
			
		}
	  
	  

	  @Bean
	  @Override
	  public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
		  
	  }
	  
	 
		/*
		 * @Bean CorsConfigurationSource corsConfigurationSource() { CorsConfiguration
		 * configuration = new CorsConfiguration();
		 * configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		 * configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT",
		 * "DELETE")); configuration.setAllowedHeaders(Arrays.asList("Authorization",
		 * "Content-Type")); UrlBasedCorsConfigurationSource source = new
		 * UrlBasedCorsConfigurationSource(); source.registerCorsConfiguration("/**",
		 * configuration); return source; }
		 */
	
	  

}
