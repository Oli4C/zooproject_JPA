package com.realdolmen.controllers;

import com.realdolmen.domain.Food;
import com.realdolmen.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;


@Component
public class TypeFormatter implements Formatter<Food>{
    @Autowired
    private FoodService foodService;

    @Override
    public Food parse(String text, Locale locale) throws ParseException {
        return foodService.findById(Long.valueOf(text));
    }

    @Override
    public String print(Food object, Locale locale) {
        return (object != null ? String.valueOf(object.getId()) : "");
    }
}
