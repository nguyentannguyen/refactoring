package com.h2rd.refactoring.resource;

import com.h2rd.refactoring.dataAccess.UserDAO;
import com.h2rd.refactoring.model.User;
import com.h2rd.refactoring.model.builder.UserBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.ws.rs.core.Response;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:test-applicationContext.xml")
public class UserResourceTest {

    @Autowired
    private UserResource userResource;

    @Autowired
    private UserDAO userDAO;

    @Test
    public void getUsersTest() {
        Response response = userResource.getUsers();
        assertThat("Status 200", response.getStatus(), is(200));
    }

    @Test
    public void addUserTest() {
        Response response = userResource.addUser("Nguyen Tan Nguyen", "nguyenabap@gmail.com", Arrays.asList("admin", "master"));
        User newUser = (User) response.getEntity();
        assertThat("Check email", newUser.getEmail(), is("nguyenabap@gmail.com"));
    }

    @Test
    public void updateUserTest() {
        User user = new UserBuilder()
                .setName("Test update user")
                .setEmail("fake@email.com")
                .setRoles(Arrays.asList("admin", "master"))
                .build();
        userDAO.saveUser(user);

        Response response = userResource.updateUser("Test update user", "nguyenabap@gmail.com", Arrays.asList("admin", "master"));
        User updatedUser = (User) response.getEntity();
        assertThat("Check email", updatedUser.getEmail(), is("nguyenabap@gmail.com"));
    }

    @Test
    public void deleteUserTest() {
        User user = new UserBuilder()
                .setName("Test delete user")
                .setEmail("fake@email.com")
                .setRoles(Arrays.asList("admin", "master"))
                .build();
        userDAO.saveUser(user);

        userResource.deleteUser("Test delete user", null, null);
        User deletedUser = userDAO.findUser("Test delete user");
        assertThat("Check if user deleted", deletedUser, nullValue());
    }

    @Test
    public void findUserByNameTest() {
        User user = new UserBuilder()
                .setName("Test find user by name")
                .setEmail("fake@email.com")
                .setRoles(Arrays.asList("admin", "master"))
                .build();
        userDAO.saveUser(user);

        Response response = userResource.findUser("Test find user by name");
        User found = (User) response.getEntity();
        assertThat("Check email", found.getEmail(), is("fake@email.com"));
    }

}
