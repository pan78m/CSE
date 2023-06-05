package KnapSack;

public class Knapsack_Fraction {
    public static void main(String[] args) {
        double maxProfit = 0;
        int maxWeight = 20;
        // int maxWeight = 15;
        // Input first time profit an array in P[] and
        // input weight in an array wt[]

        // int p[] = { 10, 8, 15, 7, 6, 18, 3 };
        // int wt[] = { 2, 3, 5, 7, 1, 4, 1 };
        // int p[] = { 1, 2, 5, 6 };
        // int wt[] = { 2, 3, 4, 5 };
        int p[] = { 25, 24, 15 };
        int wt[] = { 18, 15, 10 };
        int n = p.length;
        // Declear a where I store fractional value respect per kg
        double frac[] = new double[n];
        for (int i = 0; i < n; i++) {
            frac[i] = (double) p[i] / (double) wt[i];
            System.out.print(frac[i] + " ");
        }
        int currectW = 0;

        // sort all the item/profit/ratio(using bubble sort)
        for (int i = 0; i < p.length; i++) {
            for (int j = i + 1; j < p.length; j++) {
                if (frac[i] < frac[j]) {
                    // sort ratio
                    double tempF = frac[i];
                    frac[i] = frac[j];
                    frac[j] = tempF;
                    // sort weight
                    int tempW = wt[i];
                    wt[i] = wt[j];
                    wt[j] = tempW;
                    // sort profit
                    int tempP = p[i];
                    p[i] = p[j];
                    p[j] = tempP;

                }
            }
        }

        // Add the items knapsack util it is full
        for (int i = 0; i < p.length; i++) {
            if (currectW + wt[i] <= maxWeight) {
                currectW += wt[i];
                maxProfit += p[i];
            } else {
                int remainW = maxWeight - currectW;
                double ra = (double) remainW / (double) wt[i];
                maxProfit += ra * p[i];
                break;
            }
        }
        System.out.println(
                "\nThe maximum value that can be put in a knapsack of capacity "
                 + maxWeight + " is " + maxProfit);

    }
}
