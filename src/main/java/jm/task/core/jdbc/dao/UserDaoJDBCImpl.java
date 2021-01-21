package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {

    public void createUsersTable() {
        try{
            PreparedStatement pr = Util.getConnection().prepareStatement("create table if not exists users (id bigint not null auto_increment, name varchar(45) not null, lastName varchar(45) not null, age int(3) not null, PRIMARY KEY (id)  )");
            pr.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }try{
            Util.getConnection().close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void dropUsersTable()  {
        try{
            PreparedStatement pr = Util.getConnection().prepareStatement("drop table if exists users");
            pr.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }try{
            Util.getConnection().close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age)  {
        try{
            User user = new User(name, lastName, age);
            PreparedStatement pr = Util.getConnection().prepareStatement("insert into users (name, lastName, age) VALUES (?,?,?)");
            pr.setString(1, user.getName());
            pr.setString(2, user.getLastName());
            pr.setByte(3, user.getAge());
            pr.execute();
            System.out.println("New users with name: " + user.getName()  +  " added to table");
        } catch (SQLException e){
            e.printStackTrace();
        }try{
            Util.getConnection().close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void removeUserById(long id)  {
        try{
            User user = new User(id);
            PreparedStatement pr = Util.getConnection().prepareStatement("delete from users where id=?");
            pr.setLong(1, user.getId());
            pr.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }try{
            Util.getConnection().close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public List<User> getAllUsers()  {
        List<User> userList = new ArrayList<>();
        try{
            PreparedStatement pr = Util.getConnection().prepareStatement("select * from users");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                userList.add(new User(rs.getLong("id"), rs.getString("name"), rs.getString("lastName"), rs.getByte("age")));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }try{
            Util.getConnection().close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return userList;
    }

    public void cleanUsersTable()  {
        try{
            PreparedStatement pr = Util.getConnection().prepareStatement("delete from users");
            pr.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }try{
            Util.getConnection().close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
