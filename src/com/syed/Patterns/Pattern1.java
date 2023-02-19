package com.syed.Patterns;

import java.util.Scanner;

public class Pattern1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i<=n; i++){
            for (int j = 1; j<=n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

class Pattern2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i<=n; i++){
            for (int j =1; j<=n-i+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

class Pattern3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i<=n; i++){
            for (int j =1; j<=i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
}

class Pattern4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxcol;
        for (int i = 1; i<2*n; i++){
            maxcol = (i <= n) ? i : ((2 * n) - i);
            for (int j = 0; j< maxcol; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
