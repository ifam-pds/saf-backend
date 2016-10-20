package br.edu.ifam.saf.api.endpoint;

import br.edu.ifam.saf.api.data.CategoriasResponse;
import br.edu.ifam.saf.api.dto.CategoriaTransformer;
import br.edu.ifam.saf.dao.CategoriaDAO;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/categorias")
public class CategoriaEndpoint {
    
    @Inject
    CategoriaTransformer categoriaTransformer;
    
    @Inject
    CategoriaDAO dao;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response categorias() {
        return Response.ok().entity(new CategoriasResponse(
                categoriaTransformer.toDTOList(dao.listarTodos()))
        ).build();
    }
    
}
