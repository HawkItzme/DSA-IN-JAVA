package com.syed.dynamicprograming;

// Recursion -> Memoization -> Top-Down
public class knapsack_pattern {
    public static void main(String[] args) {

        // Pattern 1
        int[] arr = new int[]{2, 3, 4, 5, 7};
        int sum = 11;
        /*
        int[][] memo = new int[arr.length + 1][sum + 1];
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= sum; j++) {
                memo[i][j] = -1;
            }
        }
        boolean ans = subsetSumPresent1(arr, sum, arr.length - 1, memo);*/

        boolean ans = subsetSumPresent2(arr, sum);
        System.out.println(ans);
    }

    /** Pattern 1
     * Subset Sum - Given the Integer Array and an integer sum value.
     * We have to find out if there's least a single SUBSET of this array,
     * whose elements sum is equal to the given integer sum value ?
     */
    // Sol 1 - Using Recursion + Memoization
    private static boolean subsetSumPresent1(int[] arr, int sum, int n, int[][] memo){

         if (memo[n][sum] != -1){
             return memo[n][sum] == 1;
         }

        if (sum == 0){
            memo[n][sum] = 1;
            return true;
        }

        if (n == 0){
            memo[n][sum] = 0;
            return false;
        }


        if (arr[n] <= sum){
            memo[n][sum] = ( subsetSumPresent1(arr,sum - arr[n],n-1, memo) || subsetSumPresent1(arr, sum, n-1, memo) ) ? 1 : 0;
        } else if (arr[n] > sum) {
            memo[n][sum] = subsetSumPresent1(arr,sum,n-1, memo) ? 1 : 0;
        }

         return memo[n][sum] == 1;
    }

    // Sol 2 - Using Tabular approach (Top-Down) - No recursion
    private static boolean subsetSumPresent2(int[] arr, int sum){

        boolean[][] t = new boolean[arr.length + 1][sum+1];
        for (int i = 0; i <= arr.length ; i++){
            for(int j = 0; j <= sum; j++){
                if (i == 0){
                    t[i][j] = false;
                }
                if (j==0) {
                    t[i][j] = true;
                }
                if (i!=0 && arr[i-1] <= j){
                    t[i][j] = t[i][j - arr[i-1]] || t[i-1][j] ;
                }else if (i!=0 && arr[i-1] > j){
                    t[i][j] = t[i-1][j] ;
                }
            }
        }
        return t[arr.length][sum];
    }
}
