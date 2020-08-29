package Programming.Level2.Arrays.Problems.Arrangement;

import com.sun.tools.javac.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LargestNumber {
    public static class SignificantDecimalComparator implements Comparator<String>
    {
        @Override
        public int compare(String a, String b) {
            long abInt = Long.parseLong(a + b);
            long baInt = Long.parseLong(b + a);

            return Long.compare(baInt, abInt);
        }
    }
    public static String largestNumber(final List<Integer> A)
    {
        List<String> temp = A.stream().map(a -> a.toString()).collect(toList());

        List<String> result = temp.stream()
                                  .sorted((a,b) -> new SignificantDecimalComparator().compare(a,b))
                                  .collect(toList());

        if (result.get(0).equals("0")) {
            return "0";
        }

        return result.stream()
                     .reduce("", (a,b) -> a+b);
    }

    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(0, 0, 0, 0, 0);
        System.out.println(largestNumber(list));
    }
}
