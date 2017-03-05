package com.mgv;

import com.mgv.ingredient.dao.IngredientRepository;
import com.mgv.ingredient.entities.Ingredient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;


import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mkgv on 3/4/2017.
 */
@DataJpaTest
@RunWith(SpringRunner.class)
@Transactional
public class IngredientRepositoryTest {

    @Autowired
    private IngredientRepository dao;

    @Autowired
    private JdbcTemplate template;

    @Test
    public void testSave() throws Exception {
        Ingredient ingredient = new Ingredient("Pollo");
        ingredient = dao.save(ingredient);
        assertNotNull(ingredient.getId());
    }

    @Test
    public void findOne() throws Exception {
        template.query("select id from ingredient", (rs, num) -> rs.getInt("id"))
                .forEach(id -> {
                    Ingredient ingredient = dao.findOne(id);
                    assertNotNull(ingredient);
                    assertEquals(id, ingredient.getId());
                });
    }

    @Test
    public void findByName() throws Exception {
    }

}
