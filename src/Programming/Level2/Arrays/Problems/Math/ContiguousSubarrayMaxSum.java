package Programming.Level2.Arrays.Problems.Math;

import java.util.Arrays;
import java.util.List;

public class ContiguousSubarrayMaxSum {
    public static int maxSubArray(final List<Integer> A) {
        if (A.size() == 0) {
            return 0;
        }

        /*
        The idea is to maintain 3 counters:
        a) Overall global max sum subarray result.
        b) max_sum_prev : which is the max sum possible until the previous element of the list.
        c) max_sum_curr : which is the max sum possible with the current element
                            -- which happens to be the max of (current element, max_sum_prev + curr_element)
         */
        int result = A.get(0);
        int max_sum_prev = A.get(0);
        int max_sum_curr;
        for(int i = 1; i < A.size(); i++) {
            max_sum_curr = Math.max(A.get(i), A.get(i) + max_sum_prev);
            result = Math.max(max_sum_curr, result);
            max_sum_prev = max_sum_curr;
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4);

        System.out.println(maxSubArray(A));
    }
}
