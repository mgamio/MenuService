package com.mgv.ingredient.dao;

import com.mgv.ingredient.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by mkgv on 3/4/2017.
 */
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

    List<Ingredient> findByName(@Param("name") String name);

}
