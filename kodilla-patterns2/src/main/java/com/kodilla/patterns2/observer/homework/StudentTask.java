package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class StudentTask implements Observable {
    private final String name;
    private final List<String> messages;
    private final List<Observer> observers;

    public StudentTask(String name) {
        this.name = name;
        messages = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void addTask(String message) {
        messages.add(message);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public String getName() {
        return name;
    }

    public List<String> getMessages() {
        return messages;
    }
}
