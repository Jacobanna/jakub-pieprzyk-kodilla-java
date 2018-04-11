package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if(result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();
        int addition = calculator.add(5,3);
        if(addition == 8){
            System.out.println("Calculator add(int a, int b) OK");
        } else {
            System.out.println("Calculator add(int a, int b) ERROR");
        }

        int subtraction = calculator.subtract(5,3);
        if(subtraction == 2){
            System.out.println("Calculator subtract(int a, int b) OK");
        } else {
            System.out.println("Calculator subtract(int a, int b) ERROR");
        }

    }
}
