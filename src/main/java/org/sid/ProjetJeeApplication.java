package org.sid;

import java.util.ArrayList;

import org.sid.entities.Produit;
import org.sid.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetJeeApplication implements CommandLineRunner {

	@Autowired
	ProductService productservice;
	public static void main(String[] args) {
		SpringApplication.run(ProjetJeeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productservice.add_product(new Produit(
				null,"p1","Product1",5668,"Pantalon",null,new ArrayList<>()));
	}

}
