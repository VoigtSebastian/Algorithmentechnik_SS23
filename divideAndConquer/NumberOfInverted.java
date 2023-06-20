package divideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Theoretically should count the number of inverted numbers a[i] > a[j], where
 * i < j (see numberOfInverted() for simple example), using Divide and Conquer
 */
final class NumberOfInverted {
    private static ArrayList<Integer> list;
    private static int swaps = 0;

    public static void main(String[] args) {
        list = new ArrayList<>(Arrays.asList(61, 98, 25, 12, 97, 7, 52, 20, 10, 58, 62, 9, 80, 45, 4, 16, 96, 90, 60,
                50, 13, 3, 94, 56, 67, 19, 92, 89, 71, 11, 23, 40));

        System.out.println("Before: " + list);
        System.out.println("Number of inverted: " + numberOfInverted());
        quicksort(0, list.size() - 1);
        System.out.println("After: " + list);

        System.out.println("Swaps: " + swaps);
    }

    public static void quicksort(int lo, int hi) {
        if (lo >= hi || lo < 0)
            return;
        int p = partition(lo, hi);

        quicksort(lo, p - 1);
        quicksort(p + 1, hi);
    }

    public static int partition(int lo, int hi) {
        int pivot = list.get(hi);
        int pIndex = lo - 1;

        for (int j = lo; j < hi; j++) {
            int current = list.get(j);

            if (current < pivot) {
                pIndex++;
                if (pIndex != j)
                    swaps++;

                swap(pIndex, j);
            }
        }

        pIndex++;

        swap(pIndex, hi);

        swaps++;
        return pIndex;
    }

    public static void swap(int i, int j) {
        var tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    public static int numberOfInverted() {
        var count = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) > list.get(j))
                    count++;
            }
        }
        return count;
    }
}
