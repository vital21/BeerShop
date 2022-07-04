package org.example.controller.command;

import org.example.controller.CustomCommand;
import org.example.controller.PagePath;

import javax.servlet.http.HttpServletRequest;

public class AdminMenuPage implements CustomCommand {
    @Override
    public String executeCommand(HttpServletRequest request) throws ClassNotFoundException {
        String page;
        page = PagePath.ADMIN_MENU;
        return page;
    }
}
