
package QuickSort;
//last element is the pivot element
public class Quick_sort2 {
    public static void main(String[] args) {
        int[] arr = { 14, 26, 3, 11, 28, 27, 16, 1 };
        System.out.println("Before sorted value: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        // call the quick sort function here
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Print the sorted Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }

    public static void quickSort(int[] arr, int start, int end) {
        int pivot;
        if (start < end) {
            pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);

        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot, temp, left, right;
        left = start;
        pivot = end;
        right = end;
        int flag = 0;
        System.out.println();
        System.out.print(left+"->Iterations: ");
        while (flag != 1) {
            while ((arr[pivot] >= arr[left]) && (pivot != left)) {
                left++;
            }
            if (pivot == left) {
                flag = 1;
            } else if (arr[pivot] < arr[left]) {
                temp = arr[pivot];
                arr[pivot] = arr[left];
                arr[left] = temp;
                pivot = left;
            }
            if (flag != 1) {
                while ((arr[pivot] <= arr[right]) && (pivot != right)) {
                    right--;
                }
                if (pivot == right) {
                    flag = 1;
                } else if (arr[pivot] > arr[right]) {
                    temp = arr[pivot];
                    arr[pivot] = arr[right];
                    arr[right] = temp;
                    pivot = right;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i] + " ");
        }
        System.out.println();

        return pivot;
    }
}
