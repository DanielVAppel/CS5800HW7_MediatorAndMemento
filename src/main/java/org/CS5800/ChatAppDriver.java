package org.CS5800;

public class ChatAppDriver {
    public static void main(String[] args) {
        ChatServer server = new ChatServer();

        User alice = new User("Alice", server);
        User bob = new User("Bob", server);
        User charlie = new User("Charlie", server);

        // Example: Sending a message
        alice.sendMessage("Bob", "Hello Bob!");
        bob.sendMessage("Alice", "Hi Alice!");

        // Example: Undoing a message
        alice.undoLastMessage();

        // Example: Blocking a user
        server.blockUser("Bob", "Alice");
        alice.sendMessage("Bob", "Message won't be received by Bob.");

    // Example: Chat history
        System.out.println("Alice's chat history:");
        for (Message message : alice.getChatHistory().getMessages()) {
            System.out.println(message.getContent());
        }

}}
