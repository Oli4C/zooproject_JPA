package com.realdolmen.repositories;

import com.realdolmen.domain.Country;
import com.realdolmen.domain.Tiger;
import com.realdolmen.repositories.util.PropertiesLoader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Repository communicates with the database
//Anatomy of a Class: AccessModifier class ClassName
public class TigerRepository {
    private final String url = PropertiesLoader.loadPropertiesFile().getProperty("db.url");
    private final String user = PropertiesLoader.loadPropertiesFile().getProperty("db.user");
    private final String password = PropertiesLoader.loadPropertiesFile().getProperty("db.password");


    public List<Tiger> getTigersFromDb() {
        try (Connection myConnection = DriverManager.getConnection(url, user, password);) {
            PreparedStatement statement = myConnection.prepareStatement("select * from Tiger as t inner join Country as c on t.countryId=c.id");
            statement.execute();
            ResultSet myResultSet = statement.getResultSet();

            List<Tiger> myTigerList = new ArrayList<>();
            while (myResultSet.next()) {
                int id = myResultSet.getInt("t.id");
                String name = myResultSet.getString("t.name");
                Country country = new Country(myResultSet.getInt("c.id"), myResultSet.getString("c.name"));
                Tiger tiger = new Tiger(name, id, country);
                tiger.setCountry(country);
                myTigerList.add(tiger);
            }
            return myTigerList; // return the TigerList, we might not reach here if there's an exception in the code above
        } catch (SQLException e) {
            while (e != null) {
                System.out.println(e);
                e = e.getNextException();
            }
            return null; // the getTigersFromDb() method has a return type List<Tiger> so it's required that this method returns something
        }
    }


    public void addATigerInDb(Tiger tiger) {
        Connection myConnection = null;
        try {
            myConnection = DriverManager.getConnection(url, user, password);
            myConnection.setAutoCommit(false);
            PreparedStatement myStatement = myConnection.prepareStatement("insert into Tiger(name, countryId) values (?,?)", Statement.RETURN_GENERATED_KEYS);
            myStatement.setString(1, tiger.getName());
            myStatement.setInt(2, tiger.getCountry().getId());
            myStatement.execute();
            myConnection.commit();
            ResultSet rs = myStatement.getGeneratedKeys();
            rs.next();
            int generatedId = rs.getInt(1);
            tiger.setId(generatedId);
        } catch (SQLException e) {//CATCH the exception and handle it in this catch block
            while (e != null) {//SQLException can contain nested exceptions, that's why we use the while loop to loop over each exception
                try {
                    myConnection.rollback(); //if there's an exception, rollback everything so our database doesn't get any invalid values
                    System.out.println(e);
                    e = e.getNextException();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        } finally {//FINALLY, always gets executed even when there's an Exception. (Could be an OCA exam question)
            try {
                myConnection.close();//Always close the connection to the database, because it can cause memory leaks https://en.wikipedia.org/wiki/Memory_leak
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public Tiger findById(int id) {
        Connection myConnection = null;
        try {
            myConnection = DriverManager.getConnection(url, user, password);
            PreparedStatement myStatement = myConnection.prepareStatement("select * from Tiger as t inner join Country as c on t.countryId=c.id where t.id = ? ");
            myStatement.setInt(1, id);
            myStatement.execute();
            ResultSet myResultSet = myStatement.getResultSet();
            myResultSet.next();
            Country country = new Country(myResultSet.getInt("c.id"), myResultSet.getString("c.name"));
            Tiger tiger = new Tiger(myResultSet.getString("t.name"), myResultSet.getInt("t.id"), country);
            return tiger;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {//FINALLY, always gets executed even when there's an Exception. (Could be an OCA exam question)
            try {
                myConnection.close();//Always close the connection to the database, because it can cause memory leaks https://en.wikipedia.org/wiki/Memory_leak
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void updateTigerById(Tiger tiger) {
        Connection myConnection = null;
        try {
            myConnection = DriverManager.getConnection(url, user, password);
            PreparedStatement myStatement = myConnection.prepareStatement("update Tiger set name = ? where id = ? ");
            myStatement.setString(1, tiger.getName());
            myStatement.setInt(2, tiger.getId());
            myStatement.execute();


        } catch (SQLException e) {
            e.printStackTrace();

        } finally {//FINALLY, always gets executed even when there's an Exception. (Could be an OCA exam question)
            try {
                myConnection.close();//Always close the connection to the database, because it can cause memory leaks https://en.wikipedia.org/wiki/Memory_leak
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void removeById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from Tiger where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
