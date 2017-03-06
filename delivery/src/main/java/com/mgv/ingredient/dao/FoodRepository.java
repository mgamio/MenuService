package com.mgv.ingredient.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mgv.ingredient.entities.Food;

public interface FoodRepository extends JpaRepository<Food, Integer> {

}
