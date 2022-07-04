package org.example.controller.command;

import org.example.DataBase.UserDb;
import org.example.controller.CustomCommand;
import org.example.controller.PagePath;
import org.example.controller.RequestParameter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements CustomCommand {
    @Override
    public String executeCommand(HttpServletRequest request) {
        String page;
        int idUser;
        String login = request.getParameter(RequestParameter.LOGIN);
        request.setAttribute("userName", login);
        String password = request.getParameter(RequestParameter.PASSWORD);
        UserDb userDb = new UserDb();
        idUser = userDb.selectIdUserByName(login);
        if (login.equals("vitaliy") && idUser != 0) {

            page = PagePath.ADMIN_MENU;
        } else {
            page = PagePath.USER_MENU;
            ServletContext servletContext = request.getServletContext();
            servletContext.setAttribute("buyProduct", null);
            idUser = userDb.selectIdUserByName(login);
            servletContext.setAttribute("idUser", idUser);
        }
        return page;
    }
}
