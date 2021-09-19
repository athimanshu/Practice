package algoexpert.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IncreasingSubsequence {
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        int[] sequences = new int[array.length];
        Arrays.fill(sequences,Integer.MIN_VALUE);
        int[] sum = array.clone();
        int maxSumIdx = 0;
        for (int i = 0; i < array.length; i++) {
            int currentNum = array[i];
            for (int j = 0; j < i; j++) {
                int otherNum = array[j];
                if (otherNum < currentNum && sum[j] + currentNum >= sum[i]) {
                    sum[i] = sum[j] + currentNum;
                    sequences[i] = j;
                }
            }
            if (sum[i] >= sum[maxSumIdx])
                maxSumIdx = i;
        }
    
        return buildSequence(array,sequences,maxSumIdx,sum[maxSumIdx]);
    }

    private static List<List<Integer>> buildSequence(int[] array, int[] sequences, int currentIdx, int sum) {
        List<List<Integer>> sequenceList = new ArrayList<>();

        sequenceList.add(new ArrayList<>());
        sequenceList.add(new ArrayList<>());
        sequenceList.get(0).add(sum);
        while(currentIdx != Integer.MIN_VALUE){
            sequenceList.get(1).add(0,array[currentIdx]);
            currentIdx = sequences[currentIdx];
        }
        return sequenceList;
    }

    public static void main(String[] args) {
        int[] arr= {10,70,20,30,50,11,30};
        maxSumIncreasingSubsequence(arr);
    }
}
