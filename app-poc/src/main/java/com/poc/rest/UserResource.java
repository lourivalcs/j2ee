package com.poc.rest;

import com.poc.ListTemp;
import com.poc.model.dto.UserDTO;
import com.poc.model.entity.UserEntity;
import com.poc.repository.UserRepository;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.*;
import java.util.Map;

@Path("/user")
@Produces({
        MediaType.APPLICATION_JSON
})
public class UserResource {

    @Inject
    UserRepository userRepository;

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
        return Response
                .ok()
                .entity(ListTemp.findUsers(userId))
                .build();
    }

    @POST
    public Response create(@Valid UserDTO user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userRepository.insert(userEntity);
        ListTemp.addUser(user);
        return Response.ok().build();
    }

    @PUT
    public Response update(@Valid UserDTO user) {
        ListTemp.updateUser(user);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{userId}")
    public Response delete(@PathParam("userId") long userId) {
        ListTemp.deleteUser(userId);
        return Response.ok().build();
    }

    @GET
    @Path("findWithQueryString")
    public Response findWithQueryString(
            @DefaultValue("1") @QueryParam("userId") long userId
    ) {
        return Response
                .ok()
                .entity(ListTemp.findUsers(userId))
                .build();
    }

    @GET
    @Path("/getPathParameters")
    public Response getPathParameters(@Context UriInfo ui) {
        MultivaluedMap<String, String> pathParams = ui.getPathParameters();

        return Response
                .ok()
                .entity(pathParams)
                .build();
    }

    @GET
    @Path("/getQueryParameters")
    public Response getQueryParameters(@Context UriInfo ui) {
        MultivaluedMap<String, String> pathParams = ui.getQueryParameters();

        return Response
                .ok()
                .entity(pathParams)
                .build();
    }

    @GET
    @Path("/getHeaderParams")
    public Response getHeaderParams(@Context HttpHeaders hh) {
        MultivaluedMap<String, String> headerParams = hh.getRequestHeaders();

        return Response
                .ok()
                .entity(headerParams)
                .build();
    }

    @GET
    @Path("/getCookies")
    public Response getCookies(@Context HttpHeaders hh) {
        Map<String, Cookie> pathParams = hh.getCookies();

        return Response
                .ok()
                .entity(pathParams)
                .build();
    }

    @GET
    @Path("/random")
    public Response requestAnotherRest() {
        Client client = ClientBuilder.newClient();

        String obj = client
                .target("https://randomuser.me/api/?results=10")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);

        client.close();

        return Response
                .ok()
                .entity(obj)
                .build();
    }

    @GET
    @Path("/findWithEmail/{firstname}.{lastname}@{domain}.com")
    public Response subresource(@PathParam("firstname") String firstname, @PathParam("lastname") String lastname, @PathParam("domain") String domain) {
        String stringComplete = firstname + " | " + lastname + " | " + domain;
        return Response
                .ok()
                .entity(stringComplete)
                .build();
    }

}
