package Programming.Level2.Arrays.Problems.Math;

import java.util.ArrayList;

public class AddOneToNumber {
    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        if(A.size() == 0) {
            return A;
        }

        int carry = 1;
        for(int i = A.size() - 1; i >= 0; i--) {
            int value = (A.get(i) + carry)%10;
            carry = (A.get(i) + carry)/10;

            A.set(i, value);

            if(carry == 0) {
                break;
            }
        }

        if(carry != 0) {
            ArrayList<Integer> B = new ArrayList<>(A.size() + 1);
            B.add(0, 1);
            B.addAll(1, A);

            return B;
        }
        else {
            int nonZeroIndex = 0;
            for(int i = 0; i < A.size(); i++) {
                if(A.get(i) == 0) {
                    nonZeroIndex++;
                }
                else {
                    return new ArrayList<Integer>(A.subList(nonZeroIndex, A.size()));
                }
            }

            return A;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(){{add(0); add(0); add(9); add(9); add(9);}};

        System.out.println(plusOne(A));
    }
}
