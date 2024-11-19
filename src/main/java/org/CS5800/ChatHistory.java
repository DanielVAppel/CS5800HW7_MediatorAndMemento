package org.CS5800;

// ChatHistory.java
import java.util.*;

public class ChatHistory {
        private final List<Message> messages = new ArrayList<>();

        public void addMessage(Message message) {
            messages.add(message);
        }

        public List<Message> getMessages() {
            return new ArrayList<>(messages);
        }
}
