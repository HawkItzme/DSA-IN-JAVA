package com.syed.fibonacci;

import java.util.Scanner;

//This will give the value  of entered number of the series.
public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0;
        int b = 1;
        int count = 2;
        while (count <= n) {
            int temp = b;
            b = b + a;
            a = temp;
            count++;
        }
        System.out.println(b);
    }
}

//This will print the whole series.
class FibonacciNumber {
    static void Fibonacci(int n)
    {
        int num1 = 0, num2 = 1, counter = 0;
        while(counter < n)
        {
            System.out.print(num1+" ");
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
            counter = counter + 1;
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter any Number:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        Fibonacci(n);
    }
}