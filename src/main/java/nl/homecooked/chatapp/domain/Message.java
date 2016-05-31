package nl.homecooked.chatapp.domain;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

public class Message {

    @Id
    private String id;
    private LocalDateTime dateTime;
    private String user;
    private String value;

    public Message(String user, String value) {
        this.id = UUID.randomUUID().toString();
        this.dateTime = LocalDateTime.now();
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
