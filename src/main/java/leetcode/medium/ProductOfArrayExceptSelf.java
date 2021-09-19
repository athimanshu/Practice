package leetcode.medium;

/**
 * 238. Product of Array Except Self
 */
public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for(int i=0,t=1;i<nums.length;i++){
            result[i] = t;
            t = t* nums[i];
            System.out.print(result[i] + "\t");
        }
        System.out.println();
        for (int i= nums.length-1,t=1;i>=0;i--){
            result[i] = result[i] * t;
            t = t* nums[i];
            System.out.print(result[i] + "\t");
        }
        System.out.println();
        return  result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        int[] result = productExceptSelf(nums);

        for(int i =0; i<nums.length;i++){
            System.out.print(result[i] + "\t");
        }
    }
}
