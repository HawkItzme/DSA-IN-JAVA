package com.syed.patterns_demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Producer_Consumer_without_using_BlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Item> queue = new ArrayBlockingQueue(10);

        //Producer
        final Runnable producer = () -> {
            while (true){
                queue.put(createItem());  //threads blocks if queue is full
            }
        };
        new Thread(producer).start();
        new Thread(producer).start();

        //Consumer
        final Runnable consumer = () -> {
            while (true){
                Item i = queue.take();  //threads blocks if queue is empty
                process(i);
            }
        };
        new Thread(consumer).start();
        new Thread(consumer).start();

        Thread.sleep(1000);
    }
}
