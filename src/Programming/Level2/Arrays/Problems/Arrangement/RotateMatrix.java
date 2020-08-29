package Programming.Level2.Arrays.Problems.Arrangement;

import java.util.ArrayList;

public class RotateMatrix {
    public static void rotate(ArrayList<ArrayList<Integer>> a) {
        if (a.size() <= 1) {
            return;
        }

        int n = a.size();
        for(int i = 0; i < n/2; i++)
        {
            for(int j = i; j <= n - 2- i; j++)
            {
                int cache = a.get(i).get(j);
                a.get(i).set(j, a.get(n-1-j).get(i));
                a.get(n-1-j).set(i, a.get(n-1-i).get(n-1-j));
                a.get(n-1-i).set(n-1-j, a.get(j).get(n-1-i));
                a.get(j).set(n-1-i, cache);
            }
        }
    }
    public static void main(String[] args)
    {
        ArrayList<Integer> a = new ArrayList<Integer>(){{add(1);add(2);}};
        ArrayList<Integer> b = new ArrayList<Integer>(){{add(3);add(4);}};
        ArrayList<Integer> c = new ArrayList<Integer>(){{add(9);add(10);}};
        ArrayList<Integer> d = new ArrayList<Integer>(){{add(13);add(14);}};

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        //list.add(c);
       // list.add(d);

        rotate(list);

        for(int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
