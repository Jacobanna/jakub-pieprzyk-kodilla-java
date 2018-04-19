package com.kodilla.stream;


import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.Book2;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.book.BookDirectory2;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.lambda.Executor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.kodilla.stream.forumuser.Sex.M;

public class StreamMain {
    public static void main(String[] args){
//        7.1 - LAMBDA EXPRESSION INTRODUCTION
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
//        PoemBeautifier poemBeautifier = new PoemBeautifier();
//        poemBeautifier.beautify("Ala Ma Kota",(stringToDecorate) -> "AAA" + stringToDecorate + "AAA");
//        poemBeautifier.beautify("Ala Ma Kota", (stringToDecorate) -> stringToDecorate.toUpperCase());
//        poemBeautifier.beautify("Ala Ma Kota", (stringToDecorate) -> stringToDecorate.toLowerCase());
//        poemBeautifier.beautify("Ala Ma Kota", (stringToDecorate) -> stringToDecorate + " " + 173);

//        7.2 - STREAM INTRODUCTION
//        System.out.println("Using Stream to generate even numbers from 1 to 20");
//        NumbersGenerator.generateEven(20);

//        7.3 stream(), filter(), map(), collect()

//        stream(), filter() and map()
//        People.getList().stream()
//                .forEach(System.out::println);

//        People.getList().stream()
//                .map(s -> s.toUpperCase())
//                .forEach(System.out::println);

//        People.getList().stream()
//                .map(String::toUpperCase)
//                .forEach(s -> System.out.println(s));

//        People.getList().stream()
//                .filter(s -> s.length() > 11)
//                .forEach(System.out::println);

//        People.getList().stream()
//                .map(String::toUpperCase)
//                .filter(s -> s.length() > 11)
//                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
//                .filter(s -> s.substring(0,1).equals("M"))
//                .forEach(System.out::println);

//        BookDirectory bookDirectory = new BookDirectory();
//        bookDirectory.getList().stream()
//                .filter(book -> book.getYearOfPublication() > 2005)
//                .forEach(System.out::println);

//        collect()
//        BookDirectory bookDirectory = new BookDirectory();
//        List<Book> resultListOfBooks = bookDirectory.getList().stream()
//                .filter(book -> book.getYearOfPublication() > 2005)
//                .collect(Collectors.toList());
//        System.out.println("# elements: " + resultListOfBooks.size());
//        resultListOfBooks.stream()
//                .forEach(System.out::println);

//        BookDirectory2 bookDirectory2 = new BookDirectory2();
//        Map<String, Book2> resultMapOfBooks = bookDirectory2.getList().stream()
//                .filter(book -> book.getYearOfPublication() > 2005)
//                .collect(Collectors.toMap(Book2::getSignature, book -> book));
//        System.out.println("# elements: " + resultMapOfBooks.size());
//        resultMapOfBooks.entrySet().stream()
//                .map(entry -> entry.getKey() + ": " + entry.getValue())
//                .forEach(System.out::println);

//        BookDirectory2  bookDirectory2 = new BookDirectory2();
//        String resultStringOfBooks = bookDirectory2.getList().stream()
//                .filter(book -> book.getYearOfPublication() > 2005)
//                .map(Book2::toString)
//                .collect(Collectors.joining(",\n","<<",">>"));
//        System.out.println(resultStringOfBooks);

//        TASK 7.3
        Forum forum = new Forum();
        Map<Integer, ForumUser> resultMapOfForumUsers = forum.getForumUsersList().stream()
                .filter(user -> user.getSex() == M)
                .filter(user -> user.getBirthDate().isBefore(LocalDate.now().minusYears(20)))
                .filter(user -> user.getPublishedPosts() > 0)
                .collect(Collectors.toMap(user -> user.getUserId(), user -> user));

        System.out.println("Number of male users at least 20 years old with at least a single post: " + resultMapOfForumUsers.size());
        resultMapOfForumUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

    }
}
