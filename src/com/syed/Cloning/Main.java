package com.syed.Cloning;

public class Main{
    public static void main(String[] args) throws CloneNotSupportedException {
        Human saquib = new Human(34, "Saquib");
        //Human raj = new Human(saquib);

        Human twin = (Human)saquib.clone(); // this is a shallow copy


        System.out.println(twin.age + " " + twin.name);
    }

}
