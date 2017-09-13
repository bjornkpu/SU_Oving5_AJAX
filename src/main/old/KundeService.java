package kunde;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Path("/kunder/")
public class KundeService {
	private static Map<String,Kunde> kunder = new HashMap<String,Kunde>();

    @GET
    @Path("/{kundeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Kunde getKunde(@PathParam("kundeId") String kundeId) {
        if(kunder.containsKey(kundeId)){
            return kunder.get(kundeId);
        } else {
            throw new javax.ws.rs.NotFoundException();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Kunde> getKunder() {
        return kunder.values();
    }

    @DELETE
    @Path("/{kundeId}")
    public void delKunde(@PathParam("kundeId") String id) {
        kunder.remove(id);
    }

    @PUT
    @Path("/{kundeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updKunde(@PathParam("kundeId") String id, Kunde kunde) {
        if(kunder.containsKey(id)){
            kunder.put(kunde.getId(), kunde);
        }else{
            throw new javax.ws.rs.NotFoundException();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addKunde(Kunde kunde) {
        kunder.put(kunde.getId(), kunde);
    }


}
