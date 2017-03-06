package com.mgv.ingredient.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="food")
public class Food {
	
	@Id @GeneratedValue
	private Integer id;
	
	@Column(nullable = false, name = "name")
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "food_ingredient", 
    		   joinColumns = @JoinColumn(name = "food_id", referencedColumnName = "id"),
    		   inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"))
	private List<Ingredient> ingredients;
	
	public Food() {}

	public Food(String name) {
		this.name = name;
	}
	
	public Food(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Food(String name, List<Ingredient> ingredients) {
		this.name = name;
		this.ingredients = ingredients;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	
}
