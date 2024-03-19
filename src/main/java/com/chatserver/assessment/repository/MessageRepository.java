package src.main.java.com.chatserver.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import src.main.java.com.chatserver.assessment.dto.ChatRoom;
import src.main.java.com.chatserver.assessment.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
	 List<Message> findAllByChatRoom(ChatRoom chatRoom);
}
