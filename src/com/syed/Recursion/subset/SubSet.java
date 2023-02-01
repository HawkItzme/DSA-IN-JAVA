package com.syed.Recursion.subset;

import java.util.Arrays;

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