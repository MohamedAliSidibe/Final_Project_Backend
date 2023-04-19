package org.sid.services;

import java.util.List;

import org.sid.entities.Category;
import org.sid.entities.Image;
import org.sid.entities.Produit;

public interface ProductService {
	 Produit addproduct(Produit product);
	 Image addimage(Image image);
	 void addCategory();
	 List<Produit> Allproduit();
	 List<Image> Allimage();
	 List<Produit> listcategoryname(String category);
	 List<Category> Allcategory();
	 void addImgToproduct(int ref,String images);
	 void supprimer_product(int ref);
	 void edit_product(Produit produit,int ref);
	 Produit view_product(int ref);

}