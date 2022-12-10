package com.syed.CalciUsingLamdaFunc;

//We can assign Lamda Function to a variable of type interface!!
public class LamdaFunction {
    public static void main(String[] args) {
        Operation sum = (a,b) -> a+b;
        Operation sub = (a,b) -> a-b;
        Operation prod = (a,b) -> a*b;

        LamdaFunction myCalci = new LamdaFunction();
        System.out.println(myCalci.operate(5, 3, sum));
        System.out.println(myCalci.operate(5, 3, sub));
        System.out.println(myCalci.operate(5, 3, prod));
    }
    private int operate(int a, int b, Operation op){
        return op.operation(a,b);
    }

}
interface Operation{
    int operation(int a, int b);
}