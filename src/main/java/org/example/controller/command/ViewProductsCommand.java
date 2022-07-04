package org.example.controller.command;

import org.example.DataBase.ProductDB;
import org.example.controller.CustomCommand;
import org.example.controller.PagePath;
import org.example.service.Beer;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class ViewProductsCommand implements CustomCommand {
    @Override
    public String executeCommand(HttpServletRequest request) throws ClassNotFoundException {
        String page;
        ProductDB product = new ProductDB();
        ArrayList<Beer> products = null;
        products = product.select();
        request.setAttribute("products", products);
        page = PagePath.VIEW_BEER;
        return page;
    }
}
