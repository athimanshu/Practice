package random;

public class BinarySearch {

    public static int binarySearch(int[] arr, int x){
        int start = 0;
        int end = arr.length-1;
        return findVal(arr, start,end,x);

    }

    private static int findVal(int[] arr, int start,  int end, int target) {
        int mid = (end+start)/2;
        if(start >= end){
            return -1;
        }
        if(arr[mid] == target){
            return mid;
        }
        if(arr[mid]<target){
            findVal(arr,mid+1,end,target);
        }else{
            findVal(arr,start,mid-1,target);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,7};
        int find = 3;
        System.out.println(binarySearch(arr,find));
    }
}
