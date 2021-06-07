package com.realdolmen.domain;

import java.util.ArrayList;
import java.util.List;

public class Tiger {

    private int id;
    private String name; //moet private staan, encapsulation
    private Country country; //ManyToOne relationShip

    //TODO: Add a List of Foods field + setters & getter.
    //The relationship here is a OneToMany relationship (One animal can eat Many kinds of foods)
    private List<Food> foods = new ArrayList<>(); //better to initiate it already (create an object), so we don't get any NullPointerException if we try to call it.

    public Tiger() {
    }

    public Tiger(String name, int id, Country country) { //constructor
        this.name = name;
        this.id = id;
        this.country = country;
    }



    public Tiger(String name) { //overloading, andere parameters dan boven (name, id)
        this.name = name;
    }

    public String getName() { //getter
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


}
