package LIS_LCS;
import java.util.*;

public class LIS_With_Iter {
    private static int[] prevIndex;

    public static List<List<Integer>> lis(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        prevIndex = new int[n]; // initialize the prevIndex array
        
        int maxLIS = 1;
        int maxLISIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    // store the previous index of the element
                    prevIndex[i] = j;
                }
            }
            if (dp[i] > maxLIS) {
                maxLIS = dp[i];
                maxLISIndex = i;
            }
        }

        List<List<Integer>> allLIS = new ArrayList<>();
        List<Integer> currentLIS = new ArrayList<>();
        currentLIS.add(nums[maxLISIndex]);
        allLIS.add(currentLIS);

        // traverse the previous index array to construct all possible LIS
        for (int i = maxLISIndex - 1; i >= 0; i--) {
            if (dp[i] + 1 == dp[maxLISIndex] && nums[i] < nums[maxLISIndex]) {
                currentLIS = new ArrayList<>();
                currentLIS.add(nums[i]);
                for (int j = i; j < maxLISIndex; j++) {
                    if (dp[j] + 1 == dp[maxLISIndex] && nums[j] < nums[maxLISIndex]) {
                        currentLIS.add(nums[j]);
                    }
                }
                allLIS.add(currentLIS);
            }
        }

        return allLIS;
    }

    public static void main(String[] args) {
        int[] nums = {9, 2, 5, 3, 7, 11, 8, 10, 13, 6};
        List<List<Integer>> allLIS = lis(nums);
        System.out.println("Length of LIS is " + allLIS.get(0).size());
        System.out.println("All possible LIS are:");
        for (List<Integer> lis : allLIS) {
            for (int num : lis) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
