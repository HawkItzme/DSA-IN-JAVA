package com.syed.comparing;

public class Main {
    public static void main(String[] args) {
        Student saquib = new Student(10, 90);
        Student raj = new Student(11, 99);

        if (saquib.compareTo(raj) < 0){
            System.out.println("Raj has more makrs");
        }

    }
}
