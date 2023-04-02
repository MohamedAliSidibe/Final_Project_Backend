package org.sid.dao;

import java.util.Optional;

import org.sid.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;




public interface AppUserRepository extends JpaRepository<AppUser,Long> {
	AppUser findByName(String name);
	//boolean existsByEmail(String name);
}
