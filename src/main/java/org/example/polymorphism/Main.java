package org.example.polymorphism;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shaps> shapes = new ArrayList<>();
        shapes.add(new Circle());
        shapes.add(new Square());

        for(Shaps shap:shapes){
            shap.draw();
        }
    }
}
