package com.poc.rest;

import com.poc.ListTemp;
import com.poc.model.dto.UserDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;


@Path("/user")
@Produces({
        MediaType.APPLICATION_JSON,
        MediaType.TEXT_PLAIN
})
public class UserResource {

    @GET
    public Response findAll() {
        return Response
                .ok()
                .entity(ListTemp.getUsers())
                .build();
    }

    @GET()
    @Path("/{userId}")
    public Response find(@PathParam("userId") long userId) {
        List<UserDTO> users = ListTemp
                .getUsers()
                .stream()
                .filter(f -> f.getUserId() == userId)
                .collect(Collectors.toList());

        return Response
                .ok()
                .entity(users)
                .build();
    }

    @POST
    public Response create(UserDTO user) {
        ListTemp.addUser(user);
        return Response.ok().build();
    }

    @PUT
    public Response update(UserDTO user) {
        ListTemp.updateUser(user);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{userId}")
    public Response delete(@PathParam("userId")long userId) {
        ListTemp.deleteUser(userId);
        return Response.ok().entity("Test").build();
    }
}
