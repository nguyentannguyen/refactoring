package com.h2rd.refactoring.model.builder;

import com.h2rd.refactoring.model.User;

import java.util.List;

/**
 * User: Nguyen Tan Nguyen < nguyenabap at gmail dot com >
 * Date: 2014-08-05
 * Time: 11:36 PM
 */
public class UserBuilder {

    String name;
    String email;
    List<String> roles;

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setRoles(List<String> roles) {
        this.roles = roles;
        return this;
    }

    public User build(){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setRoles(roles);
        return user;
    }
}
