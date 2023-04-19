
package org.sid.web;

import java.util.List;

import org.sid.entities.Category;
import org.sid.entities.Image;
import org.sid.entities.Produit;
import org.sid.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@CrossOrigin("*")
@RestController
public class ProductRestController {
	@Autowired
	private ProductService productservice;
	
	@GetMapping(path="/produit")
	public List<Produit> listproduit(){
		return productservice.Allproduit();
	}
	@GetMapping(path="/view_product/{id}")
	public Produit viewproduit(@PathVariable int id){
		return productservice.view_product(id);
	}
	
	@GetMapping(path="/category")
	public List<Category> listcategory(){
		return productservice.Allcategory();
	}
	@GetMapping("/delete/{id}")
	  public void supprimer_product(@PathVariable int id) {
		 productservice.supprimer_product(id);
	    //return productservice.listcategoryname(category);
	  }
	 @GetMapping("/produit/{category}")
	  public List<Produit> getProduitsByCategory(@PathVariable String category) {
	    return productservice.listcategoryname(category);
	  }
	 
	@PostMapping(path = "/produit")
	public Produit addproduct(@RequestBody Produit produit) {
		return productservice.addproduct(produit);
	}
	
	@PostMapping(path = "/edit_product/{ref}")
	public void ediproduct(@RequestBody Produit produit,@PathVariable int ref) {
		System.out.println(ref);
		System.out.println(produit.getPrice());
		System.out.println(produit.getDescription());
		System.out.println(produit.getCategoryname());
		productservice.edit_product(produit,ref);
	}
	
	@GetMapping(path="/image")
	public List<Image> listimage(){
		return productservice.Allimage() ;
	}
	@PostMapping(path="/image")
	public Image saveImage(@RequestBody Image image){
		return productservice.addimage(image);
	}
	
	@PostMapping(path="/imagetoproduit")
	public void Image_ToProduit(@RequestBody ImageToProduit imagetoProduit){
		int ref=imagetoProduit.getRef();
		String img_name=imagetoProduit.getImageName();
		productservice.addImgToproduct(ref, img_name);	
	}
	
}
@Data
class ImageToProduit{
	private int ref;
	private String imageName;
}
