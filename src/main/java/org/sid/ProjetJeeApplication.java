package org.sid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.Random;

import org.sid.dao.CategoryRepository;
import org.sid.dao.ImageRepository;
import org.sid.dao.ProduitRepository;
import org.sid.entities.AppRole;
import org.sid.entities.AppUser;
import org.sid.entities.Category;
import org.sid.entities.Image;
import org.sid.entities.Produit;
import org.sid.services.AccountService;
import org.sid.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@SpringBootApplication
public class ProjetJeeApplication {

	
	 // @Autowired ProductService productservice;
	 
	  @Autowired 
	  CategoryRepository catrep;
	  @Autowired
	  ProduitRepository prd;
	  @Autowired
	  ImageRepository im;
	  @Autowired
	  AccountService accountService;
	  
	  
	public static void main(String[] args) {
		SpringApplication.run(ProjetJeeApplication.class, args);
	}
	
	

	    @Bean
		CommandLineRunner start(ProductService productservice) {
		return args->{
	
			

			 List<String> desp=new ArrayList<>();
			 desp.add("Pantalon pret");
			 desp.add("DATTERO PANTALONE - Pantalon");
			 desp.add("PANTALON YARA -Jeans décontractés");
			 desp.add("PANTALON YARA 2");
			 desp.add("PANTALON JEAN ");
			 desp.add("Pantalon Askal");
			 desp.add("Pantalon normale");
			 desp.add("Pantalon colaII");
			 desp.add("Pantalon classique");
			
			 Random rnd=new Random();
			 productservice.addCategory();
       
			Category c1=catrep.findByNameCat("Pantalons"); 
			desp.forEach(e->{
				System.out.println(e);
				productservice.addproduct(new Produit(null,null,100+rnd.nextInt(10000),e,c1,c1.getNameCat(),new ArrayList<>()));
				
				 
			});
			 
			 for (int i = 1; i <=9 ; i++) {
				  productservice.addimage(new Image(null,"Pantalons/j"+i+".jpg"));
				  productservice.addimage(new Image(null,"Pantalons/j"+i+""+i+".jpg"));
				
				  productservice.addImgToproduct(i,"Pantalons/j"+i+".jpg");
				  productservice.addImgToproduct(i,"Pantalons/j"+i+""+i+".jpg");
			 }
			 
			 List<String> robe=new ArrayList<>();
			 robe.add("Robe pret");
			 robe.add("OAKLIEIW ROBE COAT - Manteau classique");
			 robe.add("Robe turk");
			 robe.add("Robe classique Usa");
			 robe.add("Robe de cocktail ");
			 robe.add("Robe normal ");
			 robe.add("Robe classique matra");
			 robe.add("Robe zargos");
			 robe.add("Robe aletar");
			
      
			Category c2=catrep.findByNameCat("Robes"); 
			robe.forEach(e->{
				System.out.println(e);
				productservice.addproduct(new Produit(null,null,100+rnd.nextInt(10000),e,c2,c2.getNameCat(),new ArrayList<>()));
				
				 
			});
			 
			 for (int i = 1; i <=9 ; i++) {
				  productservice.addimage(new Image(null,"Robes/R"+i+".jpg"));
				  productservice.addimage(new Image(null,"Robes/R"+i+""+i+".jpg"));
				  productservice.addImgToproduct(i+9,"Robes/R"+i+".jpg");
				  productservice.addImgToproduct(i+9,"Robes/R"+i+""+i+".jpg");
			 }
			 List<String> manteau=new ArrayList<>();
			 manteau.add("Manteau pret");
			 manteau.add("ROBE FLORALE - Robe de chambre");
			 manteau.add("Manteau de chambre");
			 manteau.add("Manteau classique saragh ");
			 manteau.add("Manteau classique Awdkagh");
			 manteau.add("Manteau normale 2 ");
			 manteau.add("Manteau classique turk");
			 manteau.add("MANTEAU Simple");
			 manteau.add("Manteau Normale");
			
      
			Category c3=catrep.findByNameCat("Manteaux"); 
			manteau.forEach(e->{
				System.out.println(e);
				productservice.addproduct(new Produit(null,null,100+rnd.nextInt(10000),e,c3,c3.getNameCat(),new ArrayList<>()));
				
				 
			});
			 
			 for (int i = 1; i <=9 ; i++) {
				  productservice.addimage(new Image(null,"Manteau/M"+i+".jpg"));
				  productservice.addimage(new Image(null,"Manteau/M"+i+""+i+".jpg"));
				  productservice.addImgToproduct(i+18,"Manteau/M"+i+".jpg");
				  productservice.addImgToproduct(i+18,"Manteau/M"+i+""+i+".jpg");
			 }
			 
			 List<String> lunette=new ArrayList<>();
			 lunette.add("UNISEX - Lunettes de soleil");
			 lunette.add("Lunettes de soleil");
			 lunette.add("Lunette pret");
			 lunette.add("Lunettes de soleil 2");
			 lunette.add("Lunettes de soleil");
			 lunette.add("Lunette normale 4 ");
			 lunette.add("Lunette normale");
			 lunette.add("Lunettes de soleil");
			 lunette.add("Lunette classique");
			
      
			Category c4=catrep.findByNameCat("Lunettes"); 
			lunette.forEach(e->{
				System.out.println(e);
				productservice.addproduct(new Produit(null,null,100+rnd.nextInt(10000),e,c4,c4.getNameCat(),new ArrayList<>()));
				
				 
			});
			 
			 for (int i = 1; i <=9 ; i++) {
				  productservice.addimage(new Image(null,"Lunettes/L"+i+".jpg"));
				  productservice.addimage(new Image(null,"Lunettes/L"+i+""+i+".jpg"));
				  productservice.addImgToproduct(i+27,"Lunettes/L"+i+".jpg");
				  productservice.addImgToproduct(i+27,"Lunettes/L"+i+""+i+".jpg");
			 }

				Category A;
				Category C;
				Category D;
				Category E;
				Category F;
				List <String> L=new ArrayList<>();
				
				Category B=catrep.findByNameCat("Sacs");
				
				
				L.add("Sacs Normale 1");
				L.add("Sacs Normale");
				L.add("Sacs II");
				L.add("Sacs normale");
				L.add("Sacs classique");
				L.add("Sac Classique 4");
				L.add("Sac Normale 3");
				L.add("Sacs Classique 2");
				
				
				
				
				
				for(int i=1;i<=8;i++) {
					 productservice.addimage(new Image(null,"Sacs/SA"+i+".jpg"));
					 productservice.addimage(new Image(null,"Sacs/SA"+i+i+".jpg"));
					 productservice.addproduct(new Produit(null,null,100+rnd.nextInt(10000),L.get(i-1),B,B.getNameCat(),new ArrayList<>()));
					 productservice.addImgToproduct(i+9*4,"Sacs/SA"+i+".jpg");
					 productservice.addImgToproduct(i+9*4,"Sacs/SA"+i+i+".jpg");
				}
				List <String> L1=new ArrayList<>();
				A=catrep.findByNameCat("Casquettes");
				
				L1.add("Casquette pret");
				L1.add("Casquette classique");
				L1.add("Casquette solile");
				L1.add("Casquette normal");
				L1.add("Casquette");
				L1.add("Casquette normal");
				L1.add("Casquette sport tennis");
				L1.add("Casquette sport 2");
				
				
				
				
				
				
				for(int i=1;i<=8;i++) {
					 productservice.addimage(new Image(null,"Casquettes/ca"+i+".jpg"));
				     productservice.addimage(new Image(null,"Casquettes/ca"+i+i+".jpg"));
					 productservice.addproduct(new Produit(null,null,100+rnd.nextInt(10000),L1.get(i-1),A,A.getNameCat(),new ArrayList<>()));
					 productservice.addImgToproduct(i+44,"Casquettes/ca"+i+".jpg");
					 productservice.addImgToproduct(i+44,"Casquettes/ca"+i+i+".jpg");
				}
				
				 List <String> L2=new ArrayList<>();
					C=catrep.findByNameCat("Talons");
					
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
						 productservice.addimage(new Image(null,"Talons/T"+i+".jpg"));
					     productservice.addimage(new Image(null,"Talons/T"+i+i+".jpg"));
						 productservice.addproduct(new Produit(null,null,100+rnd.nextInt(10000),L2.get(i-1),C,C.getNameCat(),new ArrayList<>()));
						 productservice.addImgToproduct(i+52,"Talons/T"+i+".jpg");
						 productservice.addImgToproduct(i+52,"Talons/T"+i+i+".jpg");
					}
					
					
					
					List <String> L3=new ArrayList<>();
					D=catrep.findByNameCat("TShirts");
					
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
						 productservice.addimage(new Image(null,"TShirts/TS"+i+".jpg"));
					     productservice.addimage(new Image(null,"TShirts/TS"+i+i+".jpg"));
						 productservice.addproduct(new Produit(null,null,100+rnd.nextInt(10000),L3.get(i-1),D,D.getNameCat(),new ArrayList<>()));
						 productservice.addImgToproduct(i+61,"TShirts/TS"+i+".jpg");
						 productservice.addImgToproduct(i+61,"TShirts/TS"+i+i+".jpg");
					}
					
					
					
