package org.sid.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Produit {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @JsonIgnore
   private int ref;
   private String id;
   private String nom;
   private double prix;
   private String description;
   @JsonProperty(access = Access.WRITE_ONLY)
   @ManyToOne
   private Category category;
   private String categoryname;
   @ManyToMany(fetch=FetchType.EAGER)
   private List<Image> image=new ArrayList<>();
public Produit(String id, String nom, double prix, String description, String categoryname,
		List<Image> image) {
	super();
	this.id = id;
	this.nom = nom;
	this.prix = prix;
	this.description = description;
	this.category = category;
	this.categoryname = categoryname;
	this.image = image;
}
  
   
}
