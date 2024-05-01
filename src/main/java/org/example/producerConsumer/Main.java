package org.example.producerConsumer;

public class Main {
    public static void main(String[] args){
        Store store = new Store(3);
        /*
        // Creating thread by using individual classes for producer and consumer
        Producer producerTask = new Producer(store);
        Consumer consumerTask = new Consumer(store);
        Thread producerThread = new Thread(producerTask);
        Thread consumerThread = new Thread(consumerTask);*/

        Thread producerThread = new Thread(()->{

                try {
                    for(int i = 1; i <= 6; i++){
                        store.produce(i);
                    }
                } catch (InterruptedException e) {
                    // handle exception
                }

        });
        Thread consumerThread = new Thread(()->{
                try {
                    for(int i = 1; i <= 6; i++){
                    store.consume();
                    }
                } catch (InterruptedException e) {
                    // handle exception
                }

        });

        producerThread.start();
        consumerThread.start();
    }
}
