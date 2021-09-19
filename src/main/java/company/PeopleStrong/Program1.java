package company.PeopleStrong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program1 {
    public static List<Integer> getOneBits(int n){
        List<Integer> result = new ArrayList<>();
        int count=0;
        for(int i = 0; i < 32; i++){
            int temp = (n >> i & 1);
            if(temp == 1) result.add(i);
            count += temp;
        }
        int size = result.size();
        for(int i=0;i<size;i++){
            result.set(i,(Math.abs(result.get(i)-result.get(size-1)))+1);
        }
        Collections.reverse(result);
        result.add(0,count);
        return result;
    }

    public static void main(String[] args) {

        List<Integer> output = getOneBits(65);
        output.stream().forEach(p-> System.out.println(p));
    }
}
