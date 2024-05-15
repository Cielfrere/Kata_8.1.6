package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;
import lombok.*;

@NoArgsConstructor
public class UserServiceImpl extends Util implements UserService {
    private UserDao userDaoJDBC = new UserDaoJDBCImpl();
    @Override
    public void createUsersTable() {
        userDaoJDBC.createUsersTable();
    }
    @Override
    public void dropUsersTable() {
        userDaoJDBC.dropUsersTable();
    }
    @Override
    public void saveUser(String name, String lastName, byte age) {
        userDaoJDBC.saveUser(name,lastName,age);
        System.out.println("User с именем " + name + "добавлен в базу данных");
    }
    @Override
    public void removeUserById(long id) {
        userDaoJDBC.removeUserById(id);
    }
    @Override
    public List<User> getAllUsers() {
        List<User> users = null;
        try {
            users = userDaoJDBC.getAllUsers();
        } catch (SQLException e) {
            System.out.println("Ошибка при получении пользователей");;
        }
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }
    @Override
    public void cleanUsersTable() {
        userDaoJDBC.cleanUsersTable();
    }
}
