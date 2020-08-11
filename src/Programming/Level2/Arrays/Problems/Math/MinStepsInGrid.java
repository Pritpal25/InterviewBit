package Programming.Level2.Arrays.Problems.Math;

import java.util.Arrays;
import java.util.List;

public class MinStepsInGrid {
    public static int coverPoints(List<Integer> A, List<Integer> B) {
        int aSize = A.size();
        int bSize = B.size();

        if(aSize != bSize) {
            return -1;
        }

        if(aSize <= 1 || bSize <= 1) {
            return 0;
        }

        int numSteps = 0;
        for(int i = 0; i < aSize - 1; i++) {
            numSteps += Math.max(Math.abs(A.get(i)-A.get(i+1)), Math.abs(B.get(i)-B.get(i+1)));
        }

        return numSteps;
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(0, 1, 3, -1);
        List<Integer> B = Arrays.asList(0, 1, 4, -2);

        System.out.println(coverPoints(A, B));
    }
}
