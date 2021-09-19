package company.kronos;

public class SurajTask1 {
    public static int getClosestToZero(int[] a){
        int minDiff = Integer.MAX_VALUE;
        int result = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            int diff = Math.abs(0-a[i]);
            if(diff<minDiff){
                minDiff = diff;
                result = a[i];
            }else if(diff == minDiff){
                result = Math.max(result,a[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4,113,59,-2,5};
        int[] arr2 = {4,113,59,-2,5,2};
        System.out.println(getClosestToZero(arr));
        System.out.println(getClosestToZero(arr2));
    }
}
