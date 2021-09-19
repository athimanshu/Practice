package algoexpert.string;

public class RunLengthEncoding {
    public String runLengthEncoding(String string) {
        StringBuilder sb = new StringBuilder();
        char ch = string.charAt(0);
        int temp = 1;
        for(int i=1;i<string.length();i++){
            if(ch == string.charAt(i)){
                temp++;
                if(temp == 9){
                    sb.append(temp).append(ch);
                    temp = 0;
                }
                ch = string.charAt(i);
            }else{
                sb.append(temp).append(ch);
                ch = string.charAt(i);
                temp = 1;
            }
        }
        sb.append(temp).append(ch);
        return sb.toString();
    }
    public static void main(String[] args) {
        RunLengthEncoding rle = new RunLengthEncoding();
        System.out.println(rle.runLengthEncoding("........______=========AAAA   AAABBBB   BBB"));
    }
}
