package com.example.chatserver.config;

import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebSocketHandler extends TextWebSocketHandler {
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        // Handle incoming messages
//        System.out.println("Received: " + message.getPayload());
        
        // Example: Sending a response
        try {
            session.sendMessage(new TextMessage("Message received: " + message.getPayload()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
