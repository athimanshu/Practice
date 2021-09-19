package random;

/**
 * https://www.youtube.com/watch?v=8LusJS5-AGo&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=1
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/Knapsack01.java
 */

public class KnapsackProblem {

    public int knapsackProblem(int[] val, int[] weight, int maxWeight){
        int[][] k = new int[val.length+1][maxWeight+1];

        for(int i=0;i<val.length;i++){
            for(int j=0;j<maxWeight;j++){
                if(i==0 && j==0){
                    k[i][j] = 0;
                    continue;
                }
                if(j-weight[i-1] >=0){
                    k[i][j] = Math.max(val[i-1]+k[i-1][j-weight[i-1]], k[i-1][j]);
                }else{
                    k[i][j] = k[i-1][j];
                }
            }
        }
        return k[val.length][maxWeight];
    }
}
