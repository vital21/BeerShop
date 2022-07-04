package org.example.DataBase;

import org.example.controller.RequestParameter;
import org.example.service.User;
import org.example.service.UserBuy;

import java.sql.*;
import java.util.ArrayList;

public class UserDb implements UserDataBase {
    private static final String SELECT_ID_BY_NAME = "SELECT id FROM users WHERE username=?";
    private static final String SELECT_ARRAY_USERS_BY_ID = "SELECT * FROM users WHERE id=?";
    private static final String INSERT_USER = "INSERT INTO users (username,password,gmail,token) VALUES(?,?,?,?)";

    @Override
    public int selectIdUserByName(String name) {
        int id = 0;
        try (Connection connection = DriverManager.getConnection(RequestParameter.URL_DB, RequestParameter.USER_DB, RequestParameter.PASSWORD_DB);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID_BY_NAME)) {
            Class.forName("com.mysql.jdbc.Driver");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
                return id;
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return id;
    }

    public ArrayList<User> arrayUsers(ArrayList<UserBuy> userBuys) {
        ArrayList<User> users = new ArrayList<>();
        int size = userBuys.size();
        int id = 0;
        try (Connection connection = DriverManager.getConnection(RequestParameter.URL_DB, RequestParameter.USER_DB, RequestParameter.PASSWORD_DB);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID_BY_NAME)) {
            Class.forName("com.mysql.jdbc.Driver");
            for (int i = 0; i < size; i++) {
                id = userBuys.get(i).getUserId();
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String nameUser = resultSet.getString(2);
                    String passwordUser = resultSet.getString(3);
                    String gmailUser = resultSet.getString(4);
                    String token = resultSet.getString(5);
                    User user = new User(id, nameUser, passwordUser, gmailUser, token);
                    users.add(user);
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public void insertUser(User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(RequestParameter.URL_DB, RequestParameter.USER_DB, RequestParameter.PASSWORD_DB);
                 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getToken());
                preparedStatement.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
