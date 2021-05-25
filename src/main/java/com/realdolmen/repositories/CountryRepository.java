package com.realdolmen.repositories;

import com.realdolmen.domain.Country;
import com.realdolmen.repositories.util.PropertiesLoader;
import java.util.*;
import java.sql.*;


public class CountryRepository {

    private final String url = PropertiesLoader.loadPropertiesFile().getProperty("db.url");
    private final String user = PropertiesLoader.loadPropertiesFile().getProperty("db.user");
    private final String password = PropertiesLoader.loadPropertiesFile().getProperty("db.password");

    public List<Country> findAll() {
        List<Country> countries = new ArrayList<>();
        try (Connection myConnection = DriverManager.getConnection(url, user, password);) {
            PreparedStatement myStatement = myConnection.prepareStatement("select * from Country");
            myStatement.execute();
            ResultSet myResultSet = myStatement.getResultSet();

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
