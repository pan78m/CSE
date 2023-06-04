package Pattern_Matching;

import java.util.ArrayList;
import java.util.List;

public class KMP {
    public static void main(String[] args) {
        int[] pattern = {1, 2, 3};
        int[] text = {5, 1, 2, 3, 4, 1, 2, 3, 6};

        List<Integer> indices = KMPMethod(pattern, text);
        if (!indices.isEmpty()) {
            System.out.println("Pattern found at indices: " + indices);
        } else {
            System.out.println("Pattern not found in the text.");
        }
    }

    public static List<Integer> KMPMethod(int[] pattern, int[] text) {
        int patternSize = pattern.length;
        int textSize = text.length;

        int[] lps = computeLPS(pattern);

        List<Integer> indices = new ArrayList<>();
        int i = 0;  // index for text[]
        int j = 0;  // index for pattern[]

        while (i < textSize) {
            if (pattern[j] == text[i]) {
                j++;
                i++;
            }

            if (j == patternSize) {
                indices.add(i - j);  // pattern found, store the starting index
                j = lps[j - 1];  // continue searching for more occurrences
            } else if (i < textSize && pattern[j] != text[i]) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }

        return indices;
    }

    private static int[] computeLPS(int[] pattern) {
        int patternSize = pattern.length;
        int[] lps = new int[patternSize];
        int len = 0;  // length of the previous longest prefix suffix
        int i = 1;

        while (i < patternSize) {
            if (pattern[i] == pattern[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
