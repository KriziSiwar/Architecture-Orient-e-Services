
package rest.ressources;

import rest.entities.logement;
import rest.metiers.LogementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("Logements")
public class logementRessource {
    private static LogementBusiness Lgb = new LogementBusiness();

    /* @GET
     @Produces(MediaType.APPLICATION_JSON)
     @Path("getall")
     public Response getAll()
             //response pour tous les types de return
     {if(Lgb.getLogements().isEmpty())
         return Response.status(Response.Status.NOT_FOUND).entity("la liste est vide").build();
         return Response.status(Response.Status.OK).entity(Lgb.getLogements()).build();
     }*/
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_JSON)
    // consumes pour le serveur return une chose de type complexe
    public Response addLogement(logement L) {
        if (Lgb.getLogements().add(L))
            return Response.status(Response.Status.CREATED).entity(Lgb.getLogements()).build();
        return Response.status(Response.Status.NOT_FOUND).build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLogementbydelegation(@QueryParam("delegation")
                                            String del) {
        if (del != null) {
            if (Lgb.getLogementsByDeleguation(del).size() == 0)
                return Response.status(404).entity("aucun logement pour cette delegation").build();
            return Response.status(200).entity(Lgb.getLogementsByDeleguation(del)).build();
        } else
        {
            if (Lgb.getLogements().isEmpty())
                return Response.status(Response.Status.NOT_FOUND).entity("la liste est vide").build();
            return Response.status(Response.Status.OK).entity(Lgb.getLogements()).build();
        }
    }
    @DELETE
    @Path("{reference}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteLogement(@PathParam("reference")     int ref)
    {
        if(Lgb.deleteLogement(ref))
            return Response.status(Response.Status.FOUND).entity(Lgb.getLogements()).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @PUT
    @Path("{ref}")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateLogement(@PathParam("ref") int r, logement L) {
        if (Lgb.updateLogement(r, L)) {
            return Response.status(Response.Status.FOUND).entity(Lgb.getLogements()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
