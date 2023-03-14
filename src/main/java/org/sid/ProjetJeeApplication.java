package org.sid;

import java.util.ArrayList;
import java.util.Iterator;

import org.sid.dao.CategoryRepository;
import org.sid.dao.ImageRepository;
import org.sid.dao.ProduitRepository;
import org.sid.entities.Category;
import org.sid.entities.Image;
import org.sid.entities.Produit;
import org.sid.service.AccountService;
import org.sid.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjetJeeApplication {

	
	 // @Autowired ProductService productservice;
	 
	  @Autowired 
	  CategoryRepository catrep;
	  @Autowired
	  ProduitRepository prd;
	  @Autowired
	  ImageRepository im;
	public static void main(String[] args) {
		SpringApplication.run(ProjetJeeApplication.class, args);
	}

	    @Bean
		CommandLineRunner start(ProductService productservice) {
		return args->{
	
			
//			  productservice.addproduct(new
//			  Produit(null,"p1","Product1",5668,"Pantalon",null,new ArrayList<>()));
//			  productservice.addimage(new Image(null,"Img.jpg"));
//			  productservice.addimage(new Image(null,"Img1.jpg"));
//			  productservice.addImgToproduct("p1","Img.jpg");
//			  productservice.addImgToproduct("p1","Img1.jpg");
			 
			//System.out.println("ggg"+im.findByImageName("J1.jpg").getImageName()); 
			//productservice.addImgToproduct("p1","M1.jpg");
		//productservice.addCategory();
		
			/*
			 * Category c1=catrep.findByName("Pantalons"); productservice.addproduct(new
			 * Produit(null,"p1","Product1",5668,"Pantalon",c1,new ArrayList<>())); Category
			 * c2=catrep.findByName("Talons"); productservice.addproduct(new
			 * Produit(null,"p2","Product2",8668,"Talons",c2,new ArrayList<>())); Category
			 * c3=catrep.findByName("TShirts"); productservice.addproduct(new
			 * Produit(null,"p3","Product3",19668,"TShirts",c3,new ArrayList<>())); Category
			 * c4=catrep.findByName("Casquettes"); productservice.addproduct(new
			 * Produit(null,"p4","Product4",56868,"Casquettes",c4,new ArrayList<>()));
			 * Category c5=catrep.findByName("Robes"); productservice.addproduct(new
			 * Produit(null,"p5","Product5",13668,"Robes",c5,new ArrayList<>())); Category
			 * c6=catrep.findByName("Sacs"); productservice.addproduct(new
			 * Produit(null,"p6","Product6",56668,"Sacs",c6,new ArrayList<>())); Category
			 * c7=catrep.findByName("Manteaux"); productservice.addproduct(new
			 * Produit(null,"p7","Product7",85668,"Manteaux",c7,new ArrayList<>()));
			 * Category c8=catrep.findByName("Chaussettes"); productservice.addproduct(new
			 * Produit(null,"p8","Product8",54668,"Chaussettes",c8,new ArrayList<>()));
			 * Category c9=catrep.findByName("Lunettes"); productservice.addproduct(new
			 * Produit(null,"p9","Product9",56968,"Lunettes",c9,new ArrayList<>()));
			 * 
			 * for (int i = 1; i <=1 ; i++) { for (int j = 1; j <=1; j++) {
			 * System.out.println(j); productservice.addimage(new Image(null,"J"+i+".jpg"));
			 * productservice.addimage(new Image(null,"J"+i+""+j+".jpg"));
			 * productservice.addimage(new Image(null,"T"+i+".jpg"));
			 * productservice.addimage(new Image(null,"T"+i+""+j+".jpg"));
			 * productservice.addimage(new Image(null,"S"+i+".jpg"));
			 * productservice.addimage(new Image(null,"S"+i+""+j+".jpg"));
			 * productservice.addimage(new Image(null,"R"+i+".jpg"));
			 * productservice.addimage(new Image(null,"R"+i+""+j+".jpg"));
			 * productservice.addimage(new Image(null,"M"+i+".jpg"));
			 * productservice.addimage(new Image(null,"M"+i+""+j+".jpg"));
			 * productservice.addimage(new Image(null,"L"+i+".jpg"));
			 * productservice.addimage(new Image(null,"L"+i+""+j+".jpg"));
			 * productservice.addimage(new Image(null,"TS"+i+".jpg"));
			 * productservice.addimage(new Image(null,"TS"+i+""+j+".jpg"));
			 * productservice.addimage(new Image(null,"ca"+i+".jpg"));
			 * productservice.addimage(new Image(null,"ca"+i+""+j+".jpg"));
			 * productservice.addimage(new Image(null,"CH1"+i+".jpg")); }
			 * 
			 * }
			 */
		  
		//	productservice.addImgToproduct("p1","J11.jpg");
		 
		//catrep.findAll().forEach(c->{
			//productservice.addproduct(new Produit(null,"p1","Product1",5668,"Pantalon",c,new ArrayList<>()));
		//});
	     //catrep.findById((long)1).toString();
		
	};

}
}
