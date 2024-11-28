package com.example.chatserver.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "chats") // MongoDB collection
public class Chat {
    @Id
    private String id;
    private String content;
    private String userId;
    private String username;
    private String serverId;
    private String channelId;

    // Constructors
    public Chat() {}

    public Chat(String content, String userId, String username, String serverId, String channelId) {
        this.content = content;
        this.userId = userId;
        this.username = username;
        this.serverId = serverId;
        this.channelId = channelId;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
