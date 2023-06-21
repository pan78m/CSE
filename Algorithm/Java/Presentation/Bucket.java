
import java.util.*;
public class Bucket {
    static int countSetBits(int num) {
        int count = 0;
        while (num != 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
    static void bucketizeElements(int[] A) {
        Map<Integer, List<Integer>> buckets = new HashMap<>();
        
        for (int num : A) {
            int setBitCount = countSetBits(num);
            if (!buckets.containsKey(setBitCount)) {
                buckets.put(setBitCount, new ArrayList<>());
            }
            buckets.get(setBitCount).add(num);
        }
        
        for (List<Integer> bucket : buckets.values()) {
            Collections.sort(bucket);
            for (int num : bucket) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N]-.0ii                                     i9=
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        scanner.close();
        bucketizeElements(A);
    }
}

