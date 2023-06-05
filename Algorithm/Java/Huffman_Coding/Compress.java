package Huffman_Coding;

import java.util.*;

public class Compress implements Comparable<Compress> {

    char character;
    int frequency;
    Compress leftChild;
    Compress rightChild;

    public Compress(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    public Compress(char character, int frequency, Compress leftChild, Compress rightChild) {
        this.character = character;
        this.frequency = frequency;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public boolean isLeaf() {
        return (leftChild == null && rightChild == null);
    }

    @Override
    public int compareTo(Compress other) {
        return this.frequency - other.frequency;
    }
}

class HuCompress {
    public static Map<Character, String> encode(String text) {
        Map<Character, Integer> frequencyMap = buildFrequencyMap(text);
        Compress root = buildHuffmanTree(frequencyMap);
        Map<Character, String> codeMap = buildCodeMap(root);
        return codeMap;
    }

    private static Map<Character, Integer> buildFrequencyMap(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }

    private static Compress buildHuffmanTree(Map<Character, Integer> frequencyMap) {
        PriorityQueue<Compress> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.offer(new Compress(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            Compress leftChild = pq.poll();
            Compress rightChild = pq.poll();
            Compress parent = new Compress('\0', leftChild.frequency + rightChild.frequency, leftChild,
                    rightChild);
            pq.offer(parent);
        }

        return pq.poll();
    }

    private static Map<Character, String> buildCodeMap(Compress root) {
        Map<Character, String> codeMap = new HashMap<>();
        buildCodeMapRecursive(root, "", codeMap);
        return codeMap;
    }

    private static void buildCodeMapRecursive(Compress node, String code, Map<Character, String> codeMap) {
        if (node.isLeaf()) {
            codeMap.put(node.character, code);
        } else {
            buildCodeMapRecursive(node.leftChild, code + "0", codeMap);
            buildCodeMapRecursive(node.rightChild, code + "1", codeMap);
        }
    }

    public static void main(String[] args) {
        String text = "Hi";
        // char[] characters = { 'A', 'B', 'C', 'D' };
        // int[] frequencies = { 5, 2, 6, 3 };
        
        Map<Character, String> codeMap = encode(text);
        Map<Character, Integer> frequencyMap = buildFrequencyMap(text);
        System.out.println(text.length());
        int normalCodeLength = text.length() * 8; // Assuming 8 bits per character
        int compressedCodeLength = 0;

        System.out.println("Character\tFrequency\tCode");
        for (Map.Entry<Character, String> entry : codeMap.entrySet()) {
            char character = entry.getKey();
            int frequency = frequencyMap.get(character);
            String code = entry.getValue();
            System.out.println(character + "\t\t" + frequency + "\t\t" + code);
            compressedCodeLength += frequency * code.length();
        }
        // Average Code length
        double averageCodeLength = (double) compressedCodeLength / text.length();

        System.out.println("\nNormal Code Length: " + normalCodeLength + " bits");
        System.out.println("Compressed Code Length: " + compressedCodeLength + " bits");
        System.out.println("Average Code Length: " + averageCodeLength + " bits per character");
    }

}
