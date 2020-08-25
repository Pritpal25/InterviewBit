package Programming.Level2.Arrays.Problems.Sorting;

import java.util.Arrays;
import java.util.List;

public class MaxDistance {
    public static int maximumGap(final List<Integer> A) {
        if (A.size() <= 1) {
            return 0;
        }

        int n = A.size();
        int[] mins = new int[n];
        int[] maxs = new int[n];

        mins[0] = A.get(0);
        for(int i = 1; i < A.size(); i++) {
            mins[i] = Math.min(A.get(i), mins[i-1]);
        }

        maxs[n-1] = A.get(n-1);
        for(int i = n-2; i >= 0; i--) {
            maxs[i] = Math.max(A.get(i), maxs[i+1]);
        }

        int i = 0, j = 0;
        int maxDiff = -1;
        while(i < n && j < n) {
            if(mins[i] <= maxs[j]) {
/*
 Added this extra condition to help with descending array case. Otherwise for descending array at index 0, minx[0] = maxs[0]
 and we would return 0 as the answer, instead of -1.
 */
                if(mins[i] < maxs[j]) {
                    maxDiff = Math.max(maxDiff, (j - i));
                }
                j++;
            } else {
                i++;
            }
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6, 5, 4, 3, 2, 1);
        System.out.println(maximumGap(list));
    }
}
