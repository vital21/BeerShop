package org.example.controller.command;

import org.example.DataBase.ProductDB;
import org.example.controller.CustomCommand;
import org.example.controller.PagePath;
import org.example.service.Beer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class AddBeerToBuyPage implements CustomCommand {
    @Override
    public String executeCommand(HttpServletRequest request) throws ClassNotFoundException {
        String page;

        int id = Integer.parseInt(request.getParameter("productId"));
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("productId", id);
        Beer products = null;
        ProductDB productDB = new ProductDB();
        products = productDB.selectById(id);
        request.setAttribute("products", products);
        page = PagePath.ADD_BEER_TO_BUY_PAGE;

        return page;
    }
}
