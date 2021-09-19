package interviewBit.bitwise;

import java.util.Arrays;
import java.util.List;

public class SingleOccurenceAllOtherAreThrice {
    final int INT_SIZE = 1000;
    //Ignore this... You understood below one better
    public int findSingleOccurence(List<Integer> list){

        int result = 0;
        int x,sum=0;

        for(int i =0;i<INT_SIZE;i++){
            sum =0;
            x = (1 << i);
            for(int j=0;j<list.size();j++){
                if((list.get(j) &x) == 0) //We are doing sum of bit present at each position
                    sum++;
            }
            if(sum%3 !=0)
                result |=x;
        }
        return result;
    }

    /**
     *  From Anuj BhaiyaYouTube Channel logic:https://www.youtube.com/watch?v=bTauscvOymA&list=PLUcsbZa0qzu3yNzzAxgvSgRobdUUJvz7p&index=4&ab_channel=AnujBhaiya
     *  Code Ref: https://www.geeksforgeeks.org/find-unique-element-element-occurs-k-times-except-one/
     *
     *
     */


    public int findSingleOccurence2(List<Integer> list){
        byte sizeof_int = 4;
        int INT_SIZE = 8 * sizeof_int;
        int count[] = new int[INT_SIZE];

        // AND(bitwise) each element of the array
        // with each set digit (one at a time)
        // to get the count of set bits at each
        // position
        for (int i = 0; i < INT_SIZE; i++)
            for (int j = 0; j < list.size(); j++)
                if ((list.get(j)& (1 << i)) != 0)
                    count[i] += 1;

        // Now consider all bits whose count is
        // not multiple of k to form the required
        // number.
        int res = 0;
        for (int i = 0; i < INT_SIZE; i++)
            res += (count[i] % 3) * (1 << i);
        return res;
    }

    public static void main(String[] args) {
        Integer[] arr = {890, 992, 172, 479, 973, 901, 417, 215, 901, 283, 788, 102, 726, 609, 379, 587, 630, 283, 10, 707, 203, 417, 382, 601, 713, 290, 489, 374, 203, 680, 108, 463, 290, 290, 382, 886, 584, 406, 809, 601, 176, 11, 554, 801, 166, 303, 308, 319, 172, 619, 400, 885, 203, 463, 303, 303, 885, 308, 460, 283, 406, 64, 584, 973, 572, 194, 383, 630, 395, 901, 992, 973, 938, 609, 938, 382, 169, 707, 680, 965, 726, 726, 890, 383, 172, 102, 10, 308, 10, 102, 587, 809, 460, 379, 713, 890, 463, 108, 108, 811, 176, 169, 313, 886, 400, 319, 22, 885, 572, 64, 120, 619, 313, 3, 460, 713, 811, 965, 479, 3, 257, 886, 120, 707, 120, 176, 374, 609, 395, 811, 406, 809, 801, 554, 3, 194, 11, 587, 169, 215, 313, 319, 554, 379, 788, 194, 630, 601, 965, 417, 788, 479, 64, 22, 22, 489, 166, 938, 66, 801, 374, 66, 619, 489, 215, 584, 383, 66, 680, 395, 400, 166, 572, 11, 992 };
        System.out.println(arr.length);
        SingleOccurenceAllOtherAreThrice obj = new SingleOccurenceAllOtherAreThrice();
//        System.out.println(obj.findSingleOccurence(Arrays.asList(arr)));
        System.out.println(obj.findSingleOccurence2(Arrays.asList(arr)));
    }
}
