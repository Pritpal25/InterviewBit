package Programming.Level2.Arrays.Problems.Simulation;

import java.util.ArrayList;

/*
https://www.interviewbit.com/problems/pascal-triangle/
 */

public class PascalTriangle {
    public static ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(A <= 0) {
            return result;
        }

        ArrayList<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        for(int row = 2; row <= A; row++) {
            ArrayList<Integer> subList = new ArrayList<>();

            subList.add(1);  // Adding first element of each row

            for(int elements = 2; elements <= row-1; elements++) {
                ArrayList<Integer> prev_row = result.get(row-2);
                subList.add(prev_row.get(elements-1) + prev_row.get(elements-2));
            }
            subList.add(1);  //Last element of each row

            result.add(subList);
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = solve(5);

        for(int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
