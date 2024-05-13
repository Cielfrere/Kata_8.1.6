package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("Хью ", "Гровенор", (byte) 33);
        userService.saveUser("Отто ", "Бисмарк", (byte) 83);
        userService.saveUser("Никола ", "Тесла", (byte) 86);
        userService.saveUser("Александр ", "Македонский", (byte) 32);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}