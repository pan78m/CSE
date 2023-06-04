import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Com_Print {
    public static void main(String[] args) {
        int[] coins = {1, 5, 10}; // List of available coins

        System.out.println("Enter the coin value for which you want to find combinations: ");
        Scanner input = new Scanner(System.in);
        int targetAmount = input.nextInt(); // The amount to make up

        List<List<Integer>> combinations = calculateCoinCombinations(coins, targetAmount);
        System.out.println("Total number of combinations: " + combinations.size());

        System.out.println("Combinations:");
        for (List<Integer> combination : combinations) {
            for (int i = 0; i < combination.size(); i++) {
                System.out.print(combination.get(i));
                if (i != combination.size() - 1) {
                    System.out.print(" + ");
                }
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> calculateCoinCombinations(int[] coins, int amount) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(combinations, new ArrayList<>(), coins, amount, 0);
        return combinations;
    }

    private static void backtrack(
            List<List<Integer>> combinations,
            List<Integer> currentCombination,
            int[] coins,
            int remainingAmount,
            int start
    ) {
        if (remainingAmount == 0) {
            combinations.add(new ArrayList<>(currentCombination));
        } else if (remainingAmount > 0) {
            for (int i = start; i < coins.length; i++) {
                currentCombination.add(coins[i]);
                backtrack(combinations, currentCombination, coins, remainingAmount - coins[i], i);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }
}

