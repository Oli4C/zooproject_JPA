package com.realdolmen.services;

import com.realdolmen.domain.Tiger;
import com.realdolmen.repositories.FoodRepository;
import com.realdolmen.repositories.NotFoundException;
import com.realdolmen.repositories.TigerRepository;

import java.util.List;


public class TigerService {

    private TigerRepository tigerRepository = new TigerRepository();
    private FoodRepository foodRepository = new FoodRepository();


    public List<Tiger> getTigers()  {
        List<Tiger> tigers = tigerRepository.getTigersFromDb();
        for (Tiger tiger : tigers) {
            tiger.setFoods(foodRepository.findAllFoodByAnimalId(tiger.getId()));
        }
        return tigers;
    }


    public void addATiger(Tiger tiger) {


        tigerRepository.addATigerInDb(tiger);
    }

    public Tiger findById(int id) {
        Tiger tiger = tigerRepository.findById(id);
        tiger.setFoods(foodRepository.findAllFoodByAnimalId(tiger.getId()));
        return tiger;
    }

    public void updateTiger(Tiger tiger){
        tigerRepository.updateTigerById(tiger);
    }
}
