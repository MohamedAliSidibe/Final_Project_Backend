package org.sid.dao;

import org.sid.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
	AppRole findByName(String name);

}
