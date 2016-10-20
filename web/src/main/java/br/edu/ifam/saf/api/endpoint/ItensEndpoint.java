package br.edu.ifam.saf.api.endpoint;


import br.edu.ifam.saf.api.data.ItensResponse;
import br.edu.ifam.saf.api.dto.ItemDTO;
import br.edu.ifam.saf.api.dto.ItemTransformer;
import br.edu.ifam.saf.api.util.Respostas;
import br.edu.ifam.saf.dao.ItemDAO;
import br.edu.ifam.saf.exception.ValidacaoError;
import br.edu.ifam.saf.modelo.Item;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;

@Stateless
@Path("/itens")
public class ItensEndpoint {

    @Inject
    private ItemTransformer itemTransformer;
    
    @Inject
    private ItemDAO dao;
    
    @Inject
    private Logger log;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response itens() {
        return Response.ok().entity(new ItensResponse(
                itemTransformer.toDTOList(dao.listarTodos()))
        ).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response cadastrar(ItemDTO itemDTO){
        try {
//            Item itemExistente = ItemDAO.consultarPorModelo(usuarioDTO.getEmail());
//
//
//            if (usuarioExistente != null) {
//                return Respostas.USUARIO_JA_EXISTE;
//            }

            Item itemACadastrar = itemTransformer.toEntity(itemDTO);
            dao.atualizar(itemACadastrar);

            log.info(">>>" + itemACadastrar);

            return Respostas.criado();

        } catch (ValidacaoError ex) {
            return Respostas.badRequest(ex.getMensagemErroResponse());
        } catch (Exception ex) {
            ex.printStackTrace();
            return Respostas.ERRO_INTERNO;
        }

    }
    
}