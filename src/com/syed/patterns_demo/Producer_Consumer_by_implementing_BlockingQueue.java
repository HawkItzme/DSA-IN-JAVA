package com.syed.patterns_demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Producer_Consumer_by_implementing_BlockingQueue {
    private int max;
    private Queue queue;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition nonEmpty = lock.newCondition();
    private Condition nonFull = lock.newCondition();

    public MyBlockingQueue(int size){
        queue = new LinkedList();
        this.max = size;
    }

    public void put(E e){
        lock.lock();
        try {
            while (queue.size() == max){
                nonFull.await();
            }
            queue.add(e);
            nonEmpty.signalAll();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }finally {
            lock.unlock();
        }
    }

    // Using Wait-Notify instead of Locks & Condition

    private Object nonEmptyObj = new Object();
    private Object nonFullObj = new Object();
    public synchronized void putUsingWaitNotify(E e){
        try {
            while (queue.size() == max){
                nonFullObj.wait();
            }
            queue.add(e);
            nonEmptyObj.notifyAll();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public E take( ){
        lock.lock();
        try {
            while (queue.size() == 0){
                nonEmpty.await();
            }
            E item = queue.remove();
            nonFull.signalAll();
            return item;
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }finally {
            lock.unlock();
        }
    }

    // Using Wait-Notify instead of Locks & Condition
    public synchronized E take( ){
        try {
            while (queue.size() == 0){
                nonEmptyObj.wait();
            }
            E item = queue.remove();
            nonFullObj.notifyAll();
            return item;
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
