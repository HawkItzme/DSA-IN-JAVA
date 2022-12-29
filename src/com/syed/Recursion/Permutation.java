package com.syed.Recursion;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        permutation("", "abc");
    }
    static  void permutation(String p, String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++){
            String f = p.substring(0,i);
            String s = p.substring(i, p.length());
            permutation(f + ch + s, up.substring(1) );
        }
    }
}

class PermutInList{
    public static void main(String[] args) {

        System.out.println(permutation("", "abc"));

    }
    static ArrayList<String> permutation(String p, String up){
        if (up.isEmpty()){
            ArrayList<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++){
            String f = p.substring(0,i);
            String s = p.substring(i, p.length());
            ans.addAll( permutation(f + ch + s, up.substring(1)));

        }
        return ans;
    }
}
