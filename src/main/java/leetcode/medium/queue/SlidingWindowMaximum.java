package leetcode.medium.queue;

public class SlidingWindowMaximum {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n<2)
            return;
        int index = n-1;
        while(index >0){
            if(nums[index-1]<nums[index])
                break;
            index--;
        }
        if(index == 0){
            reverse(nums,0,n-1);
            return;
        }else{
            int val = nums[index-1];
            int j = n-1;
            while(j>=index){
                if(nums[j]>val)
                    break;
                j--;
            }
            swap(nums,j,index-1);
            reverse(nums,index,n-1);
            return;
        }
    }
    private void swap(int[] nums, int old, int newOne){
        int temp = nums[old];
        nums[old] = nums[newOne];
        nums[newOne] = temp;
    }

    public void reverse(int[] num, int start, int end){
        if(start>end)
            return;
        for(int i=start;i<=(end+start)/2;i++)
            swap(num,i,start+end-i);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2};
        new SlidingWindowMaximum().nextPermutation(arr);
    }
}
