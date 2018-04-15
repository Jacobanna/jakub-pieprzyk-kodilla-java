package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {
    private ArrayList<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape){
        shapes.add(shape);
    }

    public boolean removeFigure(int n){
        if(n>=0 && n<shapes.size()){
            shapes.remove(n);
            return true;
        }
        return false;
    }

    public Shape getFigure(int n){
        Shape figure = shapes.get(n);
        return figure;
    }

    public String showFigures(){
        String result = "";
        int count = 0;
        while(count < shapes.size()){
            Shape temp = shapes.get(count);
            result += temp.getShapeName() + "\n";
            count++;
        }
        return result;
    }
}
