package org.example.DataBase;

import org.example.service.Beer;
import org.example.service.ProductBuy;
import org.example.service.User;
import org.example.service.UserBuy;

import java.util.ArrayList;

public interface UserBuyDataBase {
    void insertUserBuy(int userId, ArrayList<ProductBuy> productBuy);

    ArrayList<UserBuy> selectUserBuyById(int idUser);

    ArrayList<UserBuy> selectAll();

    void selectUserAndBuyBeer(ArrayList<UserBuy> userBuys, ArrayList<Beer> beers, ArrayList<User> users);
}
