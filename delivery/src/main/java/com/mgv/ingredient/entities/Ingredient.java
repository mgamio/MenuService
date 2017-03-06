package com.mgv.ingredient.entities;

import javax.persistence.*;

/**
 * Created by mkgv on 3/4/2017.
 */
@Entity
@Table(name="ingredient")
public class Ingredient {
	
    @Id @GeneratedValue
    private Integer id;

    @Column(nullable = false, name = "name")
    private String name;

    public Ingredient() {}

    public Ingredient(String name) {
        this.name = name;
    }

    public Ingredient(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" +  id +
                ",name=" + name + "}";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;

        Ingredient ingredient = (Ingredient)o;

        if (!id.equals(ingredient.id)) return false;
        return name.equals(ingredient.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

}
