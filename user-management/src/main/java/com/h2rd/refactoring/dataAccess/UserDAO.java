package com.h2rd.refactoring.dataAccess;

import com.h2rd.refactoring.model.User;

import java.util.ArrayList;

/**
 * User: Nguyen Tan Nguyen < nguyenabap at gmail dot com >
 * Date: 2014-08-05
 * Time: 11:57 PM
 */
public interface UserDAO {
    public void saveUser(User user);
    public ArrayList<User> getUsers();
    public void deleteUser(User userToDelete);
    public void updateUser(User userToUpdate);
    public User findUser(String name);
}
