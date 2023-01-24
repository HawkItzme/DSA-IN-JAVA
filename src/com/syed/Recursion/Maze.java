package com.syed.Recursion;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        System.out.println(count(3, 3));
    }
    static int count(int r, int c){
        if (r == 1 || c == 1){
            return 1;
        }
        int left = count(r-1, c);
        int right = count(r, c - 1);
        return left + right;
    }
}

class MazePath{
    public static void main(String[] args) {
        path("", 3, 3);
    }
    static void
    path(String p, int r, int c){
        if (r == 1 && c == 1){
            System.out.println(p);
            return;
        }
        if (r>1){
            path(p + 'D', r - 1, c);
        }
        if (c > 1){
            path(p + 'R', r, c - 1);
        }
    }
}

class pathInList{
    public static void main(String[] args) {
        System.out.println(path("", 3, 3));
    }
    static ArrayList<String> path(String p, int r, int c){
        if (r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();

        if (r>1){
            list.addAll( path(p + 'D', r - 1, c));
        }
        if (c > 1){
            list.addAll(path(p + 'R', r, c - 1));
        }

        return list;
    }
}

class pathInListDiag{
    public static void main(String[] args) {
        System.out.println(path("", 3, 3));
    }
    static ArrayList<String> path(String p, int r, int c){
        if (r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();

        if (r>1 && c>1){
            list.addAll( path(p + 'D', r - 1, c-1));
        }
        if (r>1){
            list.addAll( path(p + 'V', r - 1, c));
        }
        if (c > 1){
            list.addAll(path(p + 'H', r, c - 1));
        }

        return list;
    }
}