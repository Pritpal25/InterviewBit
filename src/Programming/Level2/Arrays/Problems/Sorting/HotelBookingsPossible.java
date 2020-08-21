package Programming.Level2.Arrays.Problems.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

/*
Ques : https://www.interviewbit.com/problems/hotel-bookings-possible/
 */

public class HotelBookingsPossible {
    public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        arrive.sort(Integer::compareTo);
        depart.sort(Integer::compareTo);

        int concurrentGuest = 0, i = 0, j = 0;

        while(i < arrive.size() && j < depart.size()) {
            if(arrive.get(i) < depart.get(j)) {
                i++;
                concurrentGuest++;

                if (concurrentGuest > K) {
                    return false;
                }
            }
            else if (arrive.get(i) > depart.get(j)) {
                j++;
                concurrentGuest--;
            }
            else {
                i++;
                j++;
            }
        }
        return true;

/*      First k ppl can occupy the rooms. K+1 th cannot come unless atleast one room frees up.

        for(int p = K; p < arrive.size(); p++) {
            if(arrive.get(p) < depart.get(p-K)) {
                return false;
            }
        }

        return true;*/
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(1, 3, 5, 4));
        ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(2, 6, 8, 10));

        System.out.println(hotel(arrive, depart, 2));
    }
}
