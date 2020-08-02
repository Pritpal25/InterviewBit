package Programming.Level2.Arrays.Sorting;

import java.util.Arrays;
import java.util.List;

/*
    1. Time Complexity : O(n^2)
        Worst Case is same as best case : Any random list, sorted or unsorted
        Total Operations would be in findMinIndex
        n-1 + n-2 + n-3 + ....... + 1 + 0 = n(n-1)/2 = O(n^2)
    2. Space Complexity : O(1) In-Place sorting algorithm : no new space required to sort,
    3. Stable Sort : Check the comment at condition in loop, depends on implementation
    4. Internal Sort.
    5. Non-recursive Sort
 */

public class SelectionSort {
    public static List<Integer> sort(List<Integer> list) {
        for(int i = 0; i < list.size(); i++) {
            int min_index = findMinIndex(list, i);

            // Swap of elements at i and min_index
            if(i != min_index) {
                list.set(i, list.set(min_index, list.get(i)));
            }
        }

        return list;
    }

    private static int findMinIndex(List<Integer> list, int index) {
        int min_index = index;

        for(int i = min_index + 1; i < list.size(); i++) {
            // STABLE because we dont have = here. Which implies that we are not replacing the existing smallest
            // element with a similar smaller element from right side of the list.
            if(list.get(i) < list.get(min_index)) {
                min_index = i;
            }
        }

        return min_index;
    }
    
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(14, 7, 3, 12, 9, 11, 3, 6, 2);

        List<Integer> result = sort(list);
        System.out.println(result);
    }
}
