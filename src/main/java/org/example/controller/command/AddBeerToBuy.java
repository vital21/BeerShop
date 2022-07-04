package org.example.controller.command;

import org.example.DataBase.ProductDB;
import org.example.controller.CustomCommand;
import org.example.controller.PagePath;
import org.example.service.Beer;
import org.example.service.ProductBuy;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class AddBeerToBuy implements CustomCommand {

    @Override
    public String executeCommand(HttpServletRequest request) throws ClassNotFoundException {
        String page;
        ServletContext servletContext = request.getServletContext();
        int id = (int) servletContext.getAttribute("productId");
        Beer products = null;
        ProductDB productDB = new ProductDB();
        products = productDB.selectById(id);
        request.setAttribute("products", products);
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        //todo прооверка на кол-пива в базе
        Beer beer = null;
        ContextArrayProduct(id, servletContext, quantity);
        page = PagePath.ADD_BEER_TO_BUY_PAGE;
        return page;
    }

    private void ContextArrayProduct(int id, ServletContext servletContext, int quantity) {
        ArrayList<ProductBuy> productsBuy = new ArrayList<>();
        if (servletContext.getAttribute("buyProduct") != null)
            productsBuy = (ArrayList<ProductBuy>) servletContext.getAttribute("buyProduct");
        ProductBuy newProductBue = new ProductBuy(id, quantity);
        productsBuy.add(newProductBue);
        servletContext.setAttribute("buyProduct", productsBuy);
    }
}
