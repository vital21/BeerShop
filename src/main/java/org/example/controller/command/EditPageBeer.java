package org.example.controller.command;

import org.example.controller.CustomCommand;
import org.example.controller.PagePath;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class EditPageBeer implements CustomCommand {
    @Override
    public String executeCommand(HttpServletRequest request) throws ClassNotFoundException {
        String page;
        ServletContext servletContext = request.getServletContext();
        int id = Integer.parseInt(request.getParameter("productId"));
        servletContext.setAttribute("productsId", id);
        page = PagePath.EDIT_BEER;
        return page;
    }
}
