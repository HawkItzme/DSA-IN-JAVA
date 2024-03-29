package com.syed.Recursion;

public class Stream {
    public static void main(String[] args) {
        skip("", "baccah");
    }
    static void skip(String p, String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if (ch == 'a'){
            skip(p, up.substring(1));
        }else {
            skip(p+ch, up.substring(1));
        }
    }
}

class Stream_2{
    public static void main(String[] args) {
        System.out.println(skip("baccab"));
    }
    static String  skip( String up){
        if (up.isEmpty()){
            return " ";
        }
        char ch = up.charAt(0);
        if (ch == 'a'){
            return skip(up.substring(1));
        }else {
            return ch + skip( up.substring(1));
        }
    }
}

class Stream_3{
    public static void main(String[] args) {
        System.out.println(skip("abcdappleghf"));
    }
    static String skip(String up){
        if (up.isEmpty()){
            return " ";
        }
        if (up.startsWith("apple")){
            return skip(up.substring(5));
        }else {
            return  up.charAt(0) + skip(up.substring(1));
        }
    }
}

class Stream_4{
    public static void main(String[] args) {
        System.out.println(skip("abcdapplegapphf"));
    }
    static String skip(String up){
        if (up.isEmpty()){
            return " ";
        }
        if (up.startsWith("app") && !up.startsWith("apple")){
            return skip(up.substring(3));
        }else {
            return  up.charAt(0) + skip( up.substring(1));
        }
    }
}