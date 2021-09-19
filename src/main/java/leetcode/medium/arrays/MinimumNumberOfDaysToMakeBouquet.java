package leetcode.medium.arrays;

public class MinimumNumberOfDaysToMakeBouquet {

    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < m *k) return -1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i: bloomDay){
            min = Math.min(i,min);
            max = Math.max(i,max);
        }
        while(min<max){
            int mid = min + (max-min)/2;
            int possibleBouquets = findPossibleBouquets(bloomDay,mid,k);

            if(possibleBouquets<m){
                min = mid + 1;
            }else{
                max = mid;
            }
        }
        return min;
    }

    private int findPossibleBouquets(int[] bloomDay, int day, int k) {

        int bouquets = 0, flowersCollected = 0;
        for (int value : bloomDay) {
            if(value <= day){
                flowersCollected++;
            }else{
                flowersCollected = 0;
            }
            if(flowersCollected == k){
                bouquets++;
                flowersCollected = 0;
            }
        }
        return bouquets;
    }

}
