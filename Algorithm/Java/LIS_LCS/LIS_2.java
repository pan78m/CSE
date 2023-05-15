package LIS_LCS;
import java.util.*;

public class LIS_2 {
    public static List<Integer> lis(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] prevIndex = new int[n];
        Arrays.fill(prevIndex, -1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prevIndex[i] = j;
                }
            }
        }

        int maxLIS = 0;
        int maxLISIndex = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxLIS) {
                maxLIS = dp[i];
                maxLISIndex = i;
            }
        }

        List<Integer> lisIndices = new ArrayList<>();
        int currentIndex = maxLISIndex;
        while (currentIndex != -1) {
            lisIndices.add(currentIndex);
            currentIndex = prevIndex[currentIndex];
        }
        Collections.reverse(lisIndices);

        return lisIndices;
    }

    public static void main(String[] args) {
        int[] nums = {9, 2, 5, 3, 7, 11, 8, 10, 13, 6};
        List<Integer> lisIndices = lis(nums);
        System.out.println("Length of LIS is " + lisIndices.size());
        System.out.print("LIS is: ");
        for (int i : lisIndices) {
            System.out.print(nums[i] + " ");
        }
    }
}
