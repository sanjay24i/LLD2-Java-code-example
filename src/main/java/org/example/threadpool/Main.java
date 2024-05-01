package org.example.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args){
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 1; i <=100; i++){
            final int current = i;
            service.execute(()-> System.out.println(Thread.currentThread().getName() + ":" + current));
        }
        service.shutdown();
    }
}
