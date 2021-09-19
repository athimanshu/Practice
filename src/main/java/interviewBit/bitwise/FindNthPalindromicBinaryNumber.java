package interviewBit.bitwise;

/**
 * Find Nth palindromic binary (this is similar to interview bit one but different question)
 * Solution Ref: https://www.youtube.com/watch?v=QYoWR8hDCyQ&ab_channel=Pepcoding
 */
public class FindNthPalindromicBinaryNumber {

    public static int findNthPalindromicBinaryNumber(int n){
        int count = 1;
        int len = 1;
        while (count < len){
            len++;
            int elementsForThisLength = (1<<(len-1)/2);
            count += elementsForThisLength;
        }
        count -= (1 << (len-1)/2);
        int offset = n -count -1;

        int result = 1 << (len-1);
        result |= (offset << (len/2));

        int valForReverse = result >> (len/2);
        int reverse = reverse(valForReverse);
        result |= reverse;
        return  result;
    }
    private static int reverse(int n){
        int rev = 0;
        while(n!=0){
            int lb = (n & 1);
            rev |= lb;

            rev <<= 1;
            n>>=1;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(findNthPalindromicBinaryNumber(8));
    }
}
