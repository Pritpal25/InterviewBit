package Programming.Level2.Arrays.Problems.SpaceRecycle;

import java.util.ArrayList;

public class SetMatrixZeroes {
    public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
        boolean firstRow = true, firstCol = true;

        for(int i = 0; i < a.size(); i++)
        {
            for(int j = 0; j < a.get(0).size(); j++)
            {
                if (i == 0 && a.get(i).get(j) == 0)
                    firstRow = false;

                if (j == 0 && a.get(i).get(j) == 0)
                    firstCol = false;

                if (a.get(i).get(j) == 0)
                {
                    a.get(i).set(0, 0);
                    a.get(0).set(j, 0);
                }
            }
        }

        for(int i = 1; i < a.size(); i++)
        {
            for(int j = 1; j < a.get(0).size(); j++)
            {
                if (a.get(i).get(0) == 0 || a.get(0).get(j) == 0)
                    a.get(i).set(j, 0);
            }
        }

        if (!firstRow)
        {
            for(int j = 0; j < a.get(0).size(); j++)
            {
                a.get(0).set(j, 0);
            }
        }

        if(!firstCol)
        {
            for (int i = 0; i < a.size(); i++)
            {
                a.get(i).set(0, 0);
            }
        }

    }
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        array.add(new ArrayList<Integer>() {{add(1);add(0);add(1);}});
        array.add(new ArrayList<Integer>() {{add(1);add(1);add(1);}});
        array.add(new ArrayList<Integer>() {{add(1);add(0);add(1);}});

        setZeroes(array);
        for (int i = 0; i < array.size(); i++) {
            for(int j = 0; j < array.size(); j++) {
                System.out.print(array.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
