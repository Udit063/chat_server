package controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/chat")  // Listen for messages on /app/chat
    @SendTo("/topic/messages")  // Broadcast the message to all subscribers of /topic/messages
    public String handleChatMessage(@Payload String message) {
        return message;  // Respond back with the received message
    }
}
