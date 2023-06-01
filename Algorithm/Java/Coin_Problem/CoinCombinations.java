
import java.util.Scanner;

public class CoinCombinations {
    public static void main(String[] args) {
        int[] coins = {1, 5, 10}; // List of available coins
      
        System.out.println("Enter the coin value which combination you making: ");
        Scanner input=new Scanner (System.in);
        int targetAmount =input.nextInt(); // The amount to make up

        int combinations = calculateCoinCombinations(coins, targetAmount);
        System.out.println("Total number of combinations: " + combinations);
    }

    public static int calculateCoinCombinations(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}
