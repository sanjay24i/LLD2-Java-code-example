package org.example.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Person> people = new ArrayList<>();
        people.add(new Person("Sanjay", 42));
        people.add(new Person("Jamana", 33 ));
        people.add(new Person("Vinod", 38));
        // Collections.sort(people);
        System.out.println(people);
        people.sort(new AgeComparator());
        System.out.println(people);
    }
}
