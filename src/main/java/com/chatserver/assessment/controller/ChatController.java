package src.main.java.com.chatserver.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import src.main.java.com.chatserver.assessment.dto.ChatRoom;
import src.main.java.com.chatserver.assessment.entity.Message;
import src.main.java.com.chatserver.assessment.repository.ChatRoomRepository;
import src.main.java.com.chatserver.assessment.repository.MessageRepository;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

 private final MessageRepository messageRepository;
 private final ChatRoomRepository chatRoomRepository;
 private final SimpMessagingTemplate messagingTemplate;
 private ChatRoom chatRoom;

 @Autowired
 public ChatController(MessageRepository messageRepository, SimpMessagingTemplate messagingTemplate,ChatRoomRepository chatRoomRepository) {
     this.messageRepository = messageRepository;
     this.chatRoomRepository = chatRoomRepository;
     this.messagingTemplate = messagingTemplate;
     this.chatRoom = new ChatRoom("Main Chat Room"); // Initialize the chat room
 }

 // REST endpoint for setting the chat room
 @PutMapping("/room")
 public String setChatRoom(@RequestParam String name) {
     this.chatRoom.setName(name);
     return "Chat room updated successfully";
 }

 // REST endpoint for getting the chat room
 @GetMapping("/room")
 public ChatRoom getChatRoom() {
     return chatRoom;
 }



//REST endpoint for sending messages
@PostMapping("/send")
public String sendMessage(@RequestParam String message) {
  Message newMessage = new Message();
  newMessage.setContent(message);
  
  // Check if the chat room is already saved in the database
  if(chatRoom.getId() == null) {
      // If not saved, save it first
      chatRoomRepository.save(chatRoom); // Assuming you have a repository for ChatRoom
  }
  
  newMessage.setChatRoom(chatRoom); // Set the chat room for the message
  messageRepository.save(newMessage); // Save the message to the database

  // Send the new message to all subscribed WebSocket clients
  messagingTemplate.convertAndSend("/topic/messages", newMessage);

  return "Message sent successfully";
}

 // REST endpoint for retrieving messages
 @GetMapping("/history")
 public List<Message> getChatHistory() {
     return messageRepository.findAllByChatRoom(chatRoom);
 }

 // REST endpoint for deleting a message
 @DeleteMapping("/delete/{messageId}")
 public String deleteMessage(@PathVariable Long messageId) {
     messageRepository.deleteById(messageId);
     return "Message deleted successfully";
 }
 // WebSocket endpoint for sending messages
 @MessageMapping("/send")
 @SendTo("/topic/messages")
 public Message sendWebSocketMessage(@Payload Message message) {
     // Set the chat room for the message
     message.setChatRoom(chatRoom);
     // Save message to the database
     messageRepository.save(message);
     return message;
 }
}
