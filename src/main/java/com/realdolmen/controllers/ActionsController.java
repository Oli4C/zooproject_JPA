package com.realdolmen.controllers;

import com.realdolmen.domain.Tiger;
import com.realdolmen.services.CountryService;
import com.realdolmen.services.FoodService;
import com.realdolmen.services.TigerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ActionsController {

    @Autowired
    private TigerService tigerService;
    @Autowired
    private CountryService countryService ;
    @Autowired
    private FoodService foodService ;

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
    public String showAddPage(Model model){
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("newTiger", new Tiger());
        model.addAttribute("foods", foodService.getAllFood());
        return "addAnimal";
    }

    @PostMapping(value = "/add")
    public String add(@ModelAttribute Tiger newTiger) {
        tigerService.addATiger(newTiger);
        return "redirect:/";
    }

    @GetMapping(value= "/remove/{id}")
    public String deleteAGame(@PathVariable("id") Long id) {
        tigerService.removeById(id);
        return "redirect:/";
    }

}
