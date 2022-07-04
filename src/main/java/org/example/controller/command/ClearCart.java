package org.example.controller.command;

import org.example.controller.CustomCommand;
import org.example.controller.PagePath;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class ClearCart implements CustomCommand {
    @Override
    public String executeCommand(HttpServletRequest request) throws ClassNotFoundException {
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("buyProduct", null);
        String page;
        page = PagePath.PRODUCT_CART;
        return page;
    }
}
