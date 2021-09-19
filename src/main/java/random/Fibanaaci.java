package random;

public class Fibanaaci {
    static int count =0 ;
    public static int fib(int n) {
        if(n>3){
             count = fib(n-1)+fib(n-2);
            System.out.print(count+" ");
        }else{
            return 1;
        }
        return count;
    }
    public static int printFib(int n){
        if(n == 0){
            return 0;
        } else if(n == 1) {
            return 1;
        } else {
            return (printFib(n-1) + printFib(n-2));
        }


    }
    public static void main(String[] args) {
        //System.out.println(fib(9));
        for(int i = 0;i<9;i++) {
            System.out.print(printFib(i)+"\t");
        }
    }
}
