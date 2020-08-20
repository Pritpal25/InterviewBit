package Programming.Level2.Arrays.Problems.Bucketing;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxConsecutiveGap {
    public static class MinMaxPair {
        int min;
        int max;

        public MinMaxPair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public static int maximumGap(final List<Integer> A) {
        // Base condition
        int size = A.size();
        if (size < 2) {
            return 0;
        }

        // Finding min and max
        int min = Collections.min(A), max = Collections.max(A);

        // Gap will be max when all other n-2 elements are either equal to min or max
        // Gap will be min when all other n-2 elements are equally spaced - since there are going to be n-1 gaps
        // Max = Min + (n-1)*minPossibleGap (which will be max gap if they are equally spaced.)
        double min_maxConsecutiveGap = (double) (max - min)/(size-1);
        // For our problem, the gap will always lie between [min_maxConsecutiveGap, Max-Min]

        // We bucketize the integers into their buckets and only check for max gap between max of previous bucket and
        // min of current non null bucket.
        MinMaxPair[] buckets = new MinMaxPair[size-1];

        for(int i = 0; i < size; i++) {
            int curr_value = A.get(i);

            // Its easier to see this on pen and paper.
            int bucket_Index = (int) ((curr_value - min)/min_maxConsecutiveGap);

            // This is to cover the overflow case, since the buckets are [Min, min + gap), [Min + gap, min + 2*gap).....[Min+(n-2)gap,Min + (n-1)gap]
            // In order to get the Max element as part of the last buckets and not overflow, we had to do this.
            // Otherwise, we can make n buckets and the Max element can be the only candidate for the last bucket, check this by commenting the if
            // and changing the size of buckets array to size.
            if (bucket_Index == size - 1) {
                bucket_Index--;
            }
            MinMaxPair curr_pair = buckets[bucket_Index];

            if(curr_pair == null) {
                MinMaxPair new_pair = new MinMaxPair(curr_value, curr_value);
                buckets[bucket_Index] = new_pair;
            }
            else {
                if (curr_value > curr_pair.max) {
                    curr_pair.max = curr_value;
                    buckets[bucket_Index] = curr_pair;
                }
                else if (curr_value < curr_pair.min) {
                    curr_pair.min = curr_value;
                    buckets[bucket_Index] = curr_pair;
                }
            }
        }

        int maxConsecutiveGap = (int)min_maxConsecutiveGap; // This will the max value in worst case.
        MinMaxPair prev_pair = buckets[0];
        MinMaxPair curr_pair = buckets[0];

        for(int i = 1; i < buckets.length; i++) {
            MinMaxPair this_pair = buckets[i];

            if (this_pair != null) {
                prev_pair = curr_pair;
                curr_pair = this_pair;
                // Compare min of current with max of previous only when a new non null pair is found.
                if (curr_pair.min - prev_pair.max > maxConsecutiveGap) {
                    maxConsecutiveGap = curr_pair.min - prev_pair.max;
                }
            }
        }

        return maxConsecutiveGap;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6, 15, 9, 21, 17);
        List<Integer> list1 = Arrays.asList(100, 49, 0);
        System.out.println(maximumGap(list));
    }
}
