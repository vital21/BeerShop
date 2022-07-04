package org.example.controller;

import javax.servlet.http.HttpServletRequest;

public interface CustomCommand {
    String executeCommand(HttpServletRequest request) throws ClassNotFoundException;
}
