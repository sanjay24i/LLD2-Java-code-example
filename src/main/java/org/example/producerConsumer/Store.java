package org.example.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class Store {
    Queue<Integer> itemList;
    private final int bufferCount;

    Store(int bufferCount){
        itemList = new LinkedList<>();
        this.bufferCount = bufferCount;
    }
    public void addMenu(int item){
        itemList.add(item);
    }
    public synchronized void produce(int item) throws InterruptedException {
        while(itemList.size() == bufferCount){
            System.out.println("Buffer is full producer is waiting for consumer");
            wait();
        }
        addMenu(item);
        System.out.println("Produced item");
        notifyAll();
    }

    public synchronized void consume() throws InterruptedException {
        //  We are using while instead of if read notes below
        while(itemList.isEmpty() ) {
            System.out.println("Store is empty consumer is waiting for producer");
            wait();
        }
        int item = itemList.poll();
        System.out.println("Consumed" + item );
        notifyAll();
    }
}


/*
// Why we use while instead if at the time of wating for thread
Using while instead of if when waiting on a condition variable (wait()) is a common practice in concurrent programming to guard against spurious wake-ups.

        Here's why:

Spurious Wake-ups: Sometimes, a thread can wake up from waiting (wait()) without being explicitly notified. These wake-ups are known as spurious wake-ups and can happen due to various reasons, including system noise or thread scheduling mechanisms.
Correctness: Using a while loop ensures that even if a thread wakes up spuriously, it will recheck the condition before proceeding. If you use an if statement and a spurious wake-up occurs, the thread might proceed erroneously without the necessary condition being satisfied.
Concurrency: In a multi-threaded environment, other threads could modify the shared state between the time the waiting thread wakes up and when it resumes execution. The while loop allows the thread to recheck the condition to ensure it's still valid before proceeding, which helps prevent race conditions and ensures correctness.
Therefore, using while instead of if for checking conditions after a wait() call is a defensive programming technique to ensure correctness and robustness in concurrent code.*/
