package nl.homecooked.chatapp.usecase.api;

public class AddMessageRequest {
    private String user;
    private String value;

    AddMessageRequest() {
    }

    public AddMessageRequest(String user, String value) {
        this.user = user;
        this.value = value;
    }

    public String getUser() {
        return user;
    }

    public String getValue() {
        return value;
    }
}
