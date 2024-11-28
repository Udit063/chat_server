package com.example.chatserver.repository;

import com.example.chatserver.model.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ChatRepository extends MongoRepository<Chat, String> {

    // Find all chats by a specific user ID
    List<Chat> findByUserId(String userId);

    // Find all chats in a specific channel
    List<Chat> findByChannelId(String channelId);

    // Find all chats in a specific server
    List<Chat> findByServerId(String serverId);

    // Find chats containing specific content (case-insensitive)
    List<Chat> findByContentContainingIgnoreCase(String content);

    // Find all chats from a specific user in a given channel
    List<Chat> findByUserIdAndChannelId(String userId, String channelId);

    // Find chats by server and channel
    List<Chat> findByServerIdAndChannelId(String serverId, String channelId);

    // Custom query to find chats with a specific keyword
    @Query("{'content': { $regex: ?0, $options: 'i' }}") // 'i' makes it case-insensitive
    List<Chat> searchByContentKeyword(String keyword);

    // Custom query to find recent chats in a channel, sorted by creation time (assuming a "timestamp" field)
    @Query(value = "{ 'channelId': ?0 }", sort = "{ 'timestamp': -1 }")
    List<Chat> findRecentChatsInChannel(String channelId);

    // Custom query to find chats by username
    @Query("{ 'username': ?0 }")
    List<Chat> findByUsername(String username);

    // Custom query to find chats between a specific date range (assuming a "timestamp" field)
    @Query("{ 'timestamp': { $gte: ?0, $lte: ?1 } }")
    List<Chat> findChatsByDateRange(String startDate, String endDate);
}
