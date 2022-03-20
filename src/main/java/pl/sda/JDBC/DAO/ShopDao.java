package pl.sda.JDBC.DAO;


import pl.sda.JDBC.model.Address;
import pl.sda.JDBC.model.Country;
import pl.sda.JDBC.model.User;

import java.util.List;

public interface ShopDao {

    List<Country> mapAllCountry();
    List<Address> mapAllAddress();
    List<User> mapAllUsers();

    Country mapCountryById(int id);
    void addNewCountry(Country country);
    boolean deleteCountry(int id);
    void updateCountry(Country country);

}
