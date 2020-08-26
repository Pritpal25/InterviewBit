package Programming.Level2.Arrays.Problems.Simulation;

import java.util.ArrayList;
import java.util.Arrays;

/*
https://www.interviewbit.com/problems/anti-diagonals/
 */
public class AntiDiagonals {
    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(A.size() == 0) {
            return result;
        }

        for(int i = 1; i <= A.size()*2 - 1; i++) {
            ArrayList<Integer> subList = new ArrayList<>();
            result.add(subList);
        }

        int l = 0, r = A.size() - 1, t = 0, b = A.size() - 1; // Traversing the row from left to right, and column from top to bottom.

        int row = 0;
        while(l <= r && t <= b) {
            int rowIndex = row; // rowIndex is the index for the row to start writing into.
            int index = l;

            while(index <= r) {
                result.get(rowIndex++).add(A.get(t).get(index));
                index++;
            }
            t++;

            index = t;

            while(index <= b) {
                result.get(rowIndex++).add(A.get(index).get(r));

                index++;
            }
            r--;

            row++;
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();

        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(4, 5, 6));
        ArrayList<Integer> c = new ArrayList<>(Arrays.asList(7, 8, 9));

        input.add(a);
        input.add(b);
        input.add(c);

        ArrayList<ArrayList<Integer>> result = diagonal(input);

        for(int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
