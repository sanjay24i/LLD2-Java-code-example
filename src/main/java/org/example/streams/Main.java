package org.example.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args){
        List<String> list = List.of("Sanjay", "vinod", "Rajesh");
        list.stream().filter((item)-> item.startsWith("S")).forEach(System.out::println);
    }
}


/*System.out::println is a method reference in Java. It's a shorthand way of referring to a method without actually invoking it.

In this case, System.out refers to the PrintStream object associated with the standard output stream, and println is the println method of PrintStream. So, System.out::println refers to the println method of the System.out object.

In the context of the code snippet provided earlier, System.out::println is used as a parameter to the forEach method of the stream. This means that for each element processed by the stream, the println method of System.out will be called to print that element to the standard output. It's a concise way of writing a lambda expression that takes an argument and invokes a method on it.*/
