package Programming.Level2.Arrays.Problems.Math;

import java.util.ArrayList;

public class MaxAbsoluteDifference {
    public static int maxArr(ArrayList<Integer> A) {
        int result = 0;

        /*
        BRUTE FORCE SOLN : Think of i and j to be the sides of the square
        You want to traverse just above or below the diagonal, since f(1, 2) = f(2, 1),
        so we dont need to do those calculations twice. Also, since f(x, x) will always be 0,
        we can ignore that as well.

        Time Complexity = O(n^2)
         */
        for(int i = 1; i <= A.size(); i++) {
            for(int j = i + 1; j <= A.size(); j++) {
                result = Math.max(result, Math.abs(A.get(i-1)-A.get(j-1)) + Math.abs(i-j));
            }
        }

        return result;
    }

    public static int optimizedMaxArr(ArrayList<Integer> A) {
        /*
        Optimized : Break down the function into 4 conditions based on
        i > or < j and A[i] > or < A[j]

        You'll see that 2 results are redundant and the other 2 can be calculated in O(n)
        time in one traversal.

        Soln explanation : https://www.youtube.com/watch?v=Ov4weYCIipg&feature=youtu.be
         */
        if(A.size() <= 1) {
            return 0;
        }

        int max1 = A.get(0) + 0; // A.get(i) + i - max of this
        int min1 = A.get(0) + 0; // A.get(j) + j - min of this
        int max2 = A.get(0) - 0; // A.get(i) - i - max of this
        int min2 = A.get(0) - 0; // A.get(j) - j - min of this

        for(int i = 1; i < A.size(); i++) {
            int cand1 = A.get(i) + i;
            if (cand1 > max1) {
                max1 = cand1;
            }
            if(cand1 < min1) {
                min1 = cand1;
            }

            int cand2 = A.get(i) -i;
            if(cand2 > max2) {
                max2 = cand2;
            }
            if(cand2 < min2) {
                min2 = cand2;
            }
        }

        return Math.max((max1-min1), (max2-min2));
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>() {{add(55);add(8);add(43);add(52);add(8);add(59);add(-91);add(-79);add(-18);add(-94);}};

        System.out.println(maxArr(A));
    }

}
