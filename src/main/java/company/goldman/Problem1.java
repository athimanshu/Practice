package company.goldman;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Traveller Fund
 */
public class Problem1 {

    public static int requiredAmountAtStart(List<Integer> netSaving){

        int minProfit = 0;
        int currProfit = 0;
        boolean flag = false;

        for (Integer val: netSaving) {
            currProfit += val;

            if (currProfit <= 0) {
                minProfit += Math.abs(currProfit) + 1;
                currProfit = 1;
                flag = true;
            }
        }
        return (flag == false) ? 1 : minProfit;
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(4,2,-3);
        System.out.println(requiredAmountAtStart(integers));
    }
}
