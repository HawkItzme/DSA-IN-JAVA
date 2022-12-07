package com.syed.searching;

public class InfiniteArraySearch {
    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 8, 9, 10, 18, 21, 28, 29, 34, 36, 37, 39, 58};
        int target = 29;
        int result = ans(arr, target);
        System.out.println(result);

    }
    public static int ans(int[] arr, int target){
        int start = 0;
        int end = 1;
        while (target > arr[end]){
            int temp = end + 1;
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        return  binarysearch(arr, target, start, end);
    }
    static int binarysearch(int[] arr, int target, int start, int end){
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (target < arr[mid]){
                end = mid - 1;
            }
            else if (target < arr[mid]){
                start = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
