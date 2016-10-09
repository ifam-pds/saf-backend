package br.edu.ifam.saf.api.endpoint;

import br.edu.ifam.saf.api.data.LoginData;
import br.edu.ifam.saf.api.data.MensagemErroResponse;
import br.edu.ifam.saf.api.dto.UsuarioDTO;
import br.edu.ifam.saf.api.dto.UsuarioTransformer;
import br.edu.ifam.saf.api.util.Respostas;
import br.edu.ifam.saf.api.util.Validation;
import br.edu.ifam.saf.dao.UsuarioDAO;
import br.edu.ifam.saf.exception.ValidacaoError;
import br.edu.ifam.saf.modelo.Perfil;
import br.edu.ifam.saf.modelo.Usuario;
import br.edu.ifam.saf.util.SegurancaUtil;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usuario")
@Stateless
public class UsuarioEndpoint {

    @Inject
    private UsuarioDAO usuarioDAO;

    @Inject
    private UsuarioTransformer usuarioTransformer;


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response login(LoginData loginData) {
        try {
            Validation.validaLogin(loginData);

            Usuario usuario = usuarioDAO.consultarPorEmail(loginData.getEmail());


            if (usuario == null || !SegurancaUtil.verificaSenha(loginData.getSenha(), usuario.getSenha())) {
                return Respostas.EMAIL_OU_SENHA_INCORRETOS;
            }
            if (StringUtils.isBlank(usuario.getToken())) {
                usuario.setToken(SegurancaUtil.gerarToken());
            }

            return Respostas.ok(usuarioTransformer.toDTO(usuario));

        } catch (ValidacaoError ex) {
            return Respostas.badRequest(new MensagemErroResponse(ex.getMessage()));
        }

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/cadastrar")
    public Response cadastrar(UsuarioDTO usuarioDTO) {
        try {
            Validation.validaRegistroUsuario(usuarioDTO);

            Usuario usuarioExistente = usuarioDAO.consultarPorEmail(usuarioDTO.getEmail());


            if (usuarioExistente != null) {
                return Respostas.USUARIO_JA_EXISTE;
            }

            Usuario usuarioACadastrar = usuarioTransformer.toEntity(usuarioDTO);
            usuarioACadastrar.setPerfil(Perfil.CLIENTE);
            usuarioACadastrar.setSenha(SegurancaUtil.hashSenha(usuarioACadastrar.getSenha()));

            usuarioDAO.inserir(usuarioACadastrar);

            return Respostas.criado();

        } catch (ValidacaoError ex) {
            return Respostas.badRequest(ex.getMensagemErroResponse());
        } catch (Exception ex) {
            ex.printStackTrace();
            return Respostas.ERRO_INTERNO;
        }

    }
}