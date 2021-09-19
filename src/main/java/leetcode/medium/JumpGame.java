package leetcode.medium;

/**
 * 55. Jump Game
 */
public class JumpGame {

    //Greedy Approach used here
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i=0;i< nums.length;i++){
            if(i>farthest) {
                return false;
            }
            farthest = Math.max(nums[i]+i,farthest);
        }
        return true;
    }

    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        int[] nums = {2,3,1,4,2,1,0,0,1};
        System.out.println("Can Jump: "+jg.canJump(nums));
    }
}
