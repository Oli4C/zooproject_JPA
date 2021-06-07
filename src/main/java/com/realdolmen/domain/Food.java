package com.realdolmen.domain;

public class Food {
    //TODO: add id and foodName fields + constructor + getters
    private int id;
    private String foodName;

    public Food(int id, String foodName) {
        this.id = id;
        this.foodName = foodName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getId() {
        return id;
    }


}
