package Programming.Level2.Arrays.Sorting;

import java.util.Arrays;
import java.util.List;

/*
    1. Time Complexity : https://www.geeksforgeeks.org/quick-sort/
    2. Space Complexity :  ?
    3. Stable Sort : ?
    4. Internal Sort.
    5. Recursive Sort
 */


public class QuickSort {
    public static List<Integer> sort(List<Integer> list) {
        if (list.size() == 0) {
            return list;
        }

        return quickSort(list, 0, list.size() - 1);
    }

    private static List<Integer> quickSort(List<Integer> list, int start, int end) {
        // Check the comment below for why the > is also required here.
        if(start >= end) {
            return list;
        }

        int pivot = list.get(end);
        int final_pivot_loc = start;

        for(int i = start; i < end; i++) {
            if(list.get(i) < pivot) {
                if(i != final_pivot_loc) { // Optimization - don't swap if the locations are same.
                    list.set(i, list.set(final_pivot_loc, list.get(i)));
                }
                final_pivot_loc++;
            }
        }

        if(final_pivot_loc != end) { // Optimization - don't swap if the locations are same.
            list.set(final_pivot_loc, list.set(end, list.get(final_pivot_loc)));
        }

        quickSort(list, start, final_pivot_loc-1);
        // For a sorted array, this will cause the start to be greater than the end.
        // This implies the recursion should break if start >= end.
        quickSort(list, final_pivot_loc+1, end);

        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(14, 7, 3, 12, 9, 11, 3, 6, 2);

        List<Integer> result = sort(list);
        System.out.println(result);
    }
}
