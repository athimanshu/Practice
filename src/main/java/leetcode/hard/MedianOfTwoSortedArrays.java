package leetcode.hard;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Double result = 0.0;

        int[] output = mergeTwoArray(nums1, nums2);
        int length = output.length;
        if(length == 1){
            return output[0];
        }

        else if(output.length%2 != 0){

            return output[(length-1)/2];
        }else{
            return (output[length/2 -1] + output[length/2])/2.0;
        }

    }

    int[] mergeTwoArray(int[] nums1, int[] nums2){
        int k = nums1.length+nums2.length;
        int[] output = new int[k];
        int m =nums1.length;
        int n =nums2.length;
        k=0;
        for(int i=0,j=0;k<m+n;){
            if(i<m && j<n && nums1[i]<nums2[j]){
                output[k] = nums1[i];
                k++;
                i++;
            }
            else if(i<m && j<n && nums1[i]>nums2[j]){
                output[k] = nums2[j];
                k++;
                j++;
            }
            else if (i==m){
                output[k]= nums2[j];
                j++;
                k++;
            }
            else if(j==n){
                output[k] = nums1[i];
                i++;
                k++;
            }
            else {
                output[k] = nums1[i];
                k++;
                output[k] = nums2[j];
                k++;
                i++;
                j++;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
        System.out.println(obj.findMedianSortedArrays(nums1,nums2));
    }
}