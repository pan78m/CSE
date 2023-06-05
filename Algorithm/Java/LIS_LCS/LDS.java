package LIS_LCS;

public class LDS {
    public static int lds(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLength = 0;

        // Initialize the LDS lengths for all elements as 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Compute the LDS lengths from right to left
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // Find the maximum LDS length
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }
        // Print the LDS subsequence
        System.out.print("Longest Decreasing Subsequence: ");
        int currentLength = maxLength;
        for (int i = 0; i < n && currentLength > 0; i++) {
            if (dp[i] == currentLength) {
                System.out.print(nums[i] + " ");
                currentLength--;
            }
        }
        System.out.println();

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 2, 8, 6, 3, 6, 9, 7 };
        int maxLength = lds(nums);
        System.out.println("Length of Longest Decreasing Subsequence: " + maxLength);
    }
}
