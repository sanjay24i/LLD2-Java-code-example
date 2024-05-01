package org.example.concurrency;

import java.util.concurrent.locks.Lock;

public class Main {
    public static void main(String[] args){
        /*Thread t1 = new Thread(()->{
           for(int i = 2; i <= 100; i = i+2) {
               System.out.println("t1: " + i);
           }
        });
        System.out.println(" ");
        Thread t2 = new Thread(()->{
            for(int i = 1; i <= 100; i = i+2) {
                System.out.println("t2: " + i);
            }
        });

        t1.start();
        t2.start();*/

        // Using synchronised
        /*
        * In Java, notify() and wait() are methods used for inter-thread communication in synchronization. Here's what they do:
            notify(): This method is used to wake up one of the threads that are waiting on the object's monitor. If multiple threads are waiting, it's not guaranteed which one will be awakened. notify() doesn't release the lock on the object's monitor.
            wait(): This method is used to make the current thread wait until another thread invokes notify() or notifyAll() on the same object. The thread then waits until it can re-obtain the lock on the object's monitor before it can proceed.
                    Now, regarding whether notify() is required before wait(): yes, it's generally necessary to have a call to notify() or notifyAll() before wait(). Here's why:

             notify() or notifyAll() tells the waiting thread(s) that some condition they are waiting for has changed and they should check again.
              wait() releases the lock on the object's monitor and puts the current thread into the "waiting" state until it's notified.
            Without a preceding notify(), the waiting thread would not be awakened, and it might remain in the waiting state indefinitely, causing a deadlock.
        So, in the context of inter-thread communication and synchronization, it's typically necessary to call notify() or notifyAll() before wait() to ensure proper coordination between threads.
      
        * */
        Object lock = new Object();

        Thread t1 = new Thread(()->{
            synchronized (lock){
                for(int i = 2; i <= 100; i = i+2) {
                    System.out.println("t1: " + i);
                    try {
                        lock.notify();
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }

        });

        Thread t2 = new Thread(()->{
            synchronized (lock){
                for(int i = 1; i <= 100; i = i+2) {
                    System.out.println("t2: " + i);
                    try {
                        lock.notify();
                        if (i < 99) {
                            lock.wait(); // Wait for the other thread to notify
                        }
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }

        });

        t1.start();
        t2.start();
    }
}
