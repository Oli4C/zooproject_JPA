package com.realdolmen.controllers;

import com.realdolmen.domain.Tiger;
import com.realdolmen.services.TigerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ActionsController {

    private TigerService tigerService = new TigerService();

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



}
