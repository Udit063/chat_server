package controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.chatserver.model.Chat;

@Controller
public class ChatController {

    @MessageMapping("/chat") // Maps to "/app/chat" from the frontend
    @SendTo("/topic/messages") // Sends to "/topic/messages" for subscribers
    public Chat receiveMessage(Chat message) {
        return message; // Echo the message back for verification
    }
}

