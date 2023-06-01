
package Huffman_Coding;

import java.util.*;

class HuffmanNode implements Comparable<HuffmanNode> {
    char character;
    int frequency;
    HuffmanNode leftChild;
    HuffmanNode rightChild;

    public HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    public HuffmanNode(char character, int frequency, HuffmanNode leftChild, HuffmanNode rightChild) {
        this.character = character;
        this.frequency = frequency;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public boolean isLeaf() {
        return (leftChild == null && rightChild == null);
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }
}

class HuffmanCoding {
    public static Map<Character, String> encode(String text) {
        Map<Character, Integer> frequencyMap = buildFrequencyMap(text);
        HuffmanNode root = buildHuffmanTree(frequencyMap);
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

    private static HuffmanNode buildHuffmanTree(Map<Character, Integer> frequencyMap) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.offer(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            HuffmanNode leftChild = pq.poll();
            HuffmanNode rightChild = pq.poll();
            HuffmanNode parent = new HuffmanNode('\0', leftChild.frequency + rightChild.frequency, leftChild,
                    rightChild);
            pq.offer(parent);
        }

        return pq.poll();
    }

    private static Map<Character, String> buildCodeMap(HuffmanNode root) {
        Map<Character, String> codeMap = new HashMap<>();
        buildCodeMapRecursive(root, "", codeMap);
        return codeMap;
    }

    private static void buildCodeMapRecursive(HuffmanNode node, String code, Map<Character, String> codeMap) {
        if (node.isLeaf()) {
            codeMap.put(node.character, code);
        } else {
            buildCodeMapRecursive(node.leftChild, code + "0", codeMap);
            buildCodeMapRecursive(node.rightChild, code + "1", codeMap);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // user input logic add
        /*
         * Scanner scanner = new Scanner(System.in);
         * System.out.print("Enter the text to encode: ");
         * String text = scanner.nextLine();
         */
        String text = "Hi";
        Map<Character, String> codeMap = encode(text);
        Map<Character, Integer> frequencyMap = buildFrequencyMap(text);

        System.out.println("Character\tFrequency\tCode");
        for (Map.Entry<Character, String> entry : codeMap.entrySet()) {
            System.out.println(entry.getKey() + "\t\t" + frequencyMap.get(entry.getKey()) + "\t\t" + entry.getValue());
        }
    }
}
