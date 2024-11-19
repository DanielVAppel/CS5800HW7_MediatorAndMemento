// Unit Tests for Mediator and Memento
import org.CS5800.ChatServer;
import org.CS5800.Message;
import org.CS5800.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ChatAppTest {
    @Test
    public void testSendMessageAndReceive() {
        ChatServer server = new ChatServer();
        User user1 = new User("Alice", server);
        User user2 = new User("Bob", server);

        user1.sendMessage("Bob", "Hello Bob!");
        // Expected: Bob should receive the message "Hello Bob!"
    }

    @Test
    public void testUndoLastMessage() {
        ChatServer server = new ChatServer();
        User user1 = new User("Alice", server);

        user1.sendMessage("Bob", "Message 1");
        user1.undoLastMessage();
        // Expected: Alice undoes the last message "Message 1"
    }

    @Test
    public void testBlockUser() {
        ChatServer server = new ChatServer();
        User user1 = new User("Alice", server);
        User user2 = new User("Bob", server);

        server.blockUser("Bob", "Alice");
        user1.sendMessage("Bob", "Hello Bob!");
        // Expected: Bob does not receive the message because Alice is blocked.
    }
    @Test
    public void testChatHistory() {
        ChatServer server = new ChatServer();
        User user1 = new User("Alice", server);
        User user2 = new User("Bob", server);

        user1.sendMessage("Bob", "Hello Bob!");
        user1.sendMessage("Bob", "How are you?");
        List<Message> history = user1.getChatHistory().getMessages();

        assertEquals(2, history.size());
        assertEquals("Hello Bob!", history.get(0).getContent());
        assertEquals("How are you?", history.get(1).getContent());
    }
}
