package org.example.callable;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
       // Callable<Integer> task = new CallableTask();
        ExecutorService executor = Executors.newSingleThreadExecutor();
      //  Future<Integer> result = executor.submit(task);

        Future<Integer> result = executor.submit(()->{
            System.out.println("This is callable");
            return 1;
        });
        Integer value = result.get();
        System.out.println(value);
        executor.shutdown();
    }
}
