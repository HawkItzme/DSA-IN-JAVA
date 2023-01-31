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
