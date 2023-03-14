package org.sid.dao;

import org.sid.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface ImageRepository extends JpaRepository<Image, Long>{
	Image findByImageName(String image);

}
