package Programming.Level2.Arrays.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Below are 2 implementations of mergeSort
        1. Passes the temporary auxiliary list up the recursion chain.
        2. Updates the original list with the result from the auxiliary list.
        Both have same space and time complexity.

    1. Time Complexity : O(nLogn)
    2. Space Complexity : O(n)
        Why is space complexity not O(nlogn) : https://cs.stackexchange.com/questions/122262/why-does-mergesort-have-on-space-complexity-if-it-splits-the-array-logn-time
    3. Stable Sort : Check the comment at condition in loop, depends on implementation
    4. Internal Sort.
    5. Recursive Sort
 */
public class MergeSort {
    public static List<Integer> sort(List<Integer> list) {
        if(list.size() == 0) {
            return list;
        }

        return mergeSort2(list, 0, list.size()-1);
    }

/*    private static List<Integer> mergeSort(List<Integer> list, int start, int end) {
        if(start == end) {
            return Arrays.asList(list.get(start));
        }

        int mid = ((end+start)/2);
        List<Integer> list = mergeSort(list, start, mid);
        List<Integer> list = mergeSort(list, mid+1, end);
        List<Integer> result = new ArrayList<>(end - start + 1);

        int i = 0, j = 0;
        while(i < list.size() && j < list.size()) {
            // STABILITY PROVIDED BY THE EQUALITY SIGN IN THIS COMPARISON.
            if(list.get(i) <= list.get(j)) {
                result.add(list.get(i));
                i++;
            }
            else {
                result.add(list.get(j));
                j++;
            }
        }

        while(j < list.size()) {
            result.add(list.get(j));
            j++;
        }

        while(i < list.size()) {
            result.add(list.get(i));
            i++;
        }

        return result;
    }*/

    private static List<Integer> mergeSort2(List<Integer> list, int start, int end) {
        if(start == end) {
            return list;
        }

        int mid = ((end+start)/2);
        mergeSort2(list, start, mid);
        mergeSort2(list, mid+1, end);
        List<Integer> result = new ArrayList<>(end - start + 1);

        int i = start, j = mid+1;
        while(i <= mid && j <= end) {
            // STABILITY PROVIDED BY THE EQUALITY SIGN IN THIS COMPARISON.
            if(list.get(i) <= list.get(j)) {
                result.add(list.get(i));
                i++;
            }
            else {
                result.add(list.get(j));
                j++;
            }
        }

        while(j <= end) {
            result.add(list.get(j));
            j++;
        }

        while(i <= mid) {
            result.add(list.get(i));
            i++;
        }

        for(i = start; i <= end; i++) {
            list.set(i, result.get(i - start));
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(14, 7, 3, 12, 9, 11, 3, 6, 2);

        List<Integer> result = sort(list);
        System.out.println(result);
    }
}
