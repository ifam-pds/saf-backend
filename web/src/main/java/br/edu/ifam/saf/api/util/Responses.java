package br.edu.ifam.saf.api.util;

import br.edu.ifam.saf.api.data.ErrorMessageResponse;

import javax.ws.rs.core.Response;

public final class Responses {


    public static final Response EMAIL_OU_SENHA_INCORRETOS = badRequest(new ErrorMessageResponse("Email ou senha incorretos"));
    public static final Response USUARIO_JA_EXISTE = badRequest(new ErrorMessageResponse("Usuário já existe no banco de dados"));
    public static final Response ERRO_INTERNO = Response.serverError().build();

    public static Response badRequest(ErrorMessageResponse messageData) {
        return Response.status(Response.Status.BAD_REQUEST).entity(messageData).build();
    }

    public static Response created() {
        return Response.status(Response.Status.CREATED).build();
    }

    public static Response ok() {
        return Response.ok().build();
    }

    public static Response ok(Object entity) {
        return Response.ok().entity(entity).build();
    }


}
