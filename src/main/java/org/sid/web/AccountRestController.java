package org.sid.web;

import java.util.List;


import org.sid.entities.AppRole;
import org.sid.entities.AppUser;
import org.sid.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
@CrossOrigin("*")
@RestController
public class AccountRestController {
	@Autowired
	private AccountService accountService;
	
	@GetMapping(path="/users")
	public List<AppUser> appUsers(){
		
		return accountService.listUsers();
	}
	
	@PostMapping(path="/users")
	public AppUser saveUser(@RequestBody AppUser appUser ) {
		return accountService.addNewUser(appUser);
		
	}
	
	@PostMapping(path="/roles")
	public AppRole saveRole(@RequestBody AppRole appRole ) {
		return accountService.addNewRole(appRole);
		
	}
	
	@PostMapping(path="/addRoleToUser")
	public void saveRole(@RequestBody RoleUserForm roleUserForm) {
		accountService.addRoleToUser(roleUserForm.getUsername(), roleUserForm.getRoleName());
		
	}
	
	
	
	



@Data
class RoleUserForm{
	private String username;
	private String roleName;
	
}

}
