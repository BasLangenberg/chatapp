package nl.homecooked.chatapp.usecase.api;

import java.time.LocalDateTime;

public class Message {
    private LocalDateTime dateTime;
    private String user;
    private String value;

    public Message(LocalDateTime dateTime, String user, String value) {
        this.dateTime = dateTime;
        this.user = user;
        this.value = value;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getUser() {
        return user;
    }

    public String getValue() {
        return value;
    }
}
