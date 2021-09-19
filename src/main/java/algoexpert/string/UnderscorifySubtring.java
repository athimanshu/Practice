package algoexpert.string;

public class UnderscorifySubtring {
    public static String underscorifySubstring(String str, String substring) {
        StringBuilder sb = new StringBuilder();
        int winSize = substring.length();
        int start = 0;
        int end = winSize;
        boolean found = false;
        for(int i=0; i<str.length(); i++){

            if(i+winSize<=str.length() && str.substring(i,i+winSize).equals(substring)){
                if(i!=0 && i<end){
                    sb.append(str, i+1, i+winSize);
                    end = i+winSize;
                }else {
                    start = i;
                    end = i + winSize;
                    if(!found){
                        sb.append("_").append(substring);
                    }else{
                        sb.append(substring);
                    }
                }
                found = true;
            }
            if(found && i>start && i<end){
                //do nothing
            }else if(found && i>=end){
                sb.append("_");
                found = false;
            }	if((!found && i>=end-1) || (!found && start==0 && end == winSize)) {
                sb.append(str.charAt(i));
            }
        }
        if(found && end == str.length()){
            sb.append("_");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str1 = "tttttctatawtatttttastvb";
        String str2 = "ttt";
        System.out.println(UnderscorifySubtring.underscorifySubstring(str1,str2));
    }
}
