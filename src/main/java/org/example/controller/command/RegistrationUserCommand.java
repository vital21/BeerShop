package org.example.controller.command;

import org.example.DataBase.UserDb;
import org.example.controller.CustomCommand;
import org.example.controller.PagePath;
import org.example.controller.RequestParameter;
import org.example.service.User;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

public class RegistrationUserCommand implements CustomCommand {
    @Override
    public String executeCommand(HttpServletRequest request) {
        String page;
        String email = request.getParameter(RequestParameter.EMAIL);
        String password = request.getParameter(RequestParameter.PASSWORD);
        String login = request.getParameter(RequestParameter.LOGIN);
        String token = "";
        token = generationToken(login, token);
        User user = new User(login, password, email, token);
        UserDb userDb = new UserDb();
        userDb.insertUser(user);
        page = PagePath.LOGIN;
        return page;
    }

    String generationToken(String name, String token) {
        name = "-b466-4d03-ac41-430ec92868";
        UUID uuid = UUID.fromString(name);
        token = uuid.toString();
        return token;
    }
}
