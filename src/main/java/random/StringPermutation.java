package random;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    public List<String> findPermutations(String s){
        List<String> result = new ArrayList<>();
        permute("",s,result);
        return result;
    }

    private void permute(String prefix, String remaining, List<String> result) {
        if(remaining.length() == 0) result.add(prefix);

        int len = remaining.length();
        for(int i=0;i<len;i++){
            String before = remaining.substring(0,i);
            String after = remaining.substring(i+1,len);
            Character ch = remaining.charAt(i);
            permute(prefix+ch,before+after,result);
        }

    }


    public static void main(String[] args) {
        StringPermutation stringPermutation = new StringPermutation();
        stringPermutation.findPermutations("String").stream().forEach(p-> System.out.println(p));
        System.out.println(stringPermutation.findPermutations("String").size());
    }

}
