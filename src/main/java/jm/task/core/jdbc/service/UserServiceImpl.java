package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import java.sql.SQLException;
import java.util.List;


public class UserServiceImpl implements UserService {
    private static final UserDao userDao = new UserDaoJDBCImpl();

    public UserServiceImpl(){
    }

    private static UserDaoJDBCImpl getUserDao(){
        return (UserDaoJDBCImpl) userDao;
    }


    public void createUsersTable() {
        getUserDao().createUsersTable();
    }

    public void dropUsersTable()  {
        getUserDao().dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        getUserDao().saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        getUserDao().removeUserById(id);
    }

    public List<User> getAllUsers() {
        return getUserDao().getAllUsers();
    }

    public void cleanUsersTable() {
        getUserDao().cleanUsersTable();
    }

}
//UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl(); - объекты создаем через интерфейсы
//UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl(); - для чего в каждом методе мы создаем этот объект? + опять же не через интерфейс
//String sql = "delete from users"; - эти объекты для чего?
//class UserDaoJDBCImpl - просмотри все методы и напиши по человечески