package org.example.DataBase;

import org.example.controller.RequestParameter;
import org.example.service.Beer;
import org.example.service.ProductBuy;

import java.sql.*;
import java.util.ArrayList;


public class ProductDB implements ProductDataBase {
    private ArrayList<Beer> List;

    public ArrayList<Beer> getList() {
        return List;
    }

    public void setList(ArrayList<Beer> list) {
        List = list;
    }

    private static final String SELECT_ALL_BEER = "SELECT * FROM beer";
    private static final String INSERT_BEER = "INSERT INTO beer (nameBeer,container_type,volume_container_beer,type_beer,percentage_of_alcohol_beer,bitterness_of_beer,quantity_of_beer) VALUES(?,?,?,?,?,?,?)";

    private static final String EDIT_BEER = "UPDATE beer SET volume_container_beer=?, quantity_of_beer =? WHERE id = ?";
    private static final String UPDATE_QUANTITY = "UPDATE beer SET quantity_of_beer = ? WHERE id = ?";
    private static final String SELECT_QUANTITY = "SELECT quantity_of_beer FROM beer WHERE id=?";
    private static final String SELECT_BEER_BY_ID = "SELECT * FROM beer WHERE id=?";

    @Override
    public ArrayList<Beer> select() throws ClassNotFoundException {
        ArrayList<Beer> products = new ArrayList<Beer>();


        try (Connection connection = DriverManager.getConnection(RequestParameter.URL_DB, RequestParameter.USER_DB, RequestParameter.PASSWORD_DB);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(ProductDB.SELECT_ALL_BEER)) {
            Class.forName("com.mysql.jdbc.Driver");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String nameBeer = resultSet.getString(2);
                String containerType = resultSet.getString(3);
                double volumeContainerBeer = resultSet.getDouble(4);
                String typeBeer = resultSet.getString(5);
                ;
                double percentageOfAlcoholBeer = resultSet.getDouble(6);
                ;
                int bitternessOfBeer = resultSet.getInt(7);
                int quantityOfBeer = resultSet.getInt(8);
                Beer product = new Beer(id, nameBeer, containerType, volumeContainerBeer, typeBeer, percentageOfAlcoholBeer, bitternessOfBeer, quantityOfBeer);
                products.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public Beer selectById(int id) {
        Beer product = null;
        try (Connection connection = DriverManager.getConnection(RequestParameter.URL_DB, RequestParameter.USER_DB, RequestParameter.PASSWORD_DB);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BEER_BY_ID)) {
            Class.forName("com.mysql.jdbc.Driver");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id2 = resultSet.getInt(1);
                String nameBeer = resultSet.getString(2);
                String containerType = resultSet.getString(3);
                double volumeContainerBeer = resultSet.getDouble(4);
                String typeBeer = resultSet.getString(5);
                ;
                double percentageOfAlcoholBeer = resultSet.getDouble(6);
                ;
                int bitternessOfBeer = resultSet.getInt(7);
                int quantityOfBeer = resultSet.getInt(8);
                product = new Beer(id2, nameBeer, containerType, volumeContainerBeer, typeBeer, percentageOfAlcoholBeer, bitternessOfBeer, quantityOfBeer);
            }


        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public int edit(int id, double volumeContainerBeer, int quantityOfBeer) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(RequestParameter.URL_DB, RequestParameter.USER_DB, RequestParameter.PASSWORD_DB);
                 PreparedStatement preparedStatement = connection.prepareStatement(EDIT_BEER)) {
                preparedStatement.setDouble(1, volumeContainerBeer);
                preparedStatement.setInt(2, quantityOfBeer);
                preparedStatement.setInt(3, id);
                return preparedStatement.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int insert(String nameBeer, String containerType, double volumeContainerBeer, String typeBeer, double percentageOfAlcoholBeer, int bitternessOfBeer, int quantityOfBeer) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(RequestParameter.URL_DB, RequestParameter.USER_DB, RequestParameter.PASSWORD_DB);
                 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BEER)) {
                preparedStatement.setString(1, nameBeer);
                preparedStatement.setString(2, containerType);
                preparedStatement.setDouble(3, volumeContainerBeer);
                preparedStatement.setString(4, typeBeer);
                preparedStatement.setDouble(5, percentageOfAlcoholBeer);
                preparedStatement.setInt(6, bitternessOfBeer);
                preparedStatement.setInt(7, quantityOfBeer);
                return preparedStatement.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editQuantityBuy(ArrayList<ProductBuy> productBuy) {
        try {
            int size = productBuy.size();
            int buf_quantity = 0;
            ProductBuy bufProductBuy;
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(RequestParameter.URL_DB, RequestParameter.USER_DB, RequestParameter.PASSWORD_DB)) {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUANTITY);
                for (int i = 0; i < size; i++) {
                    int quantityOfBeer = productBuy.get(i).getQuantity();
                    preparedStatement.setInt(1, productBuy.get(i).getId());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        buf_quantity = resultSet.getInt(1);
                        buf_quantity = buf_quantity - quantityOfBeer;
                        bufProductBuy = new ProductBuy(productBuy.get(i).getId(), buf_quantity);
                        productBuy.set(i, bufProductBuy);
                    }
                }
                preparedStatement = connection.prepareStatement(UPDATE_QUANTITY);
                for (int i = 0; i < size; i++) {
                    preparedStatement.setInt(1, productBuy.get(i).getQuantity());
                    preparedStatement.setInt(2, productBuy.get(i).getId());
                    preparedStatement.executeUpdate();
                }

            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void deleteById() {

    }


}
