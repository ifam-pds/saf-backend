package br.edu.ifam.saf.api;


import br.edu.ifam.saf.api.data.ErrorMessageData;
import br.edu.ifam.saf.api.data.ItemsData;
import br.edu.ifam.saf.api.data.LoginData;
import br.edu.ifam.saf.api.util.Validation;
import br.edu.ifam.saf.data.Item;
import br.edu.ifam.saf.exception.ValidacaoError;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.Arrays;

@Path("/")
@Stateless
public class ItensEndpoint {
    @POST
    @Consumes("application/json")
    @Path("/login")
    public Response login(LoginData loginData) {

        try {
            Validation.validaLogin(loginData);
            return Responses.created();

        } catch (ValidacaoError ex) {
            return Responses.badRequest(new ErrorMessageData(ex.getMessage()));
        }

    }

    @POST
    @Consumes("application/json")
    @Path("/itens")
    public Response itens() {
        return Response.ok().entity(new ItemsData(
                new Item("Jet Ski", 20.0),
                new Item("Prancha", 5.0))
        ).build();


    }
}