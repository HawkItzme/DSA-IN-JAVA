package com.syed.Recursion;

import java.util.ArrayList;

public class MobilePad {
    public static void main(String[] args) {
        padRet("", "12");
    }
    static void padRet(String p, String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3; i++){
            char ch = (char) ('a' + i);
            padRet(p + ch, up.substring(1));
        }
    }
}

class MobilePadList{
    public static void main(String[] args) {
        System.out.println(padRet("", "12"));
    }
    static ArrayList<String> padRet(String p, String up){
        if (up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        int digit = up.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3; i++){
            char ch = (char) ('a' + i);
            ans.addAll(padRet(p + ch, up.substring(1)));
        }
        return ans;
    }
}