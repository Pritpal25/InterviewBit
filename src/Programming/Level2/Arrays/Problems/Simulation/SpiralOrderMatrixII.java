package Programming.Level2.Arrays.Problems.Simulation;

import java.util.ArrayList;

public class SpiralOrderMatrixII {
    public static ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        if (A <= 0) {
            return null;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i = 0; i < A; i++) {
            ArrayList<Integer> subList = new ArrayList<>();
            for(int j = 0; j < A; j++) {
                subList.add(0);
            }
            result.add(subList);
        }

        int t = 0, b = result.size()-1, l = 0, r = result.get(0).size()-1;
        int dir = 0;
        int value = 1;

        while(t <= b && l <= r) {
            if(dir == 0) {
                for(int i = l; i<= r; i++) {
                    ArrayList<Integer> temp = result.get(t);
                    temp.set(i, value++);
                    result.set(t, temp);
                }
                t++;
            }
            else if(dir == 1) {
                for(int i = t; i <= b; i++) {
                    ArrayList<Integer> temp = result.get(i);
                    temp.set(r, value++);
                    result.set(i, temp);
                }
                r--;
            }
            else if(dir == 2) {
                for(int i = r; i >= l; i--) {
                    ArrayList<Integer> temp = result.get(b);
                    temp.set(i, value++);
                    result.set(b, temp);
                }
                b--;
            }
            else if(dir == 3) {
                for(int i = b; i >= t; i--) {
                    ArrayList<Integer> temp = result.get(i);
                    temp.set(l, value++);
                    result.set(i, temp);
                }
                l++;
            }
            dir = (dir +1)%4;
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = generateMatrix(4);

        for(int i = 0 ; i < result.size(); i++) {
            for(int j = 0; j < result.size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
