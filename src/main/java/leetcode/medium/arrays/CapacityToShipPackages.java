package leetcode.medium.arrays;

/**
 * 1011. Capacity To Ship Packages Within D Days
 */
public class CapacityToShipPackages {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for(int weight: weights){
            max = Math.max(max,weight);
            sum += weight;
        }
        int l = max;
        int r = sum;
        while(l<=r){
            int mid = (l+r)/2;
            if(isValid(mid,weights,days)){
                r = mid -1;

            }else{
                l = mid + 1;
            }
        }
        return l;
    }
    private boolean isValid(int target, int[] weights, int days){
        int count = 1;
        int total = 0;

        for(int weight: weights){
            total +=weight;
            if(total>target){
                total = weight;
                count++;
                if(count>days){
                    return false;
                }
            }
        }
        return true;
    }
}
