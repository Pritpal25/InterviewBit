package Programming.Level2.Arrays.Problems.Math;

import java.util.ArrayList;
import java.util.List;

public class Partitions {
    public static int solve(int A, ArrayList<Integer> B) {
        /*
        Solution Approach : https://www.youtube.com/watch?v=qFbBi5kOq5U&t=35s
         */
        
        int sum = 0;

        for(int i = 0; i < B.size(); i++) {
            sum += B.get(i);
        }

        if (sum%3 != 0) {
            return 0;
        }

        List<Integer> prefix = new ArrayList<>(A);
        List<Integer> suffix = new ArrayList<>(A);

        int partSum = sum/3;
        int preArrSum = 0;
        int suffArrSum = 0;

        for(int i = 0; i < A; i++) {
            preArrSum += B.get(i);
            suffArrSum += B.get(A-1-i);

            if(preArrSum == partSum) {
                prefix.add(i);
            }

            if(suffArrSum == partSum) {
                suffix.add(A-1-i);
            }
        }

        int count = 0;
        for(int i = 0; i < prefix.size(); i++) {
            for(int j = 0; j < suffix.size(); j++) {
                int midSum = 0;
                boolean midArrayExists = false;  // This is required to check for the case where partSum is 0.
                for(int k = prefix.get(i) + 1; k < suffix.get(j); k++) { // If partSum is 0 and size of midArray is 0, we'll still end up counting that prefix, suffix as part of solution.
                    midSum += B.get(k);
                    midArrayExists = true;
                }
                if((midSum == partSum) && midArrayExists) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        //ArrayList<Integer> B = new ArrayList<Integer>() {{add(1);add(2);add(3);add(0);add(3);}};
        ArrayList<Integer> B = new ArrayList<Integer>() {{add(0);add(-1);add(1);add(0);}};

        System.out.println(solve(4, B));
    }
}
