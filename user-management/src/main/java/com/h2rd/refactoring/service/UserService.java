package com.h2rd.refactoring.service;

import com.h2rd.refactoring.model.User;

import java.util.List;

/**
 * User: Nguyen Tan Nguyen < nguyenabap at gmail dot com >
 * Date: 2014-08-05
 * Time: 11:18 PM
 */
public interface UserService {
    List<User> getUsers();
    User addUser(User user);
    User updateUser(User user);
    void deleteUser(User user);
    User findUserByName(String name);
}
