package com.h2rd.refactoring.dataAccess;

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
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:test-applicationContext.xml")
public class UserDAOTest {

    @Autowired
    private UserDAO userDao;

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
        userDao.getUsers();
    }

    @Test
    public void saveUserTest() {
        userDao.saveUser(user);
    }

    @Test
    public void updateUserTest() {
        userDao.updateUser(user);
    }

    @Test
    public void deleteUserTest() {
        userDao.deleteUser(user);
    }

    @Test
    public void findUserTest() {
        userDao.findUser("Fake Name");
    }
}