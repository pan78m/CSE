package Huffman_Coding;

import java.util.*;

public class Com_Fre implements Comparable<Com_Fre> {

    char character;
    int frequency;
    Com_Fre leftChild;
    Com_Fre rightChild;

    public Com_Fre(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    public Com_Fre(char character, int frequency, Com_Fre leftChild, Com_Fre rightChild) {
        this.character = character;
        this.frequency = frequency;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public boolean isLeaf() {
        return (leftChild == null && rightChild == null);
    }

    @Override
    public int compareTo(Com_Fre other) {
        return this.frequency - other.frequency;
    }
}

class HCompress {
    public static Map<Character, String> encode(char[] characters, int[] frequencies) {
        if (characters.length != frequencies.length) {
            throw new IllegalArgumentException(
                    "Invalid input! The number of characters and frequencies must be the same.");
        }

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < characters.length; i++) {
            frequencyMap.put(characters[i], frequencies[i]);
        }

        Com_Fre root = buildHuffmanTree(frequencyMap);
        Map<Character, String> codeMap = buildCodeMap(root);
        return codeMap;
    }

    private static Map<Character, Integer> buildFrequencyMap(char[] characters) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : characters) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }
    

    private static Com_Fre buildHuffmanTree(Map<Character, Integer> frequencyMap) {
        PriorityQueue<Com_Fre> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.offer(new Com_Fre(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            Com_Fre leftChild = pq.poll();
            Com_Fre rightChild = pq.poll();
            Com_Fre parent = new Com_Fre('\0', leftChild.frequency + rightChild.frequency, leftChild,
                    rightChild);
            pq.offer(parent);
        }

        return pq.poll();
    }

    private static Map<Character, String> buildCodeMap(Com_Fre root) {
        Map<Character, String> codeMap = new HashMap<>();
        buildCodeMapRecursive(root, "", codeMap);
        return codeMap;
    }

    private static void buildCodeMapRecursive(Com_Fre node, String code, Map<Character, String> codeMap) {
        if (node.isLeaf()) {
            codeMap.put(node.character, code);
        } else {
            buildCodeMapRecursive(node.leftChild, code + "0", codeMap);
            buildCodeMapRecursive(node.rightChild, code + "1", codeMap);
        }
    }

    public static void main(String[] args) {
        // String text = "Hi";
        char[] characters = { 'A', 'B', 'C', 'D','E' };
        int[] frequencies = { 6, 6, 3, 2,3 };

        Map<Character, String> codeMap = encode(characters, frequencies);
        Map<Character, Integer> frequencyMap = buildFrequencyMap(characters);
       // System.out.println(characters.length);
        int normalCodeLength = characters.length * 8; // Assuming 8 bits per character
        int compressedCodeLength = 0;

       // System.out.println("Character\tFrequency\tCode");
        System.out.println("Character\tCode");
        for (Map.Entry<Character, String> entry : codeMap.entrySet()) {
            char character = entry.getKey();
            int frequency = frequencyMap.get(character);
            String code = entry.getValue();
           // System.out.println(character + "\t\t" +frequency + "\t\t" + code);
            System.out.println(character + "\t\t" + code);
            compressedCodeLength += frequency * code.length();
        }
        // Average Code length
        double averageCodeLength = (double) compressedCodeLength / characters.length;

        System.out.println("\nNormal Code Length: " + normalCodeLength + " bits");
        System.out.println("Compressed Code Length: " + compressedCodeLength + " bits");
        System.out.println("Average Code Length: " + averageCodeLength + " bits per character");
    }

}
