package src.main.java.com.chatserver.assessment.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import src.main.java.com.chatserver.assessment.dto.ChatRoom;

import javax.persistence.*;

@Entity
public class Message {
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 
 public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}
private String content;
 
 public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}
@ManyToOne
@JoinColumn(name = "chat_room_id") // Assuming this is the name of the foreign key column in the Message table
private ChatRoom chatRoom;

 
 // Getters and setters
 
 public ChatRoom getChatRoom() {
     return chatRoom;
 }

 public void setChatRoom(ChatRoom chatRoom) {
     this.chatRoom = chatRoom;
 }
}
