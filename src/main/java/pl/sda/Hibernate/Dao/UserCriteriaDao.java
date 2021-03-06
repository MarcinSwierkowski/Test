package pl.sda.Hibernate.Dao;

import pl.sda.Hibernate.model.Product;
import pl.sda.Hibernate.model.User;

import java.time.LocalDate;
import java.util.List;

public interface UserCriteriaDao {
    List<User> findUserWhereLastNameContains(String s);
      List<User> findAllByCountryAlias(String alias);
    List<User> findAllBornBetween(LocalDate date1, LocalDate date2);
    //join
    List<User> findAllWhoBoughtProduct(Product product);
    //join
    List<User> findAllWhoBoughtProductHql(Product product);
    List<User> findAllWithOrdersMoreExpensiveThan(double price);

}
