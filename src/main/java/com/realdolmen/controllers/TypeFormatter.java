package com.realdolmen.controllers;
import com.realdolmen.domain.Food;
import com.realdolmen.services.FoodService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;


@Service
public class TypeFormatter implements Formatter<Food>{

    private FoodService foodService = new FoodService();

    @Override
    public Food parse(String text, Locale locale) throws ParseException {
        return foodService.findById(Integer.valueOf(text));
    }

    @Override
    public String print(Food object, Locale locale) {
        return (object != null ? String.valueOf(object.getId()) : "");
    }
}
