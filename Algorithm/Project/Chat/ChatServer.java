import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer extends JFrame {
    private JTextArea chatArea;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader in;

    public ChatServer() {
        setTitle("Chat Server");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        chatArea = new JTextArea();
        chatArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(chatArea);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setSize(500, 300);
       // pack();
        setLocationRelativeTo(null);
        setVisible(true);

        establishConnection();
    }

    private void establishConnection() {
        try {
            int serverPort = 5001; // Change to the port number on which the server should listen

            // Create a ServerSocket and start listening for client connections
            serverSocket = new ServerSocket(serverPort);
            chatArea.append("Waiting for a connection...\n");

            // Accept the client connection
            clientSocket = serverSocket.accept();
            chatArea.append("Connection established.\n");

            new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            receiveMessages();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void receiveMessages() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                chatArea.append("Received message: " + message + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChatServer::new);
    }
}
