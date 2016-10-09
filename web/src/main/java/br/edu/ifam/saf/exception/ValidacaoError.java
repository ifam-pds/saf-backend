package br.edu.ifam.saf.exception;

import br.edu.ifam.saf.api.data.ErrorMessageResponse;

/**
 * Exception com mensagem de erro user friendly
 */
public class ValidacaoError extends RuntimeException {

    private final ErrorMessageResponse errorMessageResponse;

    public ValidacaoError(ErrorMessageResponse errorMessageResponse) {
        this.errorMessageResponse = errorMessageResponse;
    }

    public ErrorMessageResponse getErrorMessageResponse() {
        return errorMessageResponse;
    }
}
