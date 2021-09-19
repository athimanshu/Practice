package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 * To understand read the leetcode S=given solution and approach 4
 * The idea behind this approach is as follows: If the cumulative sum(represented by sum[i]sum[i] for sum up to i^{th}ith index) up to
 *  two indices is the same, the sum of the elements lying in between those indices is zero. Extending the same thought further,
 *   if the cumulative sum up to two indices, say ii and jj is at a difference of kk i.e. if sum[i] - sum[j] = ksum[i]−sum[j]=k,
 *   the sum of elements lying between indices ii and jj is kk.
 */

public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubArraySumEqualsK obj = new SubArraySumEqualsK();
        int [] nums = {3,4,7,2,-3,1,4,2};//{2,3,5,2,-3,-7,15,0,5};
        System.out.println(obj.subarraySum(nums,7));
    }
}
