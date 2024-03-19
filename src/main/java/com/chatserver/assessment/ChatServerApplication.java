package src.main.java.com.chatserver.assessment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ChatServerApplication {

    public static void main(String args[]) {
        SpringApplication.run(ChatServerApplication.class, args);
    }
}
