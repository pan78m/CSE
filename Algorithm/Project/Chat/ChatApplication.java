//package Algorithm.Project.Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.PriorityQueue;
import java.util.HashMap;

public class ChatApplication extends JFrame {
    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private final String secretKey = "1234567891234567"; // Replace with your own secret key
    private int port;

    public ChatApplication() throws IOException {
        // GUI setup
        // JFrame frame;

        setTitle("Chat Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        // frame = new JFrame("Chat Application");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.add(new JTextArea());
        // frame.pack();
        // frame.setVisible(true);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        add(chatScrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        messageField = new JTextField();
        inputPanel.add(messageField, BorderLayout.CENTER);

        messageField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = messageField.getText();
                sendMessage(message);
                messageField.setText("");
            }
        });

        sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = messageField.getText();
                sendMessage(message);
                messageField.setText("");
            }
        });

        inputPanel.add(sendButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.SOUTH);

        // Establish connection
        establishConnection();
        pack();
        // setSize(500, 300);
        setVisible(true);
    }

    // connection

    private void establishConnection() throws IOException {
        try {
            int port = 3306; // Change to the port number on which the server should listen

            // Create a ServerSocket and start listening for client connections
            ServerSocket serverSocket = new ServerSocket(port);
            chatArea.append("Waiting for a connection...\n");

            // Accept the client connection
            clientSocket = serverSocket.accept();
            chatArea.append("Connection established.\n");

            // Create input and output streams for communication
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            receiveMessages();
            serverSocket.close();
        } catch (IOException e) {
            if (e instanceof BindException) {

                // The port is already in use, try to find a free port
                int nextPort = port + 1;
                ServerSocket serverSocket;
                while (true) {
                    try {
                        serverSocket = new ServerSocket(nextPort);
                        break;
                    } catch (BindException ex) {
                        nextPort++;
                    }
                }
                chatArea.append("Connection established on port " + nextPort + "\n");
                clientSocket = serverSocket.accept();
                chatArea.append("Connection established.\n");

                // Create input and output streams for communication
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                receiveMessages();
            } else {
                e.printStackTrace();
            }
        }
    }

    private void sendMessage(String message) {
        try {
            // Compress the message using Huffman coding
            String compressedMessage = compressMessage(message);

            // Encrypt the compressed message using AES
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encryptedMessage = cipher.doFinal(compressedMessage.getBytes());

            // Send the encrypted and compressed message over the socket to the receiver
            out.println(Base64.getEncoder().encodeToString(encryptedMessage));
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void receiveMessages() {
        try {
            String receivedMessage;
            while ((receivedMessage = in.readLine()) != null) {
                // Decrypt the received message using AES
                SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
                byte[] decryptedMessage = cipher.doFinal(Base64.getDecoder().decode(receivedMessage));

                // Decompress the decrypted message using Huffman coding
                String decompressedMessage = decompressMessage(new String(decryptedMessage));

                chatArea.append("Received: " + decompressedMessage + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String compressMessage(String message) {
        // Perform Huffman coding compression
        HashMap<Character, String> huffmanTable = buildHuffmanTable(message);
        StringBuilder compressedMessage = new StringBuilder();

        for (char c : message.toCharArray()) {
            compressedMessage.append(huffmanTable.get(c));
        }

        return compressedMessage.toString();
    }

    private String decompressMessage(String compressedMessage) {
        // Perform Huffman coding decompression
        HashMap<String, Character> huffmanTable = buildInverseHuffmanTable(compressedMessage);
        StringBuilder decompressedMessage = new StringBuilder();

        StringBuilder currentCode = new StringBuilder();
        for (char c : compressedMessage.toCharArray()) {
            currentCode.append(c);
            if (huffmanTable.containsKey(currentCode.toString())) {
                decompressedMessage.append(huffmanTable.get(currentCode.toString()));
                currentCode.setLength(0);
            }
        }

        return decompressedMessage.toString();
    }

    private HashMap<Character, String> buildHuffmanTable(String message) {
        // Build Huffman coding table
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : message.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (char c : frequencyMap.keySet()) {
            pq.offer(new Node(c, frequencyMap.get(c)));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node combined = new Node('\0', left.frequency + right.frequency, left, right);
            pq.offer(combined);
        }

        HashMap<Character, String> huffmanTable = new HashMap<>();
        buildHuffmanCodes(huffmanTable, pq.peek(), "");
        return huffmanTable;
    }

    private void buildHuffmanCodes(HashMap<Character, String> huffmanTable, Node node, String code) {
        if (node.isLeaf()) {
            huffmanTable.put(node.character, code);
        } else {
            buildHuffmanCodes(huffmanTable, node.left, code + '0');
            buildHuffmanCodes(huffmanTable, node.right, code + '1');
        }
    }

    private HashMap<String, Character> buildInverseHuffmanTable(String message) {
        // Build inverse Huffman coding table
        HashMap<Character, String> huffmanTable = buildHuffmanTable(message);
        HashMap<String, Character> inverseTable = new HashMap<>();
        for (Character c : huffmanTable.keySet()) {
            inverseTable.put(huffmanTable.get(c), c);
        }
        return inverseTable;
    }

    private static class Node implements Comparable<Node> {
        char character;
        int frequency;
        Node left;
        Node right;

        Node(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        Node(char character, int frequency, Node left, Node right) {
            this.character = character;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }

        boolean isLeaf() {
            return left == null && right == null;
        }

        @Override
        public int compareTo(Node other) {
            return this.frequency - other.frequency;
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                     new ChatApplication();
                } catch (IOException e) {
                   
                    e.printStackTrace();
                }

            }
        });
    }
}
