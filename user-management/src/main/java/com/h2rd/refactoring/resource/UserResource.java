package com.h2rd.refactoring.resource;

import com.h2rd.refactoring.model.User;
import com.h2rd.refactoring.model.builder.UserBuilder;
import com.h2rd.refactoring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Component
public class UserResource{

    @Autowired
    private UserService userService;

    @GET
    @Path("/find")
    public Response getUsers() {
        GenericEntity<List<User>> usersEntity = new GenericEntity<List<User>>(userService.getUsers()) {};
        return Response.status(200).entity(usersEntity).build();
    }

    @POST
    @Path("/add")
    public Response addUser(@QueryParam("name") String name,
                            @QueryParam("email") String email,
                            @QueryParam("role") List<String> roles) {

        User user = new UserBuilder()
                        .setName(name)
                        .setEmail(email)
                        .setRoles(roles)
                        .build();

        User newUser = userService.addUser(user);
        return Response.ok().entity(newUser).build();
    }

    @PUT
    @Path("/update")
    public Response updateUser(@QueryParam("name") String name,
                               @QueryParam("email") String email,
                               @QueryParam("role") List<String> roles) {

        User user = new UserBuilder()
                        .setName(name)
                        .setEmail(email)
                        .setRoles(roles)
                        .build();

        User updatedUser = userService.updateUser(user);
        return Response.ok().entity(updatedUser).build();
    }

    @DELETE
    @Path("/delete")
    public Response deleteUser(@QueryParam("name") String name,
                               @QueryParam("email") String email,
                               @QueryParam("role") List<String> roles) {
        User user = new UserBuilder()
                        .setName(name)
                        .setEmail(email)
                        .setRoles(roles)
                        .build();

        userService.deleteUser(user);
        return Response.ok().entity(user).build();
    }

    @GET
    @Path("/search")
    public Response findUser(@QueryParam("name") String name) {
        User user = userService.findUserByName(name);
        return Response.ok().entity(user).build();
    }
}
