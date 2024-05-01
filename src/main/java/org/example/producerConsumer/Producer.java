package org.example.producerConsumer;

public class Producer implements Runnable {
    Store store;
    Producer(Store store){
        this.store = store;
    }

    public void run(){

            try {
                for(int i = 1; i <= 6; i++){
                store.produce(i);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

    }
}
