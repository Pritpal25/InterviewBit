package Programming.Level2.Arrays.Problems.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class WaveArray {
    public static ArrayList<Integer> wave(ArrayList<Integer> A) {
        if(A.size() <= 1) {
            return A;
        }

        A.sort(Integer::compareTo);

        for(int i = 1; i < A.size(); i+=2) {
            A.set(i, A.set(i-1, A.get(i)));
        }

        return A;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(8, 6, 17, 15, 20));

        System.out.println(wave(list));
    }
}
