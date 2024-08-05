package com.syed;

public class Testonline {
    // [9,-4,-3,4,-2,-6,5,6,-1]
    public static void main(String[] args) {
        int[] arr = {9, -4, -3, 4, -2, -6, 5, 6, -1};
        System.out.println(maxSum(arr));
    }
     private static int maxSum(int[] arr){
        int n = arr.length;
        int maxsum = arr[0];
        int sum = arr[0];
        for (int a = 1; a < n; a++){
            sum += arr[a];
            if(maxsum < sum){
                maxsum = sum;
            }
            if (sum < 0){
                sum = arr[a];
            }
        }
        return maxsum;
     }
}
