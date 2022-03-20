package pl.sda.JDBC;

import pl.sda.JDBC.DAO.ShopDao;
import pl.sda.JDBC.DAO.ShopDaoImp;

public class DaoMainTest {

    public static void main(String[] args) {

        ShopDao shopDao = new ShopDaoImp();


//        System.out.println(shopDao.mapAllCountry());
//        System.out.println(shopDao.mapAllAddress());
        System.out.println(shopDao.mapAllUsers());

    }

}
