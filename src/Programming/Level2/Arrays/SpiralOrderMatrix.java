package Programming.Level2.Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderMatrix {
    // First attempt
    /*public static void spiralOrder(final List<ArrayList<Integer>> A) {
        int right_max = A.get(0).size() - 1; // 3
        int bottom_max = A.size() - 1; // 2
        int left_max = 0;
        int top_max = 1;

        int i = 0, j = 0;

        while(right_max >= left_max || top_max <= bottom_max) {
            while (j <= right_max) {
                System.out.print("L1:" + A.get(i).get(j) + " ");
                j++;
            }
            j--;
            i++;
            right_max--; // 2

            while (i <= bottom_max) {
                System.out.print("L2:" + A.get(i).get(j) + " ");
                i++;
            }
            i--;
            j--;
            bottom_max--; // 1

            while (j >= left_max) {
                System.out.print("L3:" + A.get(i).get(j) + " ");
                j--;
            }
            j++;
            i--;
            left_max++; // 1

            while (i >= top_max) {
                System.out.print("L4:" + A.get(i).get(j) + " ");
                i--;
            }
            i++;
            j++;
            top_max++; // 2
        }

    }*/

    public static void spiralOrder(final List<ArrayList<Integer>> A) {
        int t = 0, b = A.size()-1, l = 0, r = A.get(0).size()-1;
        int dir = 0;

        while(t <= b && l <= r) {
            if(dir == 0) {
                for(int i = l; i<= r; i++) {
                    System.out.print(A.get(t).get(i) + " ");
                }
                t++;
            }
            else if(dir == 1) {
                for(int i = t; i <= b; i++) {
                    System.out.print(A.get(i).get(r) + " ");
                }
                r--;
            }
            else if(dir == 2) {
                for(int i = r; i >= l; i--) {
                    System.out.print(A.get(b).get(i) + " ");
                }
                b--;
            }
            else if(dir == 3) {
                for(int i = b; i >= t; i--) {
                    System.out.print(A.get(i).get(l) + " ");
                }
                l++;
            }
            dir = (dir +1)%4;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>(4) {{add(1); add(2); add(3); add(4);}};
        ArrayList<Integer> list2 = new ArrayList<Integer>(4) {{add(10); add(11); add(12); add(5);}};
        ArrayList<Integer> list3 = new ArrayList<Integer>(4) {{add(9); add(8); add(7); add(6);}};

        List<ArrayList<Integer>> listOfList = new ArrayList<ArrayList<Integer>>(){{add(list1);add(list2);add(list3);}};

        //System.out.println(listOfList.size() + " " + listOfList.get(0).size());
        spiralOrder(listOfList);
    }
}
