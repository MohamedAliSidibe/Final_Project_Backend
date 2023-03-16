package org.sid.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
   private String name;
   private double price;
   private String description;
   @JsonProperty(access = Access.WRITE_ONLY)
   @ManyToOne
   private Category category;
   private String categoryname;
   @ManyToMany(fetch=FetchType.EAGER)
   private Collection<Image> images=new ArrayList<>();
public Produit(String id, String name, double price, String description, Category category, String categoryname,
		Collection<Image> images) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
	this.description = description;
	this.category = category;
	this.categoryname = categoryname;
	this.images = images;
}
   
}
