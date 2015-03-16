package kwetter.resources;

import kwetter.domain.User;
import kwetter.service.KwetterService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/user")
public class KwetterResource {
    private KwetterService kwetterService = new KwetterService();

    @GET
    @Path("/create")
    @Produces("application/json")
    public synchronized User create(User user) {
        kwetterService.create(user);
        return user;
    }

    @GET
    @Path("/edit")
    @Produces("application/json")
    public synchronized User edit(User user) {
        kwetterService.edit(user);
        return user;
    }

    @GET
    @Path("/remove")
    @Produces("text/plain")
    public synchronized String remove(User user) {
        kwetterService.remove(user);
        return "Removed " + user.toString();
    }

    @GET
    @Path("/findAll")
    @Produces("application/json")
    public synchronized List<User> findAll() {
        return kwetterService.findAll();
    }

    @GET
    @Path("/find")
    @Produces("application/json")
    public synchronized User find(Object id) {
        return kwetterService.find(id);
    }

    @GET
    @Path("/count")
    @Produces("application/json")
    public synchronized int count() {
        return kwetterService.count();
    }
}
