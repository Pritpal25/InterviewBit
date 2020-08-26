package Programming.Level2.Arrays.Problems.Simulation;

import java.util.ArrayList;

/*
https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/
 */
public class KthRowPascalTriangle {
    public static ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> result = new ArrayList<>();

        if(A < 0) {
            return result;
        }

        result.add(1);

        for (int row = 1; row <= A; row++) {
            result.set(0,1);  // Need to use set here to update the first index instead of add which will append at the end.
            int prev_element = 1;
            for(int element = 1; element <= row-1; element++) {
                int to_set = prev_element + result.get(element);
                prev_element = result.get(element);
                result.set(element, to_set);
            }
            result.add(1); // Cannot use set here since the list does not have element at the last index yet.
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> result = getRow(4);

        result.stream().forEach(System.out::println);

    }
}
