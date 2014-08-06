package com.h2rd.refactoring.dataAccess;

import com.h2rd.refactoring.exception.DAORuntimeException;
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
            throw new DAORuntimeException(e.getMessage());
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
            throw new DAORuntimeException(e.getMessage());
        }
        return null;
    }
}
