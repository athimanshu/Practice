package interviewBit.bitwise;

import java.util.ArrayList;

/**
 * Solution Ref: https://www.youtube.com/watch?v=L_fIn5TM3mM&ab_channel=Pepcoding
 */
public class SumOfBitDifferences {
    public static long solution(int[] arr){
        long result = 0;
        for(int i=0;i<32;i++){
            long countOn = 0;
            for(int val : arr){
                if((val & (1<<i)) !=0){
                    countOn++;
                }
            }
           long countOff = arr.length - countOn;
            long diff = countOff * countOn *2;
            result +=diff;
        }
        return result;
    }
    public int cntBits(ArrayList<Integer> list) {
        long result = 0;
        for(int i=0;i<32;i++){
            long countOn = 0;
            for(int val : list){
                if((val & (1<<i)) !=0){
                    countOn++;
                }
            }
            long countOff = list.size() - countOn;
            long diff = countOff * countOn *2;
            result +=diff;
        }
        return (int) (result%1000000007);
    }
}
