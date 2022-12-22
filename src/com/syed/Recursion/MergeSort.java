package com.syed.Recursion;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4, 9, 7, 2, 6, 1};
        mergeSortInplace(arr, 0, arr.length);
        System.out.print(Arrays.toString(arr));

    }
    static int[] mergeSort(int[] arr){
        if (arr.length == 1){
            return arr;
        }
        int mid = arr.length / 2;

        //here in Arrays.copyOfRange - "to" argument is exclusive
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first.length && j < second.length){
            if (first[i] < second[j]){
                mix[k] = first[i];
                i++;
            }else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < first.length){
            mix[k] = first[i];
            k++;
            i++;
        }
        while (j < second.length){
            mix[k] = second[j];
            k++;
            j++;
        }

        return mix;

    }

    //Merge inplace
    static void mergeSortInplace(int[] arr, int s, int e){
        if (e-s == 1){
            return;
        }
        int mid = (e + s) / 2;

        //here in Arrays.copyOfRange - "to" argument is exclusive
        mergeSortInplace(arr, 0, mid);
        mergeSortInplace(arr, mid, e);

        mergeInplace(arr, s, mid, e );
    }

    private static void mergeInplace(int[] arr, int s, int mid, int e) {
        int[] mix = new int[e - s];
        int i = s;
        int j = mid;
        int k = 0;

        while (i < mid && j < e){
            if (arr[i] < arr[j]){
                mix[k] = arr[i];
                i++;
            }else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < mid){
            mix[k] = arr[i];
            k++;
            i++;
        }
        while (j < e){
            mix[k] = arr[j];
            k++;
            j++;
        }

        for(int l = 0; l< mix.length; l++){
            arr[s +l] = mix[l];
        }

    }
}
