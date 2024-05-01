package org.example.producerConsumer;

public class Consumer implements Runnable {
    Store store;
    Consumer(Store store){
        this.store = store;
    }

    public void run(){

            try {
                for(int i = 1; i <= 6; i++){
                store.consume();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

    }
}