					List <String> L4=new ArrayList<>();
					E=catrep.findByNameCat("Chaussettes");
					
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
						 productservice.addimage(new Image(null,"Chaussettes/CH"+i+".jpg"));
					     productservice.addimage(new Image(null,"Chaussettes/CH"+i+i+".jpg"));
						 productservice.addproduct(new Produit(null,null,100+rnd.nextInt(10000),L4.get(i-1),E,E.getNameCat(),null));
						 productservice.addImgToproduct(i+70,"Chaussettes/CH"+i+".jpg");
						 productservice.addImgToproduct(i+70,"Chaussettes/CH"+i+i+".jpg");
					}
	
					System.out.println("SecServicesApplication");
					accountService.addNewUser(new AppUser(null,"user1","1234",new ArrayList<>()));
					accountService.addNewUser(new AppUser(null,"admin","1234",new ArrayList<>()));
					accountService.addNewUser(new AppUser(null,"user2","1234",new ArrayList<>()));
					accountService.addNewUser(new AppUser(null,"user3","1234",new ArrayList<>()));
					accountService.addNewUser(new AppUser(null,"user4","1234",new ArrayList<>()));
					
					accountService.addNewRole(new AppRole(null,"USER"));
					accountService.addNewRole(new AppRole(null,"ADMIN"));
					accountService.addNewRole(new AppRole(null,"CUSTOMER_MANAGER"));
					accountService.addNewRole(new AppRole(null,"PRODUCT_MANAGER"));
					accountService.addNewRole(new AppRole(null,"BILLS_MANAGER"));
					
					accountService.addRoleToUser("user1","USER");
					
					accountService.addRoleToUser("admin","USER");
					accountService.addRoleToUser("admin","ADMIN");
					
					accountService.addRoleToUser("user2","USER");
					accountService.addRoleToUser("user2","CUSTOMER_MANAGER");
					
					accountService.addRoleToUser("user3","USER");
					accountService.addRoleToUser("user3","PRODUCT_MANAGER");
					
					accountService.addRoleToUser("user4","USER");
					accountService.addRoleToUser("user4","BILLS_MANAGER");
				
				
				
				
			/*
			 * Category c1=catrep.findByNameCat("Pantalons"); productservice.addproduct(new
			 * Produit(null,null,5668,"Pantalon",c1,c1.getNameCat(),new ArrayList<>()));
			 * Category c2=catrep.findByNameCat("Talons"); productservice.addproduct(new
			 * Produit(null,null,8668,"Talons",c2,c2.getNameCat(),new ArrayList<>()));
			 * Category c3=catrep.findByNameCat("TShirts"); productservice.addproduct(new
			 * Produit(null,null,19668,"TShirts",c3,c3.getNameCat(),new ArrayList<>()));
			 * Category c4=catrep.findByNameCat("Casquettes"); productservice.addproduct(new
			 * Produit(null,null,56868,"Casquettes",c4,c4.getNameCat(),new ArrayList<>()));
			 * Category c5=catrep.findByNameCat("Robes"); productservice.addproduct(new
			 * Produit(null,null,13668,"Robes",c5,c5.getNameCat(),new ArrayList<>()));
			 * Category c6=catrep.findByNameCat("Sacs"); productservice.addproduct(new
			 * Produit(null,null,56668,"Sacs",c6,c6.getNameCat(),new ArrayList<>()));
			 * Category c7=catrep.findByNameCat("Manteaux"); productservice.addproduct(new
			 * Produit(null,null,85668,"Manteaux",c7,c7.getNameCat(),new ArrayList<>()));
			 * Category c8=catrep.findByNameCat("Chaussettes");
			 * productservice.addproduct(new
			 * Produit(null,null,54668,"Chaussettes",c8,c8.getNameCat(),new ArrayList<>()));
			 * Category c9=catrep.findByNameCat("Lunettes"); productservice.addproduct(new
			 * Produit(null,null,56968,"Lunettes",c9,c9.getNameCat(),new ArrayList<>()));
			 */

			 /* for (int i = 1; i <=10 ; i++) {
				  
				
				  productservice.addimage(new Image(null,"Pantalon/j"+i+".jpg"));
				  productservice.addimage(new Image(null,"Pantalon/j"+i+""+i+".jpg"));*/
				/*
				 * productservice.addImgToproduct(1,"Pantalon/j"+i+".jpg");
				 * productservice.addImgToproduct(1,"Pantalon/j"+i+""+i+".jpg");
				 * 
				 * productservice.addimage(new Image(null,"Talon/T"+i+".jpg"));
				 * productservice.addimage(new Image(null,"Talon/T"+i+""+i+".jpg"));
				 * 
				 * productservice.addImgToproduct(2,"Talon/T"+i+".jpg");
				 * productservice.addImgToproduct(2,"Talon/T"+i+""+i+".jpg");
				 * 
				 * productservice.addimage(new Image(null,"Sacs/SA"+i+".jpg"));
				 * productservice.addimage(new Image(null,"Sacs/SA"+i+""+i+".jpg"));
				 * 
				 * productservice.addImgToproduct("Product6","Sacs/SA"+i+".jpg");
				 * productservice.addImgToproduct("Product6","Sacs/SA"+i+""+i+".jpg");
				 * 
				 * productservice.addimage(new Image(null,"Robes/R"+i+".jpg"));
				 * productservice.addimage(new Image(null,"Robes/R"+i+""+i+".jpg"));
				 * 
				 * productservice.addImgToproduct("Product5","Robes/R"+i+".jpg");
				 * productservice.addImgToproduct("Product5","Robes/R"+i+""+i+".jpg");
				 * 
				 * productservice.addimage(new Image(null,"Manteau/M"+i+".jpg"));
				 * productservice.addimage(new Image(null,"Manteau/M"+i+""+i+".jpg"));
				 * 
				 * productservice.addImgToproduct("Product7","Manteau/M"+i+".jpg");
				 * productservice.addImgToproduct("Product7","Manteau/M"+i+""+i+".jpg");
				 * 
				 * productservice.addimage(new Image(null,"Lunettes/L"+i+".jpg"));
				 * productservice.addimage(new Image(null,"Lunettes/L"+i+""+i+".jpg"));
				 * 
				 * productservice.addImgToproduct("Product9","Lunettes/L"+i+".jpg");
				 * productservice.addImgToproduct("Product9","Lunettes/L"+i+""+i+".jpg");
				 * 
				 * productservice.addimage(new Image(null,"TShirts/TS"+i+".jpg"));
				 * productservice.addimage(new Image(null,"TShirts/TS"+i+""+i+".jpg"));
				 * 
				 * productservice.addImgToproduct("Product3","TShirts/TS"+i+".jpg");
				 * productservice.addImgToproduct("Product3","TShirts/TS"+i+""+i+".jpg");
				 * 
				 * productservice.addimage(new Image(null,"Casquettes/ca"+i+".jpg"));
				 * productservice.addimage(new Image(null,"Casquettes/ca"+i+""+i+".jpg"));
				 * 
				 * productservice.addImgToproduct("Product4","Casquettes/ca"+i+".jpg");
				 * productservice.addImgToproduct("Product4","Casquettes/ca"+i+""+i+".jpg");
				 * 
				 * productservice.addimage(new Image(null,"Chaussettes/CH"+i+".jpg"));
				 * productservice.addImgToproduct("Product8","Chaussettes/CH"+i+".jpg");
				 * productservice.addImgToproduct("Product8","Chaussettes/CH"+i+".jpg");
				 */
				  
				  

		  
		//	productservice.addImgToproduct("p1","J11.jpg");
		 
		//catrep.findAll().forEach(c->{
			//productservice.addproduct(new Produit(null,"p1","Product1",5668,"Pantalon",c,new ArrayList<>()));
		//});
	     //catrep.findById((long)1).toString();
		
	};

}
}
