package org.example.DataBase;

import org.example.controller.RequestParameter;
import org.example.service.Beer;
import org.example.service.ProductBuy;
import org.example.service.User;
import org.example.service.UserBuy;

import java.sql.*;
import java.util.ArrayList;

public class UserBuyDb implements UserBuyDataBase {
    private static final String INSERT_BUY_IN_DB = "INSERT INTO user_buy (user_id,beer_id,quantity,date) VALUES(?,?,?,?)";
    private static final String SELECT_USER_BUY = "SELECT * FROM user_buy WHERE user_id=?";
    private static final String SELECT_ALL = "SELECT * FROM user_buy";
    private static final String SELECT_USER_AND_BUY_BEER = "SELECT * FROM user_buy,users,beer WHERE user_buy.user_id=users.id and user_buy.beer_id=beer.id";

    @Override
    public void insertUserBuy(int userId, ArrayList<ProductBuy> productBuy) {
        try {
            int size = productBuy.size();
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(RequestParameter.URL_DB, RequestParameter.USER_DB, RequestParameter.PASSWORD_DB);
                 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BUY_IN_DB)) {
                java.sql.Date date = new Date(new java.util.Date().getTime());
                for (int i = 0; i < size; i++) {
                    preparedStatement.setInt(1, userId);
                    preparedStatement.setInt(2, productBuy.get(i).getId());
                    preparedStatement.setInt(3, productBuy.get(i).getQuantity());
                    preparedStatement.setDate(4, date);
                    preparedStatement.executeUpdate();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<UserBuy> selectUserBuyById(int idUser) {
        ArrayList<UserBuy> userBuys = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(RequestParameter.URL_DB, RequestParameter.USER_DB, RequestParameter.PASSWORD_DB);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BUY)) {
            Class.forName("com.mysql.jdbc.Driver");
            preparedStatement.setInt(1, idUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt(1);
                int beerId = resultSet.getInt(2);
                int quantity = resultSet.getInt(3);
                String date = resultSet.getString(4);
                UserBuy product = new UserBuy(userId, beerId, quantity, date);
                userBuys.add(product);
            }


        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return userBuys;
    }

    @Override
    public ArrayList<UserBuy> selectAll() {
        ArrayList<UserBuy> userBuys = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(RequestParameter.URL_DB, RequestParameter.USER_DB, RequestParameter.PASSWORD_DB);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            Class.forName("com.mysql.jdbc.Driver");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt(1);
                int beerId = resultSet.getInt(2);
                int quantity = resultSet.getInt(3);
                String date = resultSet.getString(4);
                UserBuy product = new UserBuy(userId, beerId, quantity, date);
                userBuys.add(product);
            }


        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return userBuys;
    }

    @Override
    public void selectUserAndBuyBeer(ArrayList<UserBuy> userBuys, ArrayList<Beer> beers, ArrayList<User> users) {
        try (Connection connection = DriverManager.getConnection(RequestParameter.URL_DB, RequestParameter.USER_DB, RequestParameter.PASSWORD_DB);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_AND_BUY_BEER)) {
            Class.forName("com.mysql.jdbc.Driver");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt(1);
                int beerId = resultSet.getInt(2);
                int quantity = resultSet.getInt(3);
                String date = resultSet.getString(4);
                UserBuy product = new UserBuy(userId, beerId, quantity, date);
                userBuys.add(product);
                String userName = resultSet.getString(6);
                String passwordUser = resultSet.getString(7);
                String gmailUser = resultSet.getString(8);
                String tokenUser = resultSet.getString(9);
                User user = new User(userId, userName, passwordUser, gmailUser, tokenUser);
                users.add(user);
                String nameBeer = resultSet.getString(11);
                String containerType = resultSet.getString(12);
                double volume = resultSet.getDouble(13);
                String typeBeer = resultSet.getString(14);
                double alc = resultSet.getDouble(15);
                int bitterness = resultSet.getInt(16);
                int quantityBeer = resultSet.getInt(17);
                Beer beer = new Beer(beerId, nameBeer, containerType, volume, typeBeer, alc, bitterness, quantityBeer);
                beers.add(beer);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
