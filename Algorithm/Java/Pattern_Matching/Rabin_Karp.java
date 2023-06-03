package Pattern_Matching;

public class Rabin_Karp {
    public static void main(String arg[]) {
        char[] pattern = "test".toCharArray();
        char[] text = "this is test text test".toCharArray();

        int index = RabinKarpMethod(pattern, text);
        if (index != -1) {
            System.out.println("Pattern found at index: " + index);
        } else {
            System.out.println("Pattern not found in the text.");
        }
    }

    public static int RabinKarpMethod(char[] pattern, char[] text) {
        int patternSize = pattern.length;
        int textSize = text.length;

        long prime = getBiggerPrime(patternSize);

        long r = 1;
        for (int i = 0; i < patternSize - 1; i++) {
            r = (r * 2) % prime;
        }

        long[] t = new long[textSize];
        t[0] = 0;

        long pfinger = 0;

        for (int j = 0; j < patternSize; j++) {
            t[0] = (2 * t[0] + text[j]) % prime;
            pfinger = (2 * pfinger + pattern[j]) % prime;
        }

        int i = 0;
        boolean passed = false;

        int diff = textSize - patternSize;
        for (i = 0; i <= diff; i++) {
            if (t[i] == pfinger) {
                passed = true;
                for (int k = 0; k < patternSize; k++) {
                    if (text[i + k] != pattern[k]) {
                        passed = false;
                        break;
                    }
                }

                if (passed) {
                    return i;
                }
            }

            if (i < diff) {
                long value = (2 * (t[i] - r * text[i]) + text[i + patternSize]) % prime;
                t[i + 1] = (value + prime) % prime;
            }
        }
        return -1;
    }

    private static long getBiggerPrime(int patternSize) {
        // Find a prime number larger than the pattern size
        // You can implement your own logic to find a larger prime
        // In this example, we are using a simple prime number
        int prime = patternSize + 1;
        while (!isPrime(prime)) {
            prime++;
        }
        return prime;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
