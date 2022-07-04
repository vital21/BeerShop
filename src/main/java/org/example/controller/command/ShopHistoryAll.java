package org.example.controller.command;

import org.example.DataBase.UserBuyDb;
import org.example.controller.CustomCommand;
import org.example.controller.PagePath;
import org.example.service.Beer;
import org.example.service.User;
import org.example.service.UserBuy;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class ShopHistoryAll implements CustomCommand {
    @Override
    public String executeCommand(HttpServletRequest request) throws ClassNotFoundException {
        ArrayList<UserBuy> userBuys = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Beer> beers = new ArrayList<>();
        int a = 2;
        int b = 3;
        int c = a + b;
        UserBuyDb userBuyDb = new UserBuyDb();
        userBuyDb.selectUserAndBuyBeer(userBuys, beers, users);
        request.setAttribute("userBuys", userBuys);
        request.setAttribute("beers", beers);
        request.setAttribute("users", users);
        String page;
        page = PagePath.SHOP_HISTORY_ALL;
        return page;
    }
}
