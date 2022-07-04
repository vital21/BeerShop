package org.example.controller.command;

import org.example.DataBase.ProductDB;
import org.example.controller.CustomCommand;
import org.example.controller.PagePath;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class EditBeer implements CustomCommand {
    @Override
    public String executeCommand(HttpServletRequest request) throws ClassNotFoundException {
        String page;
        double volumeContainerBeer = Double.parseDouble(request.getParameter("volumeContainerBeer"));
        int quantityOfBeer = Integer.parseInt(request.getParameter("quantityOfBeer"));
        ServletContext servletContext = request.getServletContext();
        int id = (int) servletContext.getAttribute("productsId");
        ProductDB productDB = new ProductDB();
        productDB.edit(id, volumeContainerBeer, quantityOfBeer);
        servletContext.removeAttribute("productsId");
        page = PagePath.EDIT_BEER;
        return page;
    }
}
