package br.edu.ifam.saf.api.data;

public class ErrorMessageData {
    private String message;

    public ErrorMessageData(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
