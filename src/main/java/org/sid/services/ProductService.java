package org.sid.services;

import java.util.List;

import org.sid.entities.Image;
import org.sid.entities.Produit;

public interface ProductService {
	 Produit addproduct(Produit product);
	 Image addimage(Image image);
	 void addCategory();
	 List<Produit> Allproduit();
	 void addImgToproduct(String ref,String images);

}
