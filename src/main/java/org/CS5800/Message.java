package org.CS5800;

// Message.java
import java.util.Date;

public class Message {
    private final String content;
    public Date timestamp;

    public Message(String sender, String recipient, String content, Date timestamp) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}