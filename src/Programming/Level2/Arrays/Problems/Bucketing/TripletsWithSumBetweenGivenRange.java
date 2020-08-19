package Programming.Level2.Arrays.Problems.Bucketing;

import java.util.ArrayList;

/*
Soln Explanation : https://www.quora.com/Programming-Interviews/Given-n-positive-real-numbers-find-whether-there-exists-a-triplet-among-this-set-such-that-the-sum-of-the-triplet-is-in-the-range-1-2-Do-it-in-linear-time-and-constant-space
 */

public class TripletsWithSumBetweenGivenRange {
    public static int solve(ArrayList<String> A) {
        if (A.size() < 3) {
            return 0;
        }

        ArrayList<Double> doubles = convertToDoubles(A);

        ArrayList<Double> bucketA = new ArrayList<>();
        ArrayList<Double> bucketB = new ArrayList<>();
        ArrayList<Double> bucketC = new ArrayList<>();

        bucketize(doubles, bucketA, bucketB, bucketC);

        int result = checkCase1(bucketA);
        if (result == 1) {
            return result;
        }

        result = checkCase2(bucketA, bucketB);
        if (result == 1) {
            return result;
        }

        result = checkCase3(bucketA, bucketC);
        if (result == 1) {
            return result;
        }

        result = checkCase4(bucketA, bucketB, bucketC);
        if (result == 1) {
            return result;
        }

        result = checkCase5(bucketA, bucketB);
        if (result == 1) {
            return result;
        }

        return 0;
    }

    private static int checkCase5(ArrayList<Double> bucketA, ArrayList<Double> bucketB) {
        if (bucketA.size() < 1 || bucketB.size() < 2) {
            return 0;
        }

        Double min1 = Double.MAX_VALUE, min2 = Double.MAX_VALUE, min3 = Double.MAX_VALUE;

        for (Double value : bucketA) {
            if (value < min1) {
                min1 = value;
            }
        }

        for(Double value : bucketB) {
            if (value < min2) {
                min3 = min2;
                min2 = value;
            }
            else if (value < min3) {
                min3 = value;
            }
        }


        Double sum = min1 + min2 + min3;

        return sum > 1 && sum < 2 ? 1:0;
    }

    private static int checkCase4(ArrayList<Double> bucketA, ArrayList<Double> bucketB, ArrayList<Double> bucketC) {
        if (bucketA.size() < 1 || bucketB.size() < 1 || bucketC.size() < 1) {
            return 0;
        }

        Double min1 = Double.MAX_VALUE, min2 = Double.MAX_VALUE, min3 = Double.MAX_VALUE;

        for (Double value : bucketA) {
            if (value < min1) {
                min1 = value;
            }
        }

        for (Double value : bucketB) {
            if (value < min2) {
                min2 = value;
            }
        }

        for (Double value : bucketC) {
            if (value < min3) {
                min3 = value;
            }
        }

        Double sum = min1 + min2 + min3;

        return sum > 1 && sum < 2 ? 1:0;
    }

    private static int checkCase3(ArrayList<Double> bucketA, ArrayList<Double> bucketC) {
        if (bucketA.size() < 2 || bucketC.size() < 1) {
            return 0;
        }

        Double min1 = Double.MAX_VALUE, min2 = Double.MAX_VALUE, min3 = Double.MAX_VALUE;

        for(Double value : bucketA) {
            if (value < min1) {
                min2 = min1;
                min1 = value;
            }
            else if (value < min2) {
                min2 = value;
            }
        }

        for (Double value : bucketC) {
            if (value < min3) {
                min3 = value;
            }
        }

        Double sum = min1 + min2 + min3;

        return sum > 1 && sum < 2 ? 1:0;
    }

    private static int checkCase2(ArrayList<Double> bucketA, ArrayList<Double> bucketB) {
        if (bucketA.size() < 2 || bucketB.size() < 1) {
            return 0;
        }

        Double max1 = Double.MIN_VALUE, max2 = Double.MIN_VALUE;

        for(Double value : bucketA) {
            if (value > max1) {
                max2 = max1;
                max1 = value;
            }
            else if (value > max2) {
                max2 = value;
            }
        }

        Double sum = max1 + max2;

        for(Double value : bucketB) {
            if ((value > 1-sum) && (value < 2 - sum)) {
                return 1;
            }
        }

        return 0;
    }

    private static int checkCase1(ArrayList<Double> bucketA) {
        if (bucketA.size() < 3) {
            return 0;
        }

        Double max1 = Double.MIN_VALUE, max2 = Double.MIN_VALUE, max3 = Double.MIN_VALUE;

        for(Double value : bucketA) {
            if (value > max1) {
                max3 = max2;
                max2 = max1;
                max1 = value;
            }
            else if(value > max2) {
                max3 = max2;
                max2 = value;
            }
            else if(value > max3) {
                max3 = value;
            }
        }

        Double sum = max1 + max2 + max3;
        return sum > 1 && sum < 2 ? 1 : 0;
    }

    private static void bucketize(ArrayList<Double> doubles, ArrayList<Double> bucketA, ArrayList<Double> bucketB, ArrayList<Double> bucketC) {
        Double zero = 0.0d;
        Double twoThird = 2/3d;
        Double one = 1.0d;
        Double two = 2.0d;

        for(Double value : doubles) {
            if (value > zero && value < twoThird) {
                bucketA.add(value);
            }
            else if (value >= twoThird && value <= one) {
                bucketB.add(value);
            }
            else if (value > one && value < two) {
                bucketC.add(value);
            }
        }
    }

    private static ArrayList<Double> convertToDoubles(ArrayList<String> a) {
        ArrayList<Double> doubles = new ArrayList<>(a.size());

        for(String str : a) {
            doubles.add(Double.valueOf(str));
        }

        return doubles;
    }

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<String>(){{add("0.628934");add("0.939859");add("0.898308");}};
        System.out.println(solve(input));
    }
}
