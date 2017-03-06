package com.mgv.ingredient.rest;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mgv.ingredient.dao.FoodRepository;
import com.mgv.ingredient.dao.IngredientRepository;
import com.mgv.ingredient.entities.Food;
import com.mgv.ingredient.entities.Ingredient;

@RestController
public class FoodController {

	private static final Logger logger = LoggerFactory.getLogger(FoodController.class);
	
	@Autowired
	FoodRepository dao;
	
	@Autowired
	IngredientRepository ingredientRepository;
	
	@Autowired
	private JdbcTemplate template;
	

	    @RequestMapping("/ing")
	    public void greeting(@RequestParam(value="name", defaultValue="World") String name) {
	        
	    	Ingredient ingredient1 = new Ingredient("Papa2");
	        Ingredient ingredient2 = new Ingredient("Yuka2");
	        
	        
	        ArrayList<Ingredient> aList = new ArrayList<Ingredient>() {{ add(ingredient1); add(ingredient2);}};
			Food food = new Food("Ceviche2", aList);
	        food = dao.save(food);
	        for (Ingredient ingredient : ingredientRepository.findAll()) {
	        	logger.info(ingredient.toString());
	        }
	        
	    }
	
}
