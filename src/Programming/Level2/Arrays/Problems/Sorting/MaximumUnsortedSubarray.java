package Programming.Level2.Arrays.Problems.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

/*
Ques : https://www.interviewbit.com/problems/maximum-unsorted-subarray/
 */

public class MaximumUnsortedSubarray {
    public static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();

        // Array of size 0 or 1 is always sorted.
        if (A.size() <= 1) {
            result.add(-1);
            return result;
        }

        int n = A.size();
        int i = 0, j = n - 1;

        // Get the first index i where the next element is smaller than current index.
        while(i+1 < n && A.get(i+1) >= A.get(i)) {
            i++;
        }

        // If i is the last element, then the array is sorted.
        if (i == n - 1) {
            result.add(-1);
            return result;
        }

        // Get the first index j where the previous element is larger than current element.
        while(A.get(j) >= A.get(j-1)) {
            j--;
        }

        // Find min and max between [i, j]
        int min = A.get(i), max = A.get(i); // Just initialized
        for(int p = i+1; p <= j; p++) {
            if(A.get(p) < min) {
                min = A.get(p);
            } else if(A.get(p) > max) {
                max = A.get(p);
            }
        }

        // Move i back to the point where ith element is <= min
        while(i >=0 && A.get(i) > min){
            i--;
        }

        // Move j forward where jth element is >= max
        while(j < n && A.get(j) < max) {
            j++;
        }

        // Result is the range from i+1, j-1
        result.add(i+1);
        result.add(j-1);

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 5, 4, 8, 2, 6, 9, 10));

        System.out.println(subUnsort(list));
    }
}
