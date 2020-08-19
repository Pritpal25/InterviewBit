package Programming.Level2.Arrays.Problems;

import java.util.ArrayList;

public class MaxMin {
    public int solve(ArrayList<Integer> A) {
        if(A.size() < 1) {
            return Integer.MIN_VALUE;
        }

        int min, max, i;

        if(A.size() % 2 == 1) {
            min = max = A.get(0);
            i = 1;
        }
        else {
            if(A.get(0) < A.get(1)) {
                min = A.get(0);
                max = A.get(1);
            }
            else {
                min = A.get(1);
                max = A.get(0);
            }
            i = 2;
        }

        while(i < A.size()-1) {
            int valueAtI = A.get(i);
            int valueAtIplus1 = A.get(i+1);

            if(valueAtI < valueAtIplus1) {
                if(valueAtI < min) {
                    min = valueAtI;
                }
                if(valueAtIplus1 > max) {
                    max = valueAtIplus1;
                }
            } else {
                if(valueAtI > max) {
                    max = valueAtI;
                }
                if(valueAtIplus1 < min) {
                    min = valueAtIplus1;
                }
            }
            i+=2;
        }

        return min + max;
    }
}
