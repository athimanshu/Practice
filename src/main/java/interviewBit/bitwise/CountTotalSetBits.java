package interviewBit.bitwise;

public class CountTotalSetBits {
    /**
     * Approach is https://www.youtube.com/watch?v=g6OxU-hRGtY&ab_channel=Pepcoding
     *
     * @return
     */
    public int youtubeSolution(int num){
        if(num ==0){
            return 0;
        }
        if(num ==1){
            return 1;
        }
        int x = largestPowerOfXLessThanNum(num);

        int bitsTillX = x * (1 << (x-1));
        int msbAfter2x = num - ((1<<x)) +1;
        int rest = num - (1<<x);
        int result = bitsTillX + msbAfter2x + youtubeSolution(rest);
        return  result;

    }

    private int largestPowerOfXLessThanNum(int n) {
        int x = 0;
        while ((1<<x) <= n){
            x++;
        }
        return x-1;
    }

    //My approach not so good
    public int solve(int num) {
        int modulo =1000000007;
        long result = 0;
        long count =1;
        long a = 1;
        while(count<=num){
            while(a!=0){
                a = a & (a-1);
                result =  (result % modulo) +1;
            }
            count++;
            a = count;
        }

        return (int)result%modulo;

    }
    public  int solution2(int n){
        int M = 1000000007;

        n++;
        int powOf2 = 2;
        int cnt = n/2;
        while(powOf2 <= n)
        {
            int totalPairs = n/powOf2;
            cnt +=  (totalPairs/2) * powOf2;
            cnt += (totalPairs%2 == 1) ? (n % powOf2) : 0 ;
            cnt = cnt % M;
            powOf2 = powOf2 << 1;
        }
        return cnt%M;
    }

    public static void main(String[] args) {
        CountTotalSetBits count = new CountTotalSetBits();
//        System.out.println(count.solve(1000000000));
        System.out.println(count.youtubeSolution(1000000000));
    }

}
