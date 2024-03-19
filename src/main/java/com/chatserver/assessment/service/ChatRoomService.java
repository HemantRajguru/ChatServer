package src.main.java.com.chatserver.assessment.service;

import org.springframework.stereotype.Service;

import src.main.java.com.chatserver.assessment.dto.ChatRoom;

@Service
public class ChatRoomService {
 private ChatRoom chatRoom;

 public ChatRoomService() {
     this.chatRoom = new ChatRoom("Main Chat Room");
 }

 public ChatRoom getChatRoom() {
     return chatRoom;
 }
}
