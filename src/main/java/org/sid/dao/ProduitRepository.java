package org.sid.dao;

import java.util.List;

import org.sid.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Produit,Long> {

	
	Produit findByName(String name);
	Produit findByRef(int ref);
	List<Produit> findByCategoryname(String category);

}