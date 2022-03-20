package pl.sda.JDBC.DAO;

import pl.sda.JDBC.DataBaseConnection;
import pl.sda.JDBC.model.Address;
import pl.sda.JDBC.model.Country;
import pl.sda.JDBC.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopDaoImp implements ShopDao{
    @Override
    public List<Country> mapAllCountry() {
        List<Country> result = new ArrayList<>();
        String query = "SELECT * FROM COUNTRY ;";


        try(Statement statement = getConnection().createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                result.add(mapCountry(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Address> mapAllAddress() {
        List<Address> result = new ArrayList<>();
        String query = "SELECT * FROM ADDRESS JOIN COUNTRY ON ADD_CO_ID = CO_ID ;";

        try(Statement statement = getConnection().createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                result.add(mapAddress(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<User> mapAllUsers() {
        List<User> result = new ArrayList<>();
        String query = "SELECT * FROM USER " +
                "JOIN ADDRESS " +
                "JOIN COUNTRY " +
                "ON ADD_CO_ID = CO_ID AND USR_ADD_ID= ADD_ID ;";


        try(Statement statement = getConnection().createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                result.add(mapUsers(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Country mapCountryById(int id) {


        int PLACEHOLDER_INDEX_1 = 1;
        String query = "SELECT * FROM COUNTRY WHERE CO_ID = ? ;";

        try(PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {

        preparedStatement.setInt(PLACEHOLDER_INDEX_1,id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            return mapCountry(resultSet);
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addNewCountry(Country country) {


        int PLACEHOLDER_INDEX_1 = 1;
        int PLACEHOLDER_INDEX_2 = 2;
        
        String query = "INSERT INTO COUNTRY (CO_NAME, CO_ALIAS) VALUES (?, ?) ;";

        try(PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
       
            preparedStatement.setString(PLACEHOLDER_INDEX_1, country.getName());
            preparedStatement.setString(PLACEHOLDER_INDEX_2, country.getAlias());

            preparedStatement.executeUpdate();
       
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean deleteCountry(int id) {
        if(mapCountryById(id) != null) {
            
            int PLACEHOLDER_INDEX_1 = 1;
            String query = "DELETE FROM COUNTRY WHERE CO_ID = ? ;";
            
            try(PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            
            preparedStatement.setInt(PLACEHOLDER_INDEX_1,id);
            preparedStatement.executeUpdate();
            
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public void updateCountry(Country country) {
        if(country.getId() != null && mapCountryById(country.getId()) != null) {
            int PLACEHOLDER_INDEX_1 = 1;
            int PLACEHOLDER_INDEX_2 = 2;
            int PLACEHOLDER_INDEX_3 = 3;

            String query = "UPDATE COUNTRY SET CO_NAME = ? SET CO_ALIAS = ? WHERE CO_ID = ? ;";

            try {
                PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            
            preparedStatement.setString(PLACEHOLDER_INDEX_1,country.getName());
            preparedStatement.setString(PLACEHOLDER_INDEX_2,country.getAlias());
            preparedStatement.setInt(PLACEHOLDER_INDEX_3,country.getId());
            
            preparedStatement.executeUpdate();
            
            } catch (SQLException e) {
                e.printStackTrace();
            }


        } else addNewCountry(country);
    }

    private static User mapUsers(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getInt("USR_ID"),
                resultSet.getDate("USR_BIRTH_DATE"),
                resultSet.getString("USR_FIRST_NAME"),
                resultSet.getString("USR_LAST_NAME"),
                resultSet.getString("USR_EMAIL"),
                resultSet.getString("USR_PASSWORD"),
                mapAddress(resultSet));
    }

    private static Address mapAddress(ResultSet resultSet) throws SQLException {
        return new Address(
                resultSet.getInt("ADD_ID"),
                resultSet.getString("ADD_STREET"),
                resultSet.getString("ADD_BUILDING_NO"),
                resultSet.getString("ADD_APARTMENT_NO"),
                resultSet.getString("ADD_CITY"),
                resultSet.getString("ADD_POSTAL_CODE"),
                mapCountry(resultSet));
    }

    private static Country mapCountry(ResultSet resultSet) throws SQLException {
        return new Country(
                resultSet.getInt("CO_ID"),
                resultSet.getString("CO_NAME"),
                resultSet.getString("CO_ALIAS")
        );
    }

    private Connection getConnection() {
        return new DataBaseConnection().getConnection();
    }
}
