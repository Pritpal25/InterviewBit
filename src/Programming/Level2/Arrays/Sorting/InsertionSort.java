package Programming.Level2.Arrays.Sorting;

import java.util.ArrayList;
import java.util.List;

/*
    IMP LEARNING : I was trying to set the values in the list using add, that was causing the size of the list
    to increase and algorithm was running in an indefinite loop.

    We use list.set if we just want to set an element at a location without increasing the list size.

    1. Time Complexity : O(n^2)
        Worst Case : Sorted in decreasing order
            1 + 2 + 3 + 4 .... n-1 = n(n+1)/2 ~
    2. Space Complexity : O(1) : no new space required to sort.
    3. Stable Sort
    4. Internal Sort.
    5. Non-recursive Sort
 */

public class InsertionSort {
    public static List<Integer> sort(List<Integer> list) {
        if (list.size() == 0) {
            return null;
        }

        int index_sorted = 0;

        for(int index_unsorted = 1; index_unsorted < list.size(); index_unsorted++) {
            int value_unsorted = list.get(index_unsorted);

            int i = index_unsorted-1;

            // The condition is to make sure that the index doesn't become less that 0 and the value getting
            // checked is greater than unsorted value for the swap to happen.
            // This is a STABLE SORT, SINCE we are not moving the elements when they are equal.
            while (i >= 0 && (list.get(i) > value_unsorted)) {
                list.set(i+1, list.get(i));
                i--;
            }

            list.set(i+1, value_unsorted);
            index_sorted++;
        }

        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(1);
        list.add(-66);
        list.add(2);
        list.add(5);

        List<Integer> result = sort(list);
        System.out.println(result);
    }
}
