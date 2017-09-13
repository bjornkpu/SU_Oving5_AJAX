package services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author nilstes
 */
@Path("/thepath/")
public class AService {
    static String melding = "Hei!";

    @GET 
    @Produces(MediaType.TEXT_PLAIN) 
    public String getSomething() { 
        return melding;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postSomething(String melding) {
        System.out.println(melding);
        this.melding = melding;
    }
}
