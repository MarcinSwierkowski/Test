package pl.sda.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Query2 {

private final static int PLACEHOLDER_INDEX_1 = 1;

    public static void main(String[] args) {

        String query = "SELECT * FROM ADDRESS WHERE ADD_ID = ? ;";  // znak ? to PLACEHOLDER
        String parameter = "1";


        DataBaseConnection dataBaseConnection = new DataBaseConnection();

        try(PreparedStatement preparedStatement = dataBaseConnection.getConnection().prepareStatement(query)) {

       preparedStatement.setString(PLACEHOLDER_INDEX_1, parameter);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                System.out.println(resultSet.getInt("ADD_ID"));
                System.out.println(resultSet.getString("ADD_STREET"));
                System.out.println(resultSet.getString("ADD_BUILDING_NO"));
                System.out.println(resultSet.getString("ADD_APARTAMENT_NO"));
                System.out.println(resultSet.getString("ADD_CITY"));
                System.out.println(resultSet.getString("ADD_POSTAL_CODE"));
                System.out.println(resultSet.getInt("ADD_CO_ID"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}