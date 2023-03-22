package org.sid.services;

import java.util.List;

import org.sid.entities.AppRole;
import org.sid.entities.AppUser;



public interface AccountService {
	AppUser addNewUser(AppUser appUser);
	AppRole addNewRole(AppRole appRole);
	void addRoleToUser(String userName,String roleName);
	AppUser loadUserByUsername(String username);
	List<AppUser> listUsers();

}
