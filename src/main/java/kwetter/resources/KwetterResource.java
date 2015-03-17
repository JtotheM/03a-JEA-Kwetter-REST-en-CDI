package kwetter.resources;

import kwetter.dao.UserDAO;
import kwetter.domain.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
public class KwetterResource {
    @Inject
    private UserDAO userDAO;

    @POST
    @Path("/create")
    @Produces("application/json")
    public Response create(User user) {
        userDAO.create(user);
        return Response.ok(user).build();
    }

    @PUT
    @Path("/edit")
    @Produces("application/json")
    public Response edit(User user) {
        if (userDAO.find(user.getName()) == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("User not found").build();
        }

        userDAO.edit(user);
        return Response.ok().build();
    }

    @PUT
    @Path("/remove")
    @Produces("text/plain")
    public Response remove(User user) {
        if (userDAO.find(user.getName()) == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("User not found").build();
        }

        userDAO.remove(user);
        return Response.ok().entity("Removed user " + user.getName()).build();
    }

    @GET
    @Path("/find/{username}")
    @Produces("application/json")
    public Response find(@PathParam("username") String username) {
        User user = userDAO.find(username);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("User not found").build();
        }

        return Response.ok(user).build();
    }

    @GET
    @Path("/findAll")
    @Produces("application/json")
    public Response findAll() {
        List<User> userList = userDAO.findAll();
        return Response.ok(new GenericEntity<List<User>>(userList) {
        }).build();
    }

    @GET
    @Path("/count")
    @Produces("text/plain")
    public Response count() {
        return Response.ok(userDAO.count()).build();
    }
}
