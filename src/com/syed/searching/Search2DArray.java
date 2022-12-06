package com.syed.searching;

import java.util.Arrays;
import java.util.Scanner;

public class Search2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the elements of your 2-D Array = ");
        int[][] arr = new int[4][3];
        for (int i = 0; i< 4; i++){
            for (int j = 0; j < arr[i].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i< 4; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println("Enter the number to be searched = ");
        int target  = sc.nextInt();
        int[] add = search(arr, target);
        System.out.println("The address = " + Arrays.toString(add));
    }
    static int[] search(int[][] arr, int target){
        for (int a = 0; a< arr.length; a++){
            for (int b = 0; b<arr[a].length; b++){
                if (arr[a][b] == target)
                    return new int[]{a, b};
            }
        }
        return new int[]{-1, -1};
    }
}
