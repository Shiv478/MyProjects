import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1, 3, 2, 4, 2, 4, 7, 9, 3, 1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        int length = arr.length;
        if (length <= 1) {
            return;
        }
        int mid = length / 2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = 0, j = mid; i < right.length; i++, j++) {
            right[i] = arr[j];
        }
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                arr[k] = right[j];
                j++;
                k++;
            }
        }
        if (i >= left.length) {
            while (j < right.length) {
                arr[k] = right[j];
                j++;
                k++;
            }
        } else {
            while (i < left.length) {
                arr[k] = left[i];
                i++;
                k++;
            }
        }

    }
}