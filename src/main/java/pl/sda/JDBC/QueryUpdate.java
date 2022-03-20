package pl.sda.JDBC;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QueryUpdate {

    private final static int PLACEHOLDER_INDEX_1 = 1;
    private final static int PLACEHOLDER_INDEX_2 = 2;

    public static void main(String[] args) {

        String query = "UPDATE ADDRESS SET ADD_BUILDING_NO = ? WHERE ADD_POSTAL_CODE = ? ;";

        DataBaseConnection dataBaseConnection = new DataBaseConnection();

        try (PreparedStatement preparedStatement = dataBaseConnection.getConnection().prepareStatement(query)) {

            String buildingNumber = "132";
            String postalCode = "79677";

            preparedStatement.setString(PLACEHOLDER_INDEX_1,buildingNumber);
            preparedStatement.setString(PLACEHOLDER_INDEX_2,postalCode);

            int rowsUpdated = preparedStatement.executeUpdate();
            System.out.println("Zaktualizowano "+rowsUpdated+" wierszy");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}