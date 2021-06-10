package com.realdolmen.services;

import com.realdolmen.domain.Food;
import com.realdolmen.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository ;

    public List<Food> getAllFood() {
        return foodRepository.getAllFoodFromDb();
    }

    public void deleteFoodById(int id) {
        foodRepository.deleteFoodById(id);
    }

    public void updateFoodName(int id, String foodName) {
        foodRepository.updateFoodName(id, foodName);
    }

    public Food findById(Long id) {
        return foodRepository.findById(id);
    }

    public void save(Food newFood) {
        foodRepository.save(newFood);
    }
}
