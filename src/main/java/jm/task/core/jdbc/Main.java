package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;




import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

       UserDao userDao = new UserDaoHibernateImpl();
       userDao.createUsersTable();
       //userDao.saveUser("Vasya", "Puskin", (byte) 28);
      // userDao.saveUser("Kolya", "Tolstoy", (byte) 44);
      // userDao.saveUser("Alex", "White", (byte) 38);
       userDao.saveUser("Goga", "Tupin", (byte) 56);


       //userDaoJDBC.cleanUsersTable();
       //userDaoJDBC.dropUsersTable();

        // реализуйте алгоритм здесь

    }
}
