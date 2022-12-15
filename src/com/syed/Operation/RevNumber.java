package com.syed.Operation;

import java.util.Scanner;

public class RevNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int rnum = 0;
        while (num>0){
            int rem = num % 10;
            num/=10;
            rnum = rnum * 10 + rem;
        }
        System.out.println(rnum);
    }
}
