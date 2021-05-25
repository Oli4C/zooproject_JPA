package com.realdolmen.services;

import com.realdolmen.domain.Food;
import com.realdolmen.repositories.FoodRepository;

import java.util.List;

public class FoodService {

    private FoodRepository foodRepository = new FoodRepository();

    public List<Food> getAllFood() {
        return foodRepository.getAllFoodFromDb();
    }

    public void deleteFoodById(int id) {
        foodRepository.deleteFoodById(id);
    }

    public void updateFoodName(int id, String foodName) {
        foodRepository.updateFoodName(id, foodName);
    }

    public Food findById(Integer id) {
        return foodRepository.findById(id);
    }
}
