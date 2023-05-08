package QuickSort;

import java.util.Scanner;

class Hello {
    public static void main(String[] args) {
        System.out.println("Hi This is->>Pankaj Mahanto!!");
        System.out.println("Enter the number which you want to: ");
        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int b = input.nextInt();
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        input.close();
    }
}