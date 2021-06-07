package com.realdolmen.repositories;

import com.realdolmen.domain.Country;
import com.realdolmen.domain.Food;
import com.realdolmen.repositories.util.PropertiesLoader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryRepository {

    private final String url = PropertiesLoader.loadPropertiesFile().getProperty("db.url");
    private final String user = PropertiesLoader.loadPropertiesFile().getProperty("db.user");
    private final String password = PropertiesLoader.loadPropertiesFile().getProperty("db.password");

    public List<Country> findAll() {
        List<Country> countries = new ArrayList<>();
        try (Connection myConnection = DriverManager.getConnection(url, user, password);) {
            Statement myStatement = myConnection.createStatement();
            ResultSet myResultSet = myStatement.executeQuery("select * from Country");

            while (myResultSet.next()) {
                int id = myResultSet.getInt("id");
                String name = myResultSet.getString("name");
                countries.add(new Country(id, name));
            }
            return countries;
        } catch (SQLException e) {
            while (e != null) {
                System.out.println(e);
                e = e.getNextException();
            }
            return countries;
        }
    }
}
