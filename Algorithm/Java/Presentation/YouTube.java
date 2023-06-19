package Presentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class AdImpression {
    private int videoId;
    private double ctr;

    public AdImpression(int videoId, double ctr) {
        this.videoId = videoId;
        this.ctr = ctr;
    }

    public int getVideoId() {
        return videoId;
    }

    public double getCtr() {
        return ctr;
    }
}

public class YouTube {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of ad impressions
        System.out.print("Enter the number of ad impressions: ");
        int n = scanner.nextInt();

        // Read the ad impressions (videoId and CTR) from the user
        AdImpression[] adImpressions = new AdImpression[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter video ID for impression " + (i + 1) + ": ");
            int videoId = scanner.nextInt();
            System.out.print("Enter CTR for impression " + (i + 1) + ": ");
            double ctr = scanner.nextDouble();

            adImpressions[i] = new AdImpression(videoId, ctr);
        }
        scanner.close();

        // Perform bucket sort on the ad impressions based on CTR
        List<List<AdImpression>> buckets = bucketSort(adImpressions);

        // Concatenate the sorted buckets
        List<AdImpression> sortedImpressions = new ArrayList<>();
        for (List<AdImpression> bucket : buckets) {
            sortedImpressions.addAll(bucket);
        }

        // Print the sorted impressions
        System.out.println("Sorted Ad Impressions:");
        for (AdImpression impression : sortedImpressions) {
            System.out.println("Video ID: " + impression.getVideoId() + ", CTR: " + impression.getCtr());
        }
    }

    public static List<List<AdImpression>> bucketSort(AdImpression[] adImpressions) {
        // Determine the range of CTR values
        double minCTR = Arrays.stream(adImpressions)
                .mapToDouble(AdImpression::getCtr)
                .min()
                .orElse(0.0);
        double maxCTR = Arrays.stream(adImpressions)
                .mapToDouble(AdImpression::getCtr)
                .max()
                .orElse(100.0);

        // Decide on the number of buckets
        int numBuckets = 10;
        double intervalSize = (maxCTR - minCTR) / numBuckets;

        // Create the buckets
        List<List<AdImpression>> buckets = new ArrayList<>();
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribute the ad impressions into buckets
        for (AdImpression adImpression : adImpressions) {
            double ctr = adImpression.getCtr();
            int bucketIndex = (int) ((ctr - minCTR) / intervalSize);
            if (bucketIndex == numBuckets) {
                bucketIndex--; // Place the maximum CTR value in the last bucket
            }
            buckets.get(bucketIndex).add(adImpression);
        }

        // Sort the buckets
        for (List<AdImpression> bucket : buckets) {
            bucket.sort((a, b) -> Double.compare(a.getCtr(), b.getCtr()));
        }

        return buckets;
    }
}

