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

//DIAMOND
class Pattern5{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxcol;
        for (int i = 1; i < 2*n; i++ ){
            maxcol = (i <= n)? i : ((2*n) - i);
            int space = n - maxcol;
            for (int a = 1; a<=space; a++){
                System.out.print(" ");
            }
            for (int j = 1; j <= maxcol; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

class Pattern6{
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i<=n; i++){
            for(int a  = 1; a <= n-i; a++){
                System.out.print(" ");
            }
            for (int col = i; col>= 1; col--){
                System.out.print(col);
            }
            for (int col = 2; col<= i; col++){
                System.out.print(col);
            }
            System.out.println( );
        }
    }
}

class Pattern7{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i<=2*n; i++){
            int c = (i > n)? 2*n - i : i;
            for (int a = 1; a <= n - c; a++) {
                System.out.print(" ");
            }
            for (int col = c; col >= 1; col--) {
                System.out.print(col);
            }
            for (int col = 2; col <= c; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
}

class Pattern8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = 2 * n;
        for (int i = 0; i <= p - 2; i++) {
            for (int j = 0; j <= p - 2; j++) {
                int pri = n - Math.min(Math.min(i, j), Math.min(p - 2 - i, p - 2 - j));
                if (pri > 1) {
                    System.out.print(pri + " ");
                }else
                    System.out.print("1 ");

            }
            System.out.println(" ");
        }
    }
}
