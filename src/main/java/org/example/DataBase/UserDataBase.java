package org.example.DataBase;

import org.example.service.User;
import org.example.service.UserBuy;

import java.util.ArrayList;

public interface UserDataBase {
    int selectIdUserByName(String name);

    ArrayList<User> arrayUsers(ArrayList<UserBuy> userBuys);

    void insertUser(User user);
}
