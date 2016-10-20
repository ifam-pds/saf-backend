package br.edu.ifam.saf.api.endpoint;


import br.edu.ifam.saf.api.data.BairrosResponse;
import br.edu.ifam.saf.api.dto.BairroTransformer;
import br.edu.ifam.saf.dao.BairroDAO;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/bairros")
public class BairroEndpoint {

    @Inject
    private BairroTransformer bairroTransformer;

    @Inject
    private BairroDAO bairroDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response bairros() {

        return Response.ok().entity(
                new BairrosResponse(
                        bairroTransformer.toDTOList(bairroDAO.listarTodos())
                )

        ).build();
    }
}