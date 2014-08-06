package com.h2rd.refactoring.dao;

import com.h2rd.refactoring.exception.DAOException;
import com.h2rd.refactoring.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDAOImpl implements UserDAO{

    public ArrayList<User> users;

    public UserDAOImpl(){
        users = new ArrayList<User>();
    }

    public void saveUser(User user) {
        users.add(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void deleteUser(User userToDelete) {
        User user = findUser(userToDelete.getName());
        if (user!=null){
            users.remove(user);
        }
    }

    public void updateUser(User userToUpdate) {
        try{
            for (User user : users) {
                if (user.getName().equals(userToUpdate.getName())) {
                    user.setEmail(userToUpdate.getEmail());
                    user.setRoles(userToUpdate.getRoles());
                }
            }
        }
        catch(Exception e){
            throw new DAOException(e.getMessage());
        }
    }

    public User findUser(String name) {
        try{
            for (User user : users) {
                if (user.getName().equals(name)) {
                    return user;
                }
            }
        }
        catch(Exception e){
            throw new DAOException(e.getMessage());
        }
        throw new DAOException("Could not find the user: '" + name + "'");
    }
}
