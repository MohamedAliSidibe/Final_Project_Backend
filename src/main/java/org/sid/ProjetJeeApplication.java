package org.sid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.sid.dao.CategoryRepository;
import org.sid.dao.ImageRepository;
import org.sid.dao.ProduitRepository;
import org.sid.entities.Category;
import org.sid.entities.Image;
import org.sid.entities.Produit;

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
	
			
			
		
			productservice.addCategory();
			Category A;
			Category C;
			Category D;
			Category E;
			Category F;
			List <String> L=new ArrayList<>();
			
			Category B=catrep.findByName("Sacs");
			
			
			L.add("Sacs Normale 1");
			L.add("Sacs Normale");
			L.add("Sacs II");
			L.add("Sacs normale");
			L.add("Sacs classique");
			L.add("Sac Classique 4");
			L.add("Sac Normale 3");
			L.add("Sacs Classique 2");
			
			
			
			
			
			for(int i=1;i<=8;i++) {
				 productservice.addimage(new Image(null,"SA"+i+".jpg"));
				 productservice.addimage(new Image(null,"SA"+i+i+".jpg"));
				 productservice.addproduct(new Produit(null,null,5668,L.get(i-1),B.getName(),null));
				 productservice.addImgToproduct(i,"SA"+i+".jpg");
				 productservice.addImgToproduct(i,"SA"+i+i+".jpg");
			}
			
			List <String> L1=new ArrayList<>();
			A=catrep.findByName("Lunettes");
			
			L1.add("Casquette pret");
			L1.add("Casquette classique");
			L1.add("Casquette solile");
			L1.add("Casquette normal");
			L1.add("Casquette");
			L1.add("Casquette normal");
			L1.add("Casquette sport tennis");
			L1.add("Casquette sport 2");
			
			
			
			
			
			
			for(int i=1;i<=8;i++) {
				 productservice.addimage(new Image(null,"ca"+i+".jpg"));
			     productservice.addimage(new Image(null,"ca"+i+i+".jpg"));
				 productservice.addproduct(new Produit(null,null,5668,L1.get(i-1),A.getName(),null));
				 productservice.addImgToproduct(i+8,"ca"+i+".jpg");
				 productservice.addImgToproduct(i+8,"ca"+i+i+".jpg");
			}
			
			
			
			List <String> L2=new ArrayList<>();
			C=catrep.findByName("Talons");
			
			L2.add("Talon Normale");
			L2.add("Talon classique");
			L2.add("Sandales à talons hauts");
			L2.add("Sandales à talons hauts turk");
			L2.add("Talon Normale 2");
			L2.add("Talon super aslk");
			L2.add("Talon Normale 5");
			L2.add("Talon classique 4");
			L2.add("Talon Normale 5");
			
			
			
			
			
			
			for(int i=1;i<=9;i++) {
				 productservice.addimage(new Image(null,"T"+i+".jpg"));
			     productservice.addimage(new Image(null,"T"+i+i+".jpg"));
				 productservice.addproduct(new Produit(null,null,5668,L2.get(i-1),A.getName(),null));
				 productservice.addImgToproduct(i+16,"T"+i+".jpg");
				 productservice.addImgToproduct(i+16,"T"+i+i+".jpg");
			}
			
			
			
			List <String> L3=new ArrayList<>();
			D=catrep.findByName("TShirts");
			
			L3.add("TShirt pret");
			L3.add("T-shirt de base");
			L3.add("UNISEXE-ImprimerT-shirt");
			L3.add("TShirt pret");
			L3.add("UNISEX -T-shirt basique");
			L3.add("TShirt sport");
			L3.add("TShirt classique");
			L3.add("TShirt sport foot-balle");
			L3.add("TShirt sport");
			
			
			
			
			
			
			for(int i=1;i<=9;i++) {
				 productservice.addimage(new Image(null,"TS"+i+".jpg"));
			     productservice.addimage(new Image(null,"TS"+i+i+".jpg"));
				 productservice.addproduct(new Produit(null,null,5668,L3.get(i-1),D.getName(),null));
				 productservice.addImgToproduct(i+25,"TS"+i+".jpg");
				 productservice.addImgToproduct(i+25,"TS"+i+i+".jpg");
			}
			
			
			
			List <String> L4=new ArrayList<>();
			E=catrep.findByName("Chaussettes");
			
			L4.add("Chaussette Normale");
			L4.add("CHAUSSETTES REMBOURRÉES TRÈFLE 3");
			L4.add("Chaussette normale");
			L4.add("CHAUSSETTES REMBOURRÉES TRÈFLE 2");
			L4.add("CHAUSSETTES REMBOURRÉES TRÈFLE ");
			L4.add("Chaussette classique");
			L4.add("Chaussette sport hand-balle");
			L4.add("Chaussette sport foot-balle");
			L4.add("Chaussette sport 3");
			
			
			
			
			
			
			for(int i=1;i<=9;i++) {
				 productservice.addimage(new Image(null,"CH"+i+".jpg"));
			     productservice.addimage(new Image(null,"CH"+i+i+".jpg"));
				 productservice.addproduct(new Produit(null,null,5668,L4.get(i-1),E.getName(),null));
				 productservice.addImgToproduct(i+34,"CH"+i+".jpg");
				 productservice.addImgToproduct(i+34,"CH"+i+i+".jpg");
			}
			
			
		
			
			
			
			
			
			
			

			 
			
			
			
			
			
			
			
			
			
			
			
			
			/*
			 * productservice.addproduct(new
			 * Produit(null,null,5668,"Pantalon",A.getName(),null));
			 * 
			 * productservice.addproduct(new
			 * Produit(null,null,5668,"Pantalon",A.getName(),null));
			 * 
			 * 
			 * productservice.addimage(new Image(null,"Img1.jpg"));
			 * productservice.addimage(new Image(null,"Img11.jpg"));
			 * 
			 * productservice.addimage(new Image(null,"Img2.jpg"));
			 * productservice.addimage(new Image(null,"Img22.jpg"));
			 * 
			 * productservice.addImgToproduct(1,"Img.jpg");
			 * productservice.addImgToproduct(1,"Img1.jpg");
			 * 
			 * productservice.addImgToproduct(2,"Img2.jpg");
			 * productservice.addImgToproduct(2,"Img22.jpg");
			 */
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
