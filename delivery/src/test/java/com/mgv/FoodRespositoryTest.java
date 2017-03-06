package com.mgv;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.mgv.ingredient.dao.FoodRepository;
import com.mgv.ingredient.dao.IngredientRepository;
import com.mgv.ingredient.entities.Food;
import com.mgv.ingredient.entities.Ingredient;

@DataJpaTest
@RunWith(SpringRunner.class)
@Transactional
public class FoodRespositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(FoodRespositoryTest.class);
	
	@Autowired
	FoodRepository dao;
	
	@Autowired
	IngredientRepository ingredientRepository;
	
	@Autowired
	private JdbcTemplate template;

	@Test
    public void testSave() throws Exception {
        Food food = new Food("Ceviche");
        food = dao.save(food);
        assertNotNull(food.getId());
    }
	
	@Test
    public void testSaveIngredient() throws Exception {
        
		Ingredient ingredient1 = new Ingredient("Papa2");
        Ingredient ingredient2 = new Ingredient("Yuka2");
        
        
        ArrayList<Ingredient> aList = new ArrayList<Ingredient>() {{ add(ingredient1); add(ingredient2);}};
		Food food = new Food("Ceviche2", aList);
        food = dao.save(food);
        assertNotNull(food.getId());
        for (Ingredient ingredient : ingredientRepository.findAll()) {
        	logger.info(ingredient.toString());
        }
        
    }
	
	
	
}
