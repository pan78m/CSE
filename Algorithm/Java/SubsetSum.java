import java.util.*;

public class SubsetSum {
    public static boolean hasSubsetSum(int[] nums, int sum) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        List<Integer> subset = new ArrayList<>();

        // base case: empty subset has sum 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // fill the table using dynamic programming
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
                // System.out.print(dp[i][j]+" ");
            }
            // System.out.println();
        }
        // backtrack to find the elements that form the subset
        if (dp[n][sum]) {
            int i = n;
            int j = sum;
            while (i > 0 && j > 0) {
                if (dp[i - 1][j]) {
                    i--;
                } else {
                    subset.add(nums[i - 1]);
                    j -= nums[i - 1];
                    i--;
                }
            }
            System.out.print("Subset with sum " + sum + " is: ");
            for (int k = subset.size() - 1; k >= 0; k--) {
                System.out.print(subset.get(k) + " ");
            }
            System.out.println();
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] nums = { 2, 5, 8, 12, 6, 14 };
        int sum = 19;

        if (hasSubsetSum(nums, sum)) {
            System.out.println("A subset of S with sum " + sum + " exists.");
        } else {
            System.out.println("No subset of S with sum " + sum + " exists.");
        }
    }
}

/*
 * 
 * The hasSubsetSum method takes an array of integers nums and a target sum sum
 * as input and returns a boolean value indicating whether there exists a subset
 * of nums whose sum is equal to sum. The algorithm uses a two-dimensional
 * boolean array dp to store the subproblems, where dp[i][j] represents whether
 * a subset of the first i elements of nums can sum up to j. The base case is
 * when j=0, which is when an empty subset is always possible.
 * 
 * The algorithm iterates over all elements in nums and over all possible sums
 * from 1 to sum. If the current element nums[i-1] is greater than the current
 * sum j, then we simply inherit the value from the previous row dp[i-1][j].
 * Otherwise, we have two options: either we include the current element in the
 * subset, in which case we need to check if a subset of the remaining elements
 * exists that sum up to j-nums[i-1], or we exclude the current element, in
 * which case we simply use the value from the previous row dp[i-1][j].
 * 
 * Finally, the algorithm returns the value dp[n][sum], which represents whether
 * a subset of the entire array nums exists that sums up to sum. In the example
 * main method, we check if a subset of the set {2, 5, 8, 12, 6, 14} exists that
 * sums up to 19, and print the result accordingly.
 * 
 * 
 * 
 */