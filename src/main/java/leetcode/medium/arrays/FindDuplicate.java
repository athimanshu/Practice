package leetcode.medium.arrays;

/**
 * 287. Find the Duplicate Number
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 */
public class FindDuplicate {

    public int findDuplicate(int[] nums){
        if(nums.length>0){
            int slow = nums[0];
            int fast = nums[nums[0]];

            while(slow != fast){
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = 0;
            while(slow != fast){
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;

        }
        return  -1;
    }

    public static void main(String[] args) {
        FindDuplicate findDuplicate = new FindDuplicate();
        int arr[] = {7,6,1,5,3,2,1,4};
        System.out.println(findDuplicate.findDuplicate(arr));
    }
}
