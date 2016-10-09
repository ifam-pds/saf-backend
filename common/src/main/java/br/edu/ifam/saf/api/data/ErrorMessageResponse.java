package br.edu.ifam.saf.api.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ErrorMessageResponse {
    private List<String> messages = new ArrayList<>();


    public ErrorMessageResponse(String... messages) {
        this.messages.addAll(Arrays.asList(messages));
    }


    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
