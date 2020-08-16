package Programming.Level2.Arrays.Problems.Math;

import java.util.ArrayList;

public class Flip {
    public static ArrayList<Integer> flip(String A) {
        ArrayList<Integer> result = new ArrayList<>(2);

        boolean zeroExists = false;

        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == '0') {
                zeroExists = true;
            }
        }

        if(!zeroExists) {
            return result;
        }

        int count = 0, max_count = Integer.MIN_VALUE, l = -1, r = -1, lTemp = 0;

        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == '0') {
                count++;
            } else if(A.charAt(i) == '1') {
                count--;
            }

            if (count > max_count) {
                max_count = count;
                l = lTemp;
                r = i;
            }

            if (count < 0) {
                count = 0;
                lTemp = i+1;
            }
        }

        if(l != -1 && r != -1) {
            result.add(l + 1);
            result.add(r + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        String A = "1111";

        System.out.println(flip(A));
    }
}
