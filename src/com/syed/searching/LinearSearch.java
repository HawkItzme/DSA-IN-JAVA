package com.syed.searching;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {2, 5, 4, 6, 7};
        int target = 6;
        int result = Search(arr, target);
        System.out.println(result);
    }
    public static int Search(int[] arr, int target){
        for (int i = 0; i < arr.length; i++ )
        {
            if (arr[i] == target){
                return i;
            }
        }return -1;
    }
}
