package br.edu.ifam.saf.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.mindrot.jbcrypt.BCrypt;

public class SegurancaUtil {
    /**
     * Número de rodadas. Total número de iterações = 2 ^ NUMERO_DE_RODADAS (1 - 31)
     */
    private static final int NUMERO_RODADAS = 12;

    /**
     * @param senhaPlaintext senha a ser feito o hash
     * @return hash + salt da senha informada
     */

    public static String hashSenha(String senhaPlaintext) {
        String gensalt = BCrypt.gensalt(NUMERO_RODADAS);
        System.out.println("salt: " + gensalt);
        return BCrypt.hashpw(senhaPlaintext, gensalt);
    }

    /**
     * @return `true` se a senha está correta, `false` se não está
     */
    public static boolean verificaSenha(String senhaPlaintext, String hashSenha) {
        if (null == hashSenha || !hashSenha.startsWith("$2a$")) {
            throw new java.lang.IllegalArgumentException("Hash inválido");
        }

        return BCrypt.checkpw(senhaPlaintext, hashSenha);
    }


    public static void main(String[] args) {

        String hash = hashSenha("123456");
        System.out.println("Test computed hash: " + hash);
        System.out.println("Mesma senha: " + verificaSenha("123456", hash));


    }

    public static String gerarToken() {
        return RandomStringUtils.randomAlphanumeric(64);
    }
}