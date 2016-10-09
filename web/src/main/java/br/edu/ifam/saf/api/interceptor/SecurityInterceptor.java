package br.edu.ifam.saf.api.interceptor;

import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ServerResponse;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;

public class SecurityInterceptor implements ContainerRequestFilter {

    private static final String AUTHORIZATION_PROPERTY = "Token";
    private static final ServerResponse ACCESS_DENIED = new ServerResponse("Access denied", 403, new Headers<>());

    @Override
    public void filter(ContainerRequestContext requestContext) {
        final MultivaluedMap<String, String> headers = requestContext.getHeaders();
        final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);

        if (authorization == null || authorization.isEmpty()) {
            requestContext.abortWith(ACCESS_DENIED);
            return;
        }
        //Get token
        final String token = authorization.get(0);

//        Usuario usuario = userDao.findByToken(token);

//        if (usuario == null) {
//            requestContext.abortWith(ACCESS_DENIED);
//        }

    }
}
