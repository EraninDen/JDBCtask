package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {

    public void createUsersTable() {
        try{
            String sql = "create table if not exists users (id bigint not null auto_increment, name varchar(45) not null, lastName varchar(45) not null, age int(3) not null, PRIMARY KEY (id)  )";
            PreparedStatement pr = Util.getConnection().prepareStatement(sql);
            pr.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }try{
            Util.getConnection().close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void dropUsersTable() throws SQLException {
        try{
            String sql = "drop table if exists users";
            PreparedStatement pr = Util.getConnection().prepareStatement(sql);
            pr.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }try{
            Util.getConnection().close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        try{
            User user = new User(name, lastName, age);
            String sql = "insert into users (name, lastName, age) VALUES (?,?,?)";
            PreparedStatement pr = Util.getConnection().prepareStatement(sql);
            pr.setString(1, user.getName());
            pr.setString(2, user.getLastName());
            pr.setByte(3, user.getAge());
            pr.execute();
            System.out.println("New users added to table");
        } catch (SQLException e){
            e.printStackTrace();
        }try{
            Util.getConnection().close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void removeUserById(long id) throws SQLException {
        try{
            User user = new User(id);
            String sql = "delete from users where id=?";
            PreparedStatement pr = Util.getConnection().prepareStatement(sql);
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

    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        try{
            User user = new User();
            String sql = "select * from users";
            PreparedStatement pr = Util.getConnection().prepareStatement(sql);
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

    public void cleanUsersTable() throws SQLException {
        try{
            String sql = "delete from users";
            PreparedStatement pr = Util.getConnection().prepareStatement(sql);
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
