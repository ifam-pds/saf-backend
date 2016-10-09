package br.edu.ifam.saf.api.util;

import br.edu.ifam.saf.api.data.ErrorMessageResponse;
import br.edu.ifam.saf.api.data.LoginData;
import br.edu.ifam.saf.api.dto.UsuarioDTO;
import br.edu.ifam.saf.exception.ValidacaoError;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.routines.EmailValidator;

public final class Validation {

    private static final String CAMPO_NAO_PODE_SER_VAZIO = "Campo \"%s\" não pode ser vazio";
    private static final String EMAIL_INVALIDO = "Email inválido";


    public static void validaLogin(LoginData loginData) throws ValidacaoError {

    }

    public static void validaRegistroUsuario(UsuarioDTO usuarioDTO) throws ValidacaoError {

        ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse();


        if (!EmailValidator.getInstance().isValid(usuarioDTO.getEmail())) {
            errorMessageResponse.getMessages().add(EMAIL_INVALIDO);
        }


        if (GenericValidator.isBlankOrNull(usuarioDTO.getSenha()) || usuarioDTO.getSenha().length() < 6) {
            errorMessageResponse.getMessages().add("A senha deve ter no mínimo 6 caracteres");
        }

        if (!errorMessageResponse.getMessages().isEmpty()) {
            throw new ValidacaoError(errorMessageResponse);
        }


    }
}