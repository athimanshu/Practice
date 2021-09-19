package leetcode.medium.string;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Medium 179. Largest Number
 * Given a list of non-negative integers nums, arrange them such that they form the largest number.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * Example 2:
 *
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
//       List<Integer> integerList = Arrays.stream(nums).boxed().collect(Collectors.toList());
//        List<String> stringList = new ArrayList<>(integerList.size());
        if(nums == null || nums.length == 0)
            return "";
        String[] strings = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strings[i] = String.valueOf(nums[i]);
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(strings,comparator);
        //Arrays.sort(strings,(a,b) -> (a+b).compareTo(b+a)); You can write this line instead od separate comparator
        // An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if(strings[0].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();
        for(String s: strings)
            sb.append(s);

        return sb.toString();

    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        LargestNumber obj = new LargestNumber();
        obj.largestNumber(nums);
    }
}
