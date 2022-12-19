package com.syed.Recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 4, 7};
        bubblesort(arr, arr.length - 1, 0 );
        System.out.println(Arrays.toString(arr));
    }
    static void bubblesort(int[] arr, int r, int c){
        if (r == 0){
            return;
        }
        if (c < r){
            if (arr[c] > arr[r]){
                int temp = arr[c];
                arr[c] = arr[r];
                arr[r] = temp;
            }
            bubblesort(arr, r, c+1);
        }else {
            bubblesort(arr, r-1, 0);
        }
    }
}
