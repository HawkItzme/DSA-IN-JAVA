package com.syed.generics;

import java.util.Arrays;
import java.util.List;

public class WildCardExample<T extends Number> {
    private Object[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public WildCardExample() {
        this.data = new Object[DEFAULT_SIZE];
    }

    //Here we can pass Number along with int/ float..
    public void getList(List<? extends Number> list){
        //task
    }

    public void add(T num){
        if (isFull()){
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        Object[] temp = new Object[data.length * 2];

        for (int i = 0; i< data.length; i++){
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isFull(){
        return size == data.length;
    }

    public T remove(){
        T removed = (T) data[--size];
        return removed;
    }

    public T get(int index){
        return (T) data[index];
    }

    public int size(){
        return size;
    }

    public void set(int index, T value){
        data[index] = value;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {

        WildCardExample<Integer> list = new WildCardExample<>();
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list);
    }
}
