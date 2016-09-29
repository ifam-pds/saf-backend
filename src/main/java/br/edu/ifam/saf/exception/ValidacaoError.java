package br.edu.ifam.saf.exception;

/**
 * Exception com mensagem de erro user friendly
 */
public class ValidacaoError extends RuntimeException {

    /**
     * @param message mensagem de erro que deve ser mostrada ao usuário
     */
    public ValidacaoError(String message) {
        super(message);
    }

}
