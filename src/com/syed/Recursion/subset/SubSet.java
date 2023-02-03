package com.syed.Recursion.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        String str = "cab";
        powerSet(str);
    }
    static void powerSet(String str)
    {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        permuteRec( " " , new String(arr));
    }
    static void permuteRec(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        permuteRec(p+ch, up.substring(1));
        permuteRec(p, up.substring(1));

    }
}

class LExiSubSet{
    public static void main(String[] args) {
        String s = "abc";
        for(int i = 0; i < s.length(); i++){
            permute(String.valueOf(s.charAt(i)), s, i, s.length());
        }
    }
    public static void permute(String ch, String s, int index, int n){

        if(index == n){
            return;
        }
        System.out.println(ch);
        for (int i = index + 1; i < n; i++){
            permute(ch + s.charAt(i), s, i++, n);
        }
    }
}

class SubSetArray{
    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
    public static  List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>() ;
        List<Integer> ds = new ArrayList<>() ;
        int n = nums.length ;

        solve(0, n, nums, ds, result) ;
        return result ;
    }
    private static void solve(int index, int n, int[] nums, List<Integer> ds, List<List<Integer>> result) {
        if (index == n) {
            result.add(new ArrayList<>(ds)) ;
            return ;
        }

        ds.add(nums[index]) ;
        solve(index+1, n, nums, ds, result) ;
        ds.remove(ds.size()-1) ;
        solve(index+1, n, nums, ds, result) ;
    }
}