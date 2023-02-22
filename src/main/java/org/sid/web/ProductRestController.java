package org.sid.web;

import java.util.List;


import org.sid.entities.Produit;
import org.sid.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {
	@Autowired
	private ProductService productservice;
	
	@GetMapping(path="/produit")
	public List<Produit> listproduit(){
		return productservice.listproduit();
	}
	@PostMapping(path = "/produit")
	public Produit addproduct(@RequestBody Produit produit) {
		return productservice.add_product(produit);
	}

}
