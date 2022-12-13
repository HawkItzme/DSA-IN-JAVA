package com.syed.searching;

public class FindInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5 ,4, 3 ,2};
        int target = 4;
        System.out.println(searchArr(arr, target));
    }
    static int searchArr(int[] arr, int target){
        int peak = peakSearch(arr);
        int firstHalf = agnosticArray(arr, target, 0, peak);
        if (firstHalf != -1 ){
            return firstHalf;
        }
        int secondHalf = agnosticArray(arr, target, peak + 1, arr.length - 1);
        return secondHalf;
    }
    private static int peakSearch(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end){
            int mid = start + (end - start)/2;
            if (arr[mid] > arr[mid + 1]){
                end = mid;
            }else if (arr[mid] < arr[mid + 1]){
                start = mid + 1;
            }
        }
        return start;
    }
    private static int agnosticArray(int[] arr, int target, int start, int end) {
        boolean isAsc = arr[start] < arr[end];

        while(start < end){
            int mid = start + (end - start)/2;
            if (arr[mid] == target){
                return mid;
            }
            if (isAsc){
                if (arr[mid] > target){
                    end = mid - 1;
                }else
                    start = mid + 1;
            }
            if (!isAsc){
                if (arr[mid] > target){
                    start = mid + 1;
                }else
                    end = mid - 1;
            }
        }
        return -1;
    }
}
