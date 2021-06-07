package com.realdolmen.services;

import com.realdolmen.domain.Food;
import com.realdolmen.domain.Tiger;
import com.realdolmen.repositories.FoodRepository;
import com.realdolmen.repositories.NotFoundException;
import com.realdolmen.repositories.TigerRepository;

import java.util.List;


public class TigerService {

    private TigerRepository tigerRepository = new TigerRepository();


    public List<Tiger> getTigers() {
     return tigerRepository.getTigersFromDb();
    }

    public void addATiger(Tiger tiger) {
        tigerRepository.addATigerInDb(tiger);
    }

    public Tiger findById(int id) {
        return tigerRepository.findById(id);
    }

    public void updateTiger(Tiger tiger) {
        tigerRepository.updateTigerById(tiger);
    }

    public void removeById(int id) {
        tigerRepository.removeById(id);
    }
}
