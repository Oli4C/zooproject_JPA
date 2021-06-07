package com.realdolmen.repositories;

import com.realdolmen.domain.Tiger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TigerRepositoryIT {
    private TigerRepository myTigerRepository = new TigerRepository(); //SUT system under test

    @Test
    public void testThatTigerListContainsAllData(){
        List<Tiger> tigerList = myTigerRepository.getTigersFromDb();
        Assertions.assertFalse(tigerList.isEmpty());
        Tiger tiger = tigerList.get(0);
        Assertions.assertFalse(tiger.getName().isBlank());
        //TODO: use more assertions
    }

    @Test
    public void testSave(){
        Tiger tiger = new Tiger();
        tiger.setName("test");
        myTigerRepository.addATigerInDb(tiger);
    }
}
