package company.wunderman;

import java.util.Arrays;

public class Problem1 {
    public static void main(String[] args) {
//        int[] input1 = {10,12,2,5,1,9};
        int[] input1 = {2,10,50,32};
        Problem1 obj = new Problem1();
        System.out.println(obj.compute(input1,4,2));
    }
    public long compute(int[] input1, int input2, int input3) {
        long result = 0L;
        long mod = 1000000007L;
        Arrays.sort(input1);
        for(int i=0;i<input1.length;){

        }
        for(int i=0;i<input1.length-1;){
            int j=1;
            long tempSum = 1L;
            while(j<=input3){
                tempSum = (tempSum * input1[i])%mod;
                j++;
                i++;
            }
            result =(result + tempSum)%mod;
        }
        return result;
    }
}
