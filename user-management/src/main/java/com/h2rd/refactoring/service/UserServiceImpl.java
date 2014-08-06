package com.h2rd.refactoring.service;

import com.h2rd.refactoring.dataAccess.UserDAO;
import com.h2rd.refactoring.model.User;
import com.h2rd.refactoring.validation.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Nguyen Tan Nguyen < nguyenabap at gmail dot com >
 * Date: 2014-08-05
 * Time: 11:25 PM
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserValidationService userValidationService;

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User addUser(User user) {
        userValidationService.validateForUserCreation(user);
        userDao.saveUser(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        userValidationService.validateForUserUpdate(user);
        userDao.updateUser(user);
        return user;
    }

    @Override
    public void deleteUser(User user) {
        userValidationService.validateForUserDeletion(user);
        userDao.deleteUser(user);
    }

    @Override
    public User findUserByName(String name) {
        userValidationService.validateForUserFinding(name);
        return userDao.findUser(name);
    }
}
