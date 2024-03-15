

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ChatServerApplication.java {

    public static void main(String args[]) {
        SpringApplication.run(ChatServerApplication.java.class, args);
    }
}
