package org.sid.services;

import java.util.List;

import org.sid.dao.AppRoleRepository;
import org.sid.dao.AppUserRepository;
import org.sid.entities.AppRole;
import org.sid.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AccountServiceImp implements AccountService {
	@Autowired
	private AppRoleRepository appRoleRepo;
	@Autowired
	private AppUserRepository appUserRepo;
	@Autowired
	private  PasswordEncoder passwordEncoder;
	
	

	@Override
	
	public AppUser addNewUser(AppUser appUser) {
		// TODO Auto-generated method stub
		String pw=appUser.getPassword();
		
		appUser.setPassword(passwordEncoder.encode(pw));
		appUserRepo.save(appUser);
		
		addRoleToUser(appUser.getName(),"USER");
		
		return null;
		
	}

	@Override
	public AppRole addNewRole(AppRole appRole) {
		// TODO Auto-generated method stub
		
		return appRoleRepo.save(appRole);
	}

	@Override
	public void addRoleToUser(String userName, String roleName) {
		// TODO Auto-generated method stub
		AppUser appUser=appUserRepo.findByName(userName);
		
		AppRole appRole=appRoleRepo.findByName(roleName);
		
		appUser.getAppRoles().add(appRole);
		
	}

	@Override
	public AppUser loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		return  appUserRepo.findByName(username);
	}

	@Override
	public List<AppUser> listUsers() {
		// TODO Auto-generated method stub
		return appUserRepo.findAll();
	}
}
