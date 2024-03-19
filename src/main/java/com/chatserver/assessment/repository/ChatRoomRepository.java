package src.main.java.com.chatserver.assessment.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import src.main.java.com.chatserver.assessment.dto.ChatRoom;


public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    // You can define custom query methods here if needed
}
