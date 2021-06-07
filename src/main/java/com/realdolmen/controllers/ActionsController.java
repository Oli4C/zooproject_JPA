package com.realdolmen.controllers;

import com.realdolmen.domain.Tiger;
import com.realdolmen.services.CountryService;
import com.realdolmen.services.FoodService;
import com.realdolmen.services.TigerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ActionsController {

    private TigerService tigerService = new TigerService();
    private CountryService countryService = new CountryService();
    private FoodService foodService = new FoodService();

    @GetMapping(value = "/editPage/{id}")
    public String showEditPage(@PathVariable("id") int id, Model model){
        model.addAttribute("editanimal",tigerService.findById(id));
        return "edit";
    }

    @PostMapping(value = "/edit/{id}")
    public String editTiger(@ModelAttribute Tiger tiger){
        tigerService.updateTiger(tiger);
        return "redirect:/";
    }

    @GetMapping(value = "/addAnimal")
//    @RequestMapping(
//            value = "/addAnimalPage",
//            produces = "application/json",
//            method = {RequestMethod.GET, RequestMethod.PUT})
    public String showAddPage(Model model){
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("newTiger", new Tiger());
        model.addAttribute("foods", foodService.getAllFood());
        return "addAnimal";
    }

    @PostMapping(value = "/add")
//    @RequestMapping(
//            value = "/add",
//            produces = "application/json",
//            method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
    public String add(@ModelAttribute Tiger newTiger) {
        tigerService.addATiger(newTiger);
        return "redirect:/";
    }


}
