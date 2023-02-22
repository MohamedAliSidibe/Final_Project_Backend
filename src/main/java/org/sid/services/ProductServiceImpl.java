package org.sid.services;

import java.util.List;

import javax.transaction.Transactional;

import org.sid.dao.ProduitRepository;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductServiceImpl  implements ProductService{
	 
	@Autowired
	ProduitRepository produitrep;
	@Override
	public Produit add_product(Produit product) {
		return produitrep.save(product);
	}
	@Override
	public List<Produit> listproduit() {
		// TODO Auto-generated method stub
		return produitrep.findAll();
	}

}
