package jm.task.core.jdbc;
import jm.task.core.jdbc.service.*;
import jm.task.core.jdbc.util.Util;



public class Main {

    private static final UserService userService = new UserServiceImpl();

    private static UserServiceImpl getUserService(){
        return (UserServiceImpl) userService;
    }

    public static void main(String[] args) {

       getUserService().createUsersTable();
       getUserService().saveUser("Vasya", "Puskin", (byte) 28);
       getUserService().saveUser("Kolya", "Tolstoy", (byte) 44);
       getUserService().saveUser("Alex", "White", (byte) 38);
       getUserService().saveUser("Goga", "Tupin", (byte) 56);
       getUserService().getAllUsers();
       getUserService().cleanUsersTable();
       getUserService().dropUsersTable();
       Util.shutdown();
    }
}

// Создание таблицы User(ов)
// Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
// Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
// Очистка таблицы User(ов)
// Удаление таблицы
// реализуйте алгоритм здесь
