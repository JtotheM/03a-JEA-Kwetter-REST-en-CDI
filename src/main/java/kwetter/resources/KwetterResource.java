package kwetter.resources;

import kwetter.domain.User;
import kwetter.service.KwetterService;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
public class KwetterResource {
    private KwetterService kwetterService = new KwetterService();

    @POST
    @Path("/create")
    @Produces("application/json")
    public Response create(User user) {
        kwetterService.create(user);
        return Response.ok(user).build();
    }

    @PUT
    @Path("/edit")
    @Produces("application/json")
    public Response edit(User user) {
        if (kwetterService.find(user.getName()) == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("User not found").build();
        }

        kwetterService.edit(user);
        return Response.ok().build();
    }

    @PUT
    @Path("/remove")
    @Produces("text/plain")
    public Response remove(User user) {
        if (kwetterService.find(user.getName()) == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("User not found").build();
        }

        kwetterService.remove(user);
        return Response.ok().entity("Removed user " + user.getName()).build();
    }

    @GET
    @Path("/find/{username}")
    @Produces("application/json")
    public Response find(@PathParam("username") String username) {
        User user = kwetterService.find(username);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("User not found").build();
        }

        return Response.ok(user).build();
    }

    @GET
    @Path("/findAll")
    @Produces("application/json")
    public Response findAll() {
        List<User> userList = kwetterService.findAll();
        return Response.ok(new GenericEntity<List<User>>(userList) {
        }).build();
    }

    @GET
    @Path("/count")
    @Produces("text/plain")
    public Response count() {
        return Response.ok(kwetterService.count()).build();
    }
}
