package org.example.controller.command;

import org.example.DataBase.ProductDB;
import org.example.controller.CustomCommand;
import org.example.controller.PagePath;

import javax.servlet.http.HttpServletRequest;

public class InsertBeerInDB implements CustomCommand {
    @Override
    public String executeCommand(HttpServletRequest request) throws ClassNotFoundException {
        String page;
        String nameBeer = request.getParameter("nameBeer");
        String containerType = request.getParameter("containerType");
        double volumeContainerBeer = Double.parseDouble(request.getParameter("volumeContainerBeer"));
        String typeBeer = request.getParameter("typeBeer");
        double percentageOfAlcoholBeer = Double.parseDouble(request.getParameter("percentageOfAlcoholBeer"));
        int bitternessOfBeer = Integer.parseInt(request.getParameter("bitternessOfBeer"));
        int quantityOfBeer = Integer.parseInt(request.getParameter("quantityOfBeer"));
        ProductDB product = new ProductDB();
        product.insert(nameBeer, containerType, volumeContainerBeer, typeBeer, percentageOfAlcoholBeer, bitternessOfBeer, quantityOfBeer);
        page = PagePath.INSERT_BEER;
        return page;
    }
}
