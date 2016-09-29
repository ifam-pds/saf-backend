package br.edu.ifam.saf.api;

import br.edu.ifam.saf.api.data.ErrorMessageData;

import javax.ws.rs.core.Response;

public final class Responses {

    public static Response badRequest(ErrorMessageData messageData) {
        return Response.status(Response.Status.BAD_REQUEST).entity(messageData).build();
    }

    public static Response created() {
        return Response.status(Response.Status.CREATED).build();
    }

    public static Response ok() {
        return Response.ok().build();
    }



}
