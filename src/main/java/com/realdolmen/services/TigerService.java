package com.realdolmen.services;

import com.realdolmen.domain.Food;
import com.realdolmen.domain.Tiger;
import com.realdolmen.repositories.FoodRepository;
import com.realdolmen.repositories.NotFoundException;
import com.realdolmen.repositories.TigerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TigerService {

    @Autowired
    private TigerRepository tigerRepository ;


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

    public void removeById(long id) {
        tigerRepository.removeById(id);
    }
}
