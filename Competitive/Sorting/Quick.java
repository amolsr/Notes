package Sorting;

public class Quick {
    public static void main(String[] args) {
        Integer[] n = { 5, 6, 8, 7, 9, 3, 1, 2 };
        quickSort(n, 0, n.length - 1);
        for (int i : n) {
            System.out.print(i + " ");
        }
    }

    public static int partition(Integer[] n, Integer s, Integer e) {
        int pivot = n[e];
        int i = (s - 1);
        for (int j = s; j < e; j++) {
            if (n[j] < pivot) {
                i++;
                int temp = n[i];
                n[i] = n[j];
                n[j] = temp;
            }
        }
        int temp = n[i + 1];
        n[i + 1] = n[e];
        n[e] = temp;

        return i + 1;
    }

    public static void quickSort(Integer[] n, Integer s, Integer e) {
        if (s <= e) {
            int i = partition(n, s, e);
            quickSort(n, s, i - 1);
            quickSort(n, i + 1, e);
        }
    }
}