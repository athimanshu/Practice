package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int minIdx = findMinIdx(nums);
        if (target == nums[minIdx]) return minIdx;
        int m = nums.length;
        int start = (target <= nums[m - 1]) ? minIdx : 0;
        int end = (target > nums[m - 1]) ? minIdx : m - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    public int findMinIdx(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end -  start) / 2;
            if (nums[mid] > nums[end]) start = mid + 1;
            else end = mid;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        SearchRotatedSortedArray obj = new SearchRotatedSortedArray();
        System.out.println(obj.search(arr,6));

    }
}
