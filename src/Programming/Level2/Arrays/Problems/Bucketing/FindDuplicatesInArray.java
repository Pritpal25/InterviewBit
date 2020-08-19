package Programming.Level2.Arrays.Problems.Bucketing;

import java.util.List;

/*
Multiple solutions to this problem - do check them out in the solution discussion page.
This solution only works for a single duplicate element.
 */
public class FindDuplicatesInArray {
    public int repeatedNumber(final List<Integer> A) {
        int xor = 0;

        for(int i = 0; i < A.size(); i++) {
            xor = xor ^ i ^ A.get(i);
        }

         return xor < A.size() ? xor: -1;
    }
}
