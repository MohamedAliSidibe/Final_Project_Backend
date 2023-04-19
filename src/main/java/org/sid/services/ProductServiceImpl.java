package org.sid.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.sid.dao.CategoryRepository;
import org.sid.dao.ImageRepository;
import org.sid.dao.ProduitRepository;
import org.sid.entities.Category;
import org.sid.entities.Image;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductServiceImpl  implements ProductService{
	 
	@Autowired
	ProduitRepository produitrep;
	@Autowired
	ImageRepository imgrep;
	@Autowired
	CategoryRepository catrep;
	
	@Override
	public Produit addproduct(Produit product) {
		return produitrep.save(product);
	}
	@Override
	public List<Produit> Allproduit() {
		// TODO Auto-generated method stub
		List<Produit> L=new ArrayList<>();
		 produitrep.findAll().forEach(p->{
		  String l=  String.valueOf(p.getRef()); 
		  p.setId("p"+l);

		  p.setName("Product"+l);
		  L.add(p);
		  System.out.println(p.getId());

		});;
		return L;
	}
	@Override
	public Image addimage(Image image) {
		// TODO Auto-generated method stub
		return imgrep.save(image);
	}
	@Override
	public void addImgToproduct(int ref, String images) {
		// TODO Auto-generated method stub
		Produit p=produitrep.findByRef(ref);
		Image i=imgrep.findByImageName(images);
		p.getImages().add(i);
		System.out.println("me");
	}
	@Override
	public void addCategory() {
		// TODO Auto-generated method stub
		Stream.of("Pantalons","Robes","Casquettes","Manteaux",
				"Lunettes","Sacs","Talons","TShirts","Chaussettes").forEach(cat->{
			Category categorie=new Category();
			categorie.setNameCat(cat);
			catrep.save(categorie);
		});
		
	}
	@Override
	public List<Image> Allimage() {
		// TODO Auto-generated method stub
		return imgrep.findAll();
	}
	@Override
	public List<Produit> listcategoryname(String category) {
		// TODO Auto-generated method stub
		
		return produitrep.findByCategoryname(category);
	}
	@Override
	public List<Category> Allcategory() {
		// TODO Auto-generated method stub
		return catrep.findAll();
	}
	@Override
	public void supprimer_product(int ref) {
		// TODO Auto-generated method stub
		Produit p=produitrep.findByRef(ref);
		produitrep.delete(p);
	}
	@Override
	public void edit_product(Produit produit,int ref) {
	    Produit prod_ref = produitrep.findByRef(ref);
	    //System.out.println(prod_ref.getRef());
	    if (prod_ref != null) {
	        prod_ref.setId(produit.getId());
	        prod_ref.setName(produit.getName());
	        prod_ref.setPrice(produit.getPrice());
	        prod_ref.setDescription(produit.getDescription());
	       // prod_ref.setCategory(produit.getCategory());
	        prod_ref.setCategoryname(produit.getCategoryname());
	        //prod_ref.setImages(produit.getImages());
	        produitrep.save(prod_ref);
	    }
	}
	@Override
	public Produit view_product(int ref) {
		// TODO Auto-generated method stub
		Produit prod=produitrep.findByRef(ref);
		return prod;
	}

	

}