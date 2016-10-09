package br.edu.ifam.saf.api;


import br.edu.ifam.saf.api.data.ItemsResponse;
import br.edu.ifam.saf.api.dto.ItemTransformer;
import br.edu.ifam.saf.modelo.Item;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Stateless
public class ItensEndpoint {

    @Inject
    private ItemTransformer itemTransformer;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/itens")
    public Response itens() {
        return Response.ok().entity(new ItemsResponse(
                itemTransformer.toDTO(new Item("Jet Ski", 20.0)),
                itemTransformer.toDTO(new Item("Prancha", 5.0)))
        ).build();
    }
}