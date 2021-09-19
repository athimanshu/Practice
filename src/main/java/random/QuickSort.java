package random;

public class QuickSort {
    public int[] quickSort(int arr[], int start, int end){

        int pivot = getPivot(arr, start, end);
        if(start<pivot -1)
            quickSort(arr,start,pivot-1);
        if (pivot<end)
            quickSort(arr,pivot,end);


        return arr;
    }

    public int getPivot(int[] arr,int start,int end){
        int pivot = arr[(start+end)/2];

        while (start<=end) {
            while (arr[start] < pivot)
                start++;
            while (arr[end] > pivot)
                end--;
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;

    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] a = {5,2,8,3,6,1,9};
        quickSort.quickSort(a,0,6);
    }
}
