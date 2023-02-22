package org.sid.services;

import java.util.List;

import org.sid.entities.Produit;

public interface ProductService {
	 Produit add_product(Produit product);
	 List<Produit> listproduit();

}
