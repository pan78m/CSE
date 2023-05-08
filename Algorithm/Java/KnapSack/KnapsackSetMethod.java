package KnapSack;
import java.util.*;

public class KnapsackSetMethod {
    
    public static void main(String[] args) {
        Item[] items = {
            new Item(2, 1),
            new Item(3, 2),
            new Item(4, 5),
            new Item(5, 6)
           
        };
        Set<Item> subset = knapsack(items, 8);
        System.out.println("Seleted the item: ");
        int Maxprofit=0;
        for (Item item : subset) {
            Maxprofit+=item.getValue();
            System.out.println("Weight: "+item.getWeight() + ", " + "Value: "+item.getValue());
        }
        System.out.println("Total Maximum profit: "+Maxprofit);
    }
    
    public static Set<Item> knapsack(Item[] items, int limit) {
        int n = items.length;
        int[][] dp = new int[n + 1][limit + 1];
        for (int i = 1; i <= n; i++) {
            Item item = items[i - 1];
            for (int j = 1; j <= limit; j++) {
                if (j < item.getWeight()) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - item.getWeight()] + item.getValue());
                }
            }
        }
        
        Set<Item> result = new HashSet<>();
        int i = n, j = limit;
        while (i > 0 && j > 0) {
            Item item = items[i - 1];
            if (dp[i][j] != dp[i - 1][j]) {
                result.add(item);
                j -= item.getWeight();
            }
            i--;
        }
        return result;
    }
    
    public static class Item {
        private int weight;
        private int value;
        
        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
        
        public int getWeight() {
            return weight;
        }
        
        public int getValue() {
            return value;
        }
    }
}
