package pl.sda.JDBC;

import pl.sda.JDBC.DataBaseConnection;
import pl.sda.JDBC.model.Address;
import pl.sda.JDBC.model.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Mapowanie {

    public static void main(String[] args) {

        String query = "SELECT * FROM ADDRESS JOIN COUNTRY ON ADD_CO_ID = CO_ID ;";

        DataBaseConnection dataBaseConnection = new DataBaseConnection();

        try(Statement statement = dataBaseConnection.getConnection().createStatement() ) {

            ResultSet resultSet = statement.executeQuery(query);
            List<Address> addresses = new ArrayList<>();

            while (resultSet.next()){
                addresses.add(mapAddress(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static Address mapAddress(ResultSet resultSet) throws SQLException {
        return new Address(
                resultSet.getInt("ADD_ID"),
                resultSet.getString("ADD_STREET"),
                resultSet.getString("ADD_BUILDING_NO"),
                resultSet.getString("ADD_APARTAMENT_NO"),
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

}
