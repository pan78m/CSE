package LIS_LCS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommonSubsequences {
    public static void main(String[] args) {
        String s1 = "ABCDEF";
        String s2 = "ACDF";
        List<String> commonSubsequences = findCommonSubsequences(s1, s2);
        Collections.sort(commonSubsequences, (a, b) -> b.length() - a.length()); // Sort in descending order of lengths
        System.out.println("Common Subsequences (in descending order of lengths):");
        for (String subsequence : commonSubsequences) {
            System.out.println(subsequence);
        }
    }

    public static List<String> findCommonSubsequences(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        List<String>[][] dp = new ArrayList[m + 1][n + 1];

        // Initialize the table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = new ArrayList<>();
            }
        }

        // Build the table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    for (String subseq : dp[i - 1][j - 1]) {
                        dp[i][j].add(subseq + s1.charAt(i - 1));
                    }
                } else {
                    dp[i][j].addAll(dp[i - 1][j]);
                    dp[i][j].addAll(dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
