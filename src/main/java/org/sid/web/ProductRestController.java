
package org.sid.web;

import java.util.List;

import org.sid.entities.Image;
import org.sid.entities.Produit;
import org.sid.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	@PostMapping(path = "/produit")
	public Produit addproduct(@RequestBody Produit produit) {
		return productservice.addproduct(produit);
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

