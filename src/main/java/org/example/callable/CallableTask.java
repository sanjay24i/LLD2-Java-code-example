package org.example.callable;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {
    @Override

    public Integer call(){
        System.out.println("this is callable");
        return 1;
    }
}
