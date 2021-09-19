package company.expedia;

public class kthFactorElement {


    public  static  long kthFactor(long n,long p){

        long count = 0;
        long kthKey = 0;
        boolean flag = false;
        for (long i =1; i<=n;++i){
            if(n%i==0){
                System.out.print(" "+i);
                count++;
               // i = i*i;
            }
            if (count==p){
                kthKey = i;
                flag = true;
                return i;
            }
        }

        if(!flag)
            return 0;
        else
            return  kthKey;

    }

    public static void main(String[] args) {
       // System.out.println("Element is: "+ kthFactor(22876792454961l,28));
       // System.out.println("\nElement is: "+ kthFactor(20789890,13));
       // System.out.println("\nElement is: "+ kthFactor(20789891,13));
        System.out.println("\nElement is: "+ kthFactor(10,3));
    }
}
