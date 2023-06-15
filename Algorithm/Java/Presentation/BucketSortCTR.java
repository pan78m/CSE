package Presentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BucketSortCTR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of impressions
        System.out.print("Enter the number of ad impressions: ");
        int n = scanner.nextInt();

        // Read the CTR values for each impression
        double[] ctrValues = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter CTR for impression " + (i + 1) + ": ");
            ctrValues[i] = scanner.nextDouble();
        }

        // Perform bucket sort
        List<List<Double>> buckets = bucketSort(ctrValues);

        // Concatenate the sorted buckets
        List<Double> sortedImpressions = new ArrayList<>();
        for (List<Double> bucket : buckets) {
            for (double impression : bucket) {
                sortedImpressions.add(impression);
            }
        }

        // Print the sorted impressions
        System.out.println("Sorted Impressions:");
        for (double impression : sortedImpressions) {
            System.out.println(impression);
        }
    }

    public static List<List<Double>> bucketSort(double[] ctrValues) {
        // Determine the range of CTR values
        double minCTR = Arrays.stream(ctrValues).min().orElse(0);
        double maxCTR = Arrays.stream(ctrValues).max().orElse(100);

        // Decide on the number of buckets
        int numBuckets = 10;
        double intervalSize = (maxCTR - minCTR) / numBuckets;

        // Create the buckets
        List<List<Double>> buckets = new ArrayList<>();
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribute the ad impressions into buckets
        for (double ctr : ctrValues) {
            int bucketIndex = (int) ((ctr - minCTR) / intervalSize);
            if (bucketIndex == numBuckets) {
                bucketIndex--; // Place the maximum CTR value in the last bucket
            }
            buckets.get(bucketIndex).add(ctr);
        }

        // Sort the buckets
        for (List<Double> bucket : buckets) {
            bucket.sort(null); // Using the default sorting order (ascending)
        }

        return buckets;
    }
}
