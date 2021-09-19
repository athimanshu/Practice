package company.zalando;

/**
 * Find minimal cost of dividing chain of N array A. Consisting of N integer.
 *
 */
public class Problem3 {
    //Problem 3
    public static int solution(int[] a) {
        int minimumSum = Integer.MAX_VALUE;
        int element1 = Integer.MAX_VALUE;
        int element2 = Integer.MAX_VALUE;
        System.out.println(element1);
        int minElement = a[1];
        int prevElement = a[2];

        for (int index = 3; index + 1 < a.length; index++) {
            int sum = minElement + a[index];
            if (sum < minimumSum) {
                minimumSum = sum;
                element1 = minElement;
                element2 = a[index];
            }

            if (prevElement < minElement) {
                minElement = prevElement;
            }
            prevElement = a[index];
        }

        return element1 + element2;
    }

    public static void main(String[] args) {
        solution(new int[]{2,3,52,13});
    }
}
