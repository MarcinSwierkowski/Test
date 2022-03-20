package pl.sda.Hibernate;

import pl.sda.Hibernate.Dao.GenericDao;
import pl.sda.Hibernate.Dao.GenericDaoImp;
import pl.sda.Hibernate.model.Address;
import pl.sda.Hibernate.model.Country;

public class DaoMainExecute {
    public static void main(String[] args) {

        GenericDao findbyAddresId3 = new GenericDaoImp<>(Address.class);

        System.out.println(findbyAddresId3.findById(3));


    }
}
