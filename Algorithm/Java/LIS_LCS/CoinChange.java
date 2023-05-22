package LIS_LCS;
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // base cases
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // fill the table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                // System.out.print(dp[i][j]+" ");
            }
            // System.out.println();
        }

        // find the specific number of coins needed for each denomination
        int[] coinCount = new int[n];
        int i = n, j = amount;
        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                coinCount[i - 1]++;
                j -= coins[i - 1];
            }
        }

        // print the specific number of coins needed for each denomination
        int total_coin = 0;
        System.out.print("Coins needed: ");
        for (i = 0; i < n; i++) {
            System.out.print(coins[i] + " x " + coinCount[i] + ",");
            total_coin += coinCount[i];
        }
        System.out.println();
        System.out.println("Total Coin is: " + total_coin);

        return dp[n][amount];
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5, 10 };
        int amount = 68;
        System.out.println("Number of ways to make change: " + coinChange(coins, amount));
    }
}
