package random;

public class RecursiveMultiply {
    int minProduct(int a, int b){
        int bigger = a>b?a:b;
        int smaller = a<b?a:b;
        return productHelper(smaller,bigger);
    }
    int productHelper(int smaller, int bigger){
        if(smaller == 0) return 0;
        if(smaller == 1) return bigger;

        int s = smaller >> 1;
        int halfProd = minProduct(s,bigger);
        if(smaller%2 == 0)
            return halfProd + halfProd;
        else
            return halfProd + halfProd + bigger;
    }

    public static void main(String[] args) {
        RecursiveMultiply recursiveMultiply = new RecursiveMultiply();
        int a = 16;
        int b = 100;
        System.out.println(recursiveMultiply.minProduct(a,b));
    }
}
