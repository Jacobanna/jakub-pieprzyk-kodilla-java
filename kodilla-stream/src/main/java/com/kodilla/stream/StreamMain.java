package com.kodilla.stream;


import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.lambda.Executor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args){
//        FIRST
//        Processor processor = new Processor();
//        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
//        processor.execute(executeSaySomething);

//        SECOND
//        Processor processor = new Processor();
//        Executor codeToExecute = () -> System.out.println("This is an example test.");
//        processor.execute(codeToExecute);

//        THIRD
//        Processor processor = new Processor();
//        processor.execute(() -> System.out.println("This is an example test"));

//        FOURTH
//        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
//        System.out.println("Calculating expressions with lambdas");
//        expressionExecutor.executeExpression(10,5,(a, b) -> a + b);
//        expressionExecutor.executeExpression(10,5,(a, b) -> a - b);
//        expressionExecutor.executeExpression(10,5,(a, b) -> a * b);
//        expressionExecutor.executeExpression(10,5,(a, b) -> a / b);

//        FIFTH
//        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
//        System.out.println("Calculating expressions with method references");
//        expressionExecutor.executeExpression(10,5, FunctionalCalculator::addAToB);
//        expressionExecutor.executeExpression(10,5, FunctionalCalculator::subBFromA);
//        expressionExecutor.executeExpression(10,5, FunctionalCalculator::multiplyAByB);
//        expressionExecutor.executeExpression(10,5, FunctionalCalculator::divideAByB);

//        TASK 7.1 - POEM BEAUTIFIER
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Ala Ma Kota",(stringToDecorate) -> "AAA" + stringToDecorate + "AAA");
        poemBeautifier.beautify("Ala Ma Kota", (stringToDecorate) -> stringToDecorate.toUpperCase());
        poemBeautifier.beautify("Ala Ma Kota", (stringToDecorate) -> stringToDecorate.toLowerCase());
        poemBeautifier.beautify("Ala Ma Kota", (stringToDecorate) -> stringToDecorate + " " + 173);

    }
}
