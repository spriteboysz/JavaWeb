package com.deean.service;

import com.deean.dao.UserDAO;
import com.deean.dto.User;

/**
 * Author: Deean
 * Date: 2023-10-29 10:46
 * FileName: src/main/java/com/deean/service
 * Description:
 */

public class UserService {
    public User checkLogin(String userName, String userPassword) {
        UserDAO userDAO = new UserDAO();
        User user = userDAO.queryUser(userName);
        if (user == null || !user.getUserPassword().equals(userPassword)) {
            return null;
        } else {
            return user;
        }
    }
}
