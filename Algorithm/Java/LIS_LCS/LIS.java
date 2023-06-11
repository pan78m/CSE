package LIS_LCS;
import java.util.*;

public class LIS {
    public static int lis(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                   
                }
            }
        }

        int maxLIS = 0;
        for (int i = 0; i < n; i++) {
            maxLIS = Math.max(maxLIS, dp[i]);
           
        }

        return maxLIS;
    }
    

    public static void main(String[] args) {
        int[] nums = {9, 2, 5, 3, 7, 11, 8, 10, 13, 6};
        
        System.out.println("Length of LIS is " + lis(nums));
        System.out.print("LIS is: ");
    }
}
/*
 In this implementation, the lis method takes an array of integers nums as input and returns the length of its longest increasing subsequence (LIS). The algorithm uses a one-dimensional array dp to store the lengths of LIS for all prefixes of nums. The entry dp[i] represents the length of LIS for the prefix nums[0...i].

The algorithm initializes all entries of dp to 1, since the LIS of a single element is always 1. It then iterates through the entries of dp, computing the LIS for longer and longer prefixes of nums. For each i, it checks all previous elements j and updates dp[i] to be the maximum length obtained by adding nums[i] to an increasing subsequence ending at nums[j].

Finally, the algorithm returns the maximum value in dp, which represents the length of the LIS for the entire array nums. In the example main method, we compute the LIS for the array {10, 9, 2, 5, 3, 7, 101, 18} and print the result, which is 4.


 */