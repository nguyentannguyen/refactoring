package com.h2rd.refactoring.dao;

import com.h2rd.refactoring.exception.DAOException;
import com.h2rd.refactoring.model.User;
import com.h2rd.refactoring.model.builder.UserBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:test-applicationContext.xml")
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    private User user;

    @Before
    public void before(){
        user = new UserBuilder()
                    .setName("Fake Name")
                    .setEmail("fake@email.com")
                    .setRoles(Arrays.asList("admin", "master"))
                    .build();
    }

    @Test
    public void getUsersTest() {
        userDAO.getUsers();
    }

    @Test
    public void saveUserTest() {
        userDAO.saveUser(user);
    }

    @Test
    public void updateUserTest() {
        userDAO.updateUser(user);
    }

    @Test
    public void deleteUserTest() {
        userDAO.deleteUser(user);
    }

    @Test
    public void findUserTest() {
        try{
            User deletedUser = userDAO.findUser("abc");
        }catch (DAOException e){
            assertThat("Could not find the user", e.getMessage(), containsString("Could not find the user"));
        }
    }
}