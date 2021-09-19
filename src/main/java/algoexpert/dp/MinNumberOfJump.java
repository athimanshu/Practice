package algoexpert.dp;

public class MinNumberOfJump {
    public static int minNumberOfJumps(int[] array) {
        if(array.length == 1){
            return 0;
        }
        int jumps = 0;
        int maxReach = array[0];
        int steps = array[0];

        for(int i=1;i<array.length-1;i++){
            if(steps>0){
                maxReach = Math.max(array[i]+i,maxReach);
                steps--;
            }
            if(steps == 0){
                jumps++;
                steps = maxReach - i;
            }
        }
        return jumps+1;
    }
    public static void main(String[] args) {
        int[] array = {3,4,2,1,2,3,7,1,1,1,3};
        minNumberOfJumps(array);
    }
}
