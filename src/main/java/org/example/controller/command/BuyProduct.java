package org.example.controller.command;

import org.example.DataBase.ProductDB;
import org.example.controller.CustomCommand;
import org.example.controller.PagePath;
import org.example.service.Beer;
import org.example.service.ProductBuy;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class BuyProduct implements CustomCommand {
    @Override
    public String executeCommand(HttpServletRequest request) throws ClassNotFoundException {
        String page;
        ServletContext servletContext = request.getServletContext();
        if (servletContext.getAttribute("buyProduct") != null) {
            request.setAttribute("products", ForOutProductCart(servletContext));
        }
        page = PagePath.PRODUCT_CART;
        return page;
    }

    private ArrayList<Beer> ForOutProductCart(ServletContext servletContext) {
        ArrayList<ProductBuy> productsBuy = new ArrayList<>();
        ProductBuy productBuy;
        ArrayList<Beer> products = new ArrayList<>();
        productsBuy = (ArrayList<ProductBuy>) servletContext.getAttribute("buyProduct");
        int sizeProductsBuy = productsBuy.size();
        ProductDB productDB = new ProductDB();
        int id;
        Beer beer;
        for (int i = 0; i < sizeProductsBuy; i++) {
            productBuy = productsBuy.get(i);
            id = productBuy.getId();
            beer = productDB.selectById(id);
            products.add(beer);
        }
        return products;
    }

}
