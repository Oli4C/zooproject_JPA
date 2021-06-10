package com.realdolmen.controllers;

import com.realdolmen.domain.Food;
import com.realdolmen.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/addFood")
    public String showFood(Model model){
        model.addAttribute("newFood", new Food());
        return "addFood";
    }

    @PostMapping("/saveFood")
    public String saveFood(@ModelAttribute Food newFood){
        foodService.save(newFood);
        return "redirect:/";
    }

}
