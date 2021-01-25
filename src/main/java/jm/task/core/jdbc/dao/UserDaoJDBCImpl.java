package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        try(PreparedStatement pstm = Util.getConnection().prepareStatement("create table if not exists users (id bigint not null auto_increment, name varchar(45) not null, lastName varchar(45) not null, age int(3) not null, PRIMARY KEY (id)  )")) {
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable()  {
        try(PreparedStatement pstm = Util.getConnection().prepareStatement("drop table if exists users")) {
            pstm.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age)  {
        User user = new User(name, lastName, age);
        try (PreparedStatement pstm = Util.getConnection().prepareStatement("insert into users (name, lastName, age) VALUES (?,?,?)")) {
            pstm.setString(1, user.getName());
            pstm.setString(2, user.getLastName());
            pstm.setByte(3, user.getAge());
            pstm.execute();
            System.out.println("New users with name: " + user.getName()  +  " added to table");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void removeUserById(long id)  {
        User user = new User(id);
        try (PreparedStatement pstm = Util.getConnection().prepareStatement("delete from users where id=?")){
            pstm.setLong(1, user.getId());
            pstm.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers()  {
        List<User> userList = new ArrayList<>();
        try(PreparedStatement pstm = Util.getConnection().prepareStatement("select * from users")){
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                userList.add(new User(rs.getLong("id"), rs.getString("name"), rs.getString("lastName"), rs.getByte("age")));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }

    public void cleanUsersTable()  {
        try(PreparedStatement pstm = Util.getConnection().prepareStatement("delete from users")){
            pstm.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
