package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

       UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
       userDaoJDBC.createUsersTable();
       userDaoJDBC.saveUser("Vasya", "Puskin", (byte) 28);
       userDaoJDBC.saveUser("Kolya", "Tolstoy", (byte) 44);
       userDaoJDBC.saveUser("Alex", "White", (byte) 38);
       userDaoJDBC.saveUser("Goga", "Tupin", (byte) 56);

       userDaoJDBC.cleanUsersTable();
       userDaoJDBC.dropUsersTable();

        // реализуйте алгоритм здесь

    }
}
