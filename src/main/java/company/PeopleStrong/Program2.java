package company.PeopleStrong;

public class Program2 {
    public static long solution(String n){
        if(n.length()<4) return 0;
        int count = 0;

        for(int i=0;i<n.length()-4;i++){
            StringBuilder sb =new StringBuilder();
            for(int j=i;j<i+4;j++){
                sb.append(n.charAt(j));// = num*10+(int) n.charAt((int) j);

            }
            if (isStable(sb.toString())) count++;
        }
        return count;
    }
    private static boolean isStable(String num){
        if(num.charAt(0) == num.charAt(1))
            return true;
        if(num.charAt(2) == num.charAt(3))
            return true;
        int x = Integer.parseInt(num.substring(0,2));
        int y= Integer.parseInt(num.substring(2,4));
        return x+1 == y;
    }

    public static void main(String[] args) {
        String s = "22233424";
        System.out.println(solution(s));
    }
}
