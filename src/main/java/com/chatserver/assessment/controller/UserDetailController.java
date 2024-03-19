package src.main.java.com.chatserver.assessment.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserDetailController {
    
    // Hardcoded username and password for basic authentication
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";
    
    // User authentication with basic username/password login
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            // Authentication successful
            return "Authentication successful";
        } else {
            // Authentication failed
            throw new RuntimeException("Authentication failed");
        }
    }
}
