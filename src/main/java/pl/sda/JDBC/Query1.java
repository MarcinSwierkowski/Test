package pl.sda.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query1 {
    public static void main(String[] args) {

        DataBaseConnection dataBaseConnection = new DataBaseConnection();

        String query ="SELECT * from COUNTRY;";  //proste query za pomocą Steatment bez zmiennych w zapytaniu

        try(Statement statement = dataBaseConnection.getConnection().createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){

                System.out.println("CO_ID = "+resultSet.getInt("CO_ID"));
                System.out.println("CO_NAME = "+resultSet.getString("CO_NAME"));
                System.out.println("CO_ALIAS = "+resultSet.getString("CO_ALIAS"));
                System.out.println();

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
