package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {


    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydbtest";// реализуйте настройку соеденения с БД
    private static final String DB_USERNAME = "root";// реализуйте настройку соеденения с БД
    private static final String DB_PASSWORD = "1234";


    public static Connection getConnection()  {

        try{
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection OK");
            return connection;

        } catch ( SQLException | IllegalAccessException | InstantiationException| ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Connection ERROR");
            throw new IllegalStateException();
        }
    }// реализуйте настройку соеденения с БД
}
