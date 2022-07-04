package org.example.controller.command;

import org.example.DataBase.ProductDB;
import org.example.DataBase.UserBuyDb;
import org.example.controller.CustomCommand;
import org.example.controller.PagePath;
import org.example.service.ProductBuy;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class BuyProductCart implements CustomCommand {
    @Override
    public String executeCommand(HttpServletRequest request) throws ClassNotFoundException {
        String page;
        ServletContext servletContext = request.getServletContext();
        ArrayList<ProductBuy> buyProduct = new ArrayList<ProductBuy>();
        buyProduct = (ArrayList<ProductBuy>) servletContext.getAttribute("buyProduct");
        ArrayList<ProductBuy> buyProducts = new ArrayList<>(buyProduct);
        ProductDB productDB = new ProductDB();
        productDB.editQuantityBuy(buyProducts);
        int idUser = (int) servletContext.getAttribute("idUser");
        UserBuyDb userBuyDb = new UserBuyDb();

        userBuyDb.insertUserBuy(idUser, buyProduct);
        servletContext.setAttribute("buyProduct", null);
        page = PagePath.PRODUCT_CART;
        return page;
    }

}
