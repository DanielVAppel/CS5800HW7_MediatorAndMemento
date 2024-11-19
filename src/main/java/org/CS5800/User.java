package org.CS5800;

// User.java
import java.util.Date;
import java.util.Stack;

public class User {
    private final String name;
    private final ChatServer server;
    private final Stack<MessageMemento> sentMessages = new Stack<>();
    private final ChatHistory chatHistory = new ChatHistory();

    public User(String name, ChatServer server) {
        this.name = name;
        this.server = server;
        this.server.registerUser(this);
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String recipient, String content) {
        Message message = new Message(name, recipient, content, new Date());
        sentMessages.push(new MessageMemento(message));
        server.sendMessage(name, recipient, content);
    }

    public void undoLastMessage() {
        if (!sentMessages.isEmpty()) {
            MessageMemento lastMemento = sentMessages.pop();
            System.out.println("Undoing message: " + lastMemento.getContent());
        } else {
            System.out.println("No messages to undo.");
        }
    }

    public void receiveMessage(Message message) {
        System.out.println(name + " received message: " + message.getContent());
    }

   public ChatHistory getChatHistory() {
       return chatHistory;
   }
}