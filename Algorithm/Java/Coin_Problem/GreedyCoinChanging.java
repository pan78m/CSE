

import java.util.Arrays;

public class GreedyCoinChanging {

    public static void main(String[] args) {
        int[] denominations = {1,2, 5, 10};  // Denominations of coins available
        int amount = 68;  // Amount to make change for

        int[] change = makeChange(denominations, amount);

        System.out.println("Coins used to make change:");
        for (int i = 0; i < denominations.length; i++) {
            if (change[i] > 0) {
                System.out.println(change[i] + " coins of value " + denominations[i]);
            }
        }
    }

    public static int[] makeChange(int[] denominations, int amount) {
        int[] change = new int[denominations.length];
        Arrays.sort(denominations);  // Sort the denominations in descending order

        int index = denominations.length - 1;  // Start with the largest denomination

        while (amount > 0 && index >= 0) {
            if (denominations[index] <= amount) {
                int numCoins = amount / denominations[index];  // Calculate the number of coins of current denomination
                change[index] = numCoins;  // Update the change array with the number of coins used
                amount -= numCoins * denominations[index];  // Subtract the value of coins used from the remaining amount
            }
            index--;
        }

        return change;
    }
}
