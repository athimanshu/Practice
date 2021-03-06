package company.google;

import java.util.ArrayList;
import java.util.Stack;

public class NumberFollowingPattern {
    static int[] arr = new int[10];
    static String printMinNumberForPattern(String S){
        int lenOfD = 0;
        int lenOfI = 0;
        for(int i=1;i<=9;i++){
            arr[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        if(S.charAt(0) == 'I'){
            lenOfI = findLengthOfI(S);
            for(int i=1;i<=lenOfI;i++){
                sb.append(i);
                arr[i] = -1;
            }
        }else{
            lenOfD = findLengthOfD(S);
            for(int i = lenOfD;i>0; i--){
                sb.append(i);
                arr[i] = -1;
            }
        }
        int nextValue;
        int startIdx = Math.max(lenOfD,lenOfI);
        for(int i=startIdx;i<S.length();i++){
            nextValue = findNextValue(arr,S.charAt(i),sb.charAt(startIdx-1));
            sb.append(nextValue);
        }

        return sb.toString();
    }

    private static int findNextValue(int[] array, char C, char lastNum){
        int i=Integer.parseInt(String.valueOf(lastNum));
        if(C == 'I'){
            while(i<10){
                if(arr[i] != -1)
                    return arr[i];
                i++;
            }
        }else{
            while(i>0){
                if(arr[i] != -1)
                    return arr[i];
                i--;
            }
        }
        return -1;
    }
    private static int findLengthOfD(String S){
        int count  =0;
        int i =0;
        while(S.charAt(i) == 'D'){
            count++;
        }
        return count;
    }
    private static int findLengthOfI(String s) {

        int i =0;
        while(s.charAt(i) == 'I'){
            i++;
        }
        return i;
    }

    static void printLeast(String arr)
    {

        // min_avail represents the minimum number which is
        // still available for inserting in the output vector.
        // pos_of_I keeps track of the most recent index
        // where 'I' was encountered w.r.t the output vector
        int min_avail = 1, pos_of_I = 0;

        //vector to store the output
        ArrayList<Integer> al = new ArrayList<>();

        // cover the base cases
        if (arr.charAt(0) == 'I')
        {
            al.add(1);
            al.add(2);
            min_avail = 3;
            pos_of_I = 1;
        }

        else
        {
            al.add(2);
            al.add(1);
            min_avail = 3;
            pos_of_I = 0;
        }

        // Traverse rest of the input
        for (int i = 1; i < arr.length(); i++)
        {
            if (arr.charAt(i) == 'I')
            {
                al.add(min_avail);
                min_avail++;
                pos_of_I = i + 1;
            }
            else
            {
                al.add(al.get(i));
                for (int j = pos_of_I; j <= i; j++)
                    al.set(j, al.get(j) + 1);

                min_avail++;
            }
        }

        // print the number
        for (int i = 0; i < al.size(); i++)
            System.out.print(al.get(i) + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        String S = "DII";
//        System.out.println(printMinNumberForPattern(S));
        printLeast(S);
    }
}
