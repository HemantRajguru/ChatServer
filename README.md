**Chat Server**
This is a simple chat server implemented in Java using Spring Boot framework. The chat server allows users to join a chat room, send messages, and access chat history. 
It includes features such as user authentication, message persistence, RESTful endpoints for message sending and retrieval, and WebSocket support for real-time communication.

**Features**
User Authentication: Basic username/password login mechanism for user authentication. Credentials are hardcoded for demonstration purposes.
Chat Room Creation: Upon server startup, a single chat room is created.
Persistent Storage: Chat messages are stored in a database for persistence using Spring Data JPA.
RESTful Endpoints: Provides endpoints for sending and retrieving messages via HTTP requests.
WebSocket Support: Real-time chat communication is enabled using WebSocket protocol for efficient and low-latency messaging.
Message Deletion: Users can delete their own messages from the chat room.

**Technologies Used**
Java
Spring Boot
Spring Data JPA
WebSocket
MySQL (or any preferred relational database)
**Getting Started**
To run the chat server locally, follow these steps:

Clone this repository to your local machine.
Set up a MySQL database and configure the connection details in application.properties.
Build the project using Maven: mvn clean install.
Run the application: java -jar target/chat-server.jar.
The chat server will be accessible at http://localhost:8080.

**Usage**
Use any REST client (e.g., Postman) to send messages to the chat room via RESTful endpoints.
For real-time communication, establish WebSocket connections to ws://localhost:8080/chat.

**Contributing**
Contributions are welcome! Feel free to open issues or submit pull requests for any improvements or bug fixes.
