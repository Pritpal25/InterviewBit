package Programming.Level2.Arrays.Sorting;

import java.util.ArrayList;
import java.util.List;

/*
    IMPORTANT LEARNING : list.set(index, value) returns the value previously at index 'index'. This concept is
    used in the sort algorithm below.

    1. Time Complexity : O(n^2)
        Worst Case : Sorted in decreasing order
            Total Operations would be
            n-1 + n-2 + n-3 + ....... + 1 = n(n-1)/2 = O(n^2)
    2. Space Complexity : O(1) In-Place sorting algorithm : no new space required to sort,
    3. Stable Sort : Check the comment at condition in loop, depends on implementation
    4. Internal Sort.
    5. Non-recursive Sort
 */


public class BubbleSort {
    public static List<Integer> sort(List<Integer> list) {
        // This loop will run for n-1 times. At each pass, the biggest element with move to the right
        // in its rightful place.
        int n = list.size();
        for(int i = 0; i < n-1; i++) {
            // For each pass, we are going to perform one less comparision in the end, since the elements
            // after each pass at the end are at its rightful place.
            for(int j = 0; j < n-i-1; j++) {
                // This is a STABLE SORT, if the check was >=, this would be an instable sort.
                if(list.get(j) > list.get(j+1)){
                    list.set(j, list.set(j+1, list.get(j)));
                }
            }
        }

        return list;
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(1);
        list.add(6);
        list.add(2);
        list.add(5);

        List<Integer> result = sort(list);
        System.out.println(result);
    }
}
